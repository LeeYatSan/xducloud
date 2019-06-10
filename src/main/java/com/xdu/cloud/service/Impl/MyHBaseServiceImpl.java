package com.xdu.cloud.service.Impl;

import com.xdu.cloud.pojo.Record;
import com.xdu.cloud.pojo.VO.MeetVO;
import com.xdu.cloud.pojo.VO.PlaceVO;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyHBaseServiceImpl extends HBaseServiceImpl{
    @Value("${HBase.nodes}")
    private String nodes;
    @Value("${HBase.maxsize}")
    private String maxsize;

    public MyHBaseServiceImpl(Configuration conf) {
        super(conf);
    }

    public static Date stampToDate(String s){

        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time= new Long(s);
        String d = format.format(time*1000);
        Date date= null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 根据EID查询车辆信息
     *
     * @param EID
     */
    public List<Record> searchByEID(String EID) {
        Scan scan = new Scan();
        RowFilter rf = new RowFilter(CompareFilter.CompareOp.EQUAL,
                new SubstringComparator(EID));
        scan.setFilter(rf);
        Map<String, Map<String, String>> resM = queryData("record",scan);
        List<Record> resR = new ArrayList<Record>();
        resM.forEach((k,v)->{
            String[] tempRowKey = k.split("##");
            Record record = new Record();
            record.setEid(EID);
            record.setPlaceID(tempRowKey[0]);
            record.setTime(stampToDate(tempRowKey[1]));
            record.setAddress(v.get("address"));
            record.setLatitude(v.get("latitude"));
            record.setLongitude(v.get("longitude"));
            resR.add(record);
        });

        return resR;
    }
    /**
     * 根据规则监控,空参数使用空串
     *
     */
    public List<Record> searchByRule(String EID,String PlaceID) {
        List<Record> Res = new ArrayList<Record>();
        if(!EID.isEmpty()){
            List<Record> tres=searchByEID(EID);
            tres.forEach((k)->{
                if (k.getTime().after(new Date())){
                    if (PlaceID.isEmpty() || PlaceID.equals(k.getPlaceID()))
                        Res.add(k);
                }
            });
            return Res;
        }else if (!PlaceID.isEmpty()){
            PlaceVO tres=searchByPlaceID(EID,String.valueOf(new Date().getTime()-10),String.valueOf(new Date().getTime()+10));
            tres.getRecords().forEach((k)->{
                if (EID.isEmpty() || k.getEid().equals(EID))
                    Res.add(k);
            });
        }else{
            return Res;
        }
        return Res;
    }



    
    /**
     * 根据探测地点ID查询车辆信息
     *
     * @param PlaceId
     */
    public PlaceVO searchByPlaceID(String PlaceId,String timeStart,String timeEnd) {
        Scan scan = new Scan();
        RowFilter rf = new RowFilter(CompareFilter.CompareOp.EQUAL,
                new BinaryPrefixComparator(Bytes.toBytes(PlaceId+"##")));
        scan.setFilter(rf);
        Map<String, Map<String, String>> resM = queryData("record",scan);
        List<Record> resR = new ArrayList<Record>();
        PlaceVO resV = new PlaceVO();
        resM.forEach((k,v)->{
            String[] tempRowKey = k.split("##");
            Record record = new Record();
            record.setEid(tempRowKey[2]);
            record.setPlaceID(tempRowKey[0]);
            record.setTime(stampToDate(tempRowKey[1]));
            record.setAddress(v.get("address"));
            record.setLatitude(v.get("latitude"));
            record.setLongitude(v.get("longitude"));
            if (Integer.valueOf(timeStart)<=Integer.valueOf(tempRowKey[1]) && Integer.valueOf(timeEnd)>=Integer.valueOf(tempRowKey[1])){
                resR.add(record);
            }
        });
        if (!resR.isEmpty()) {
            resV.setCarNum(String.valueOf(resR.size()));
            resV.setAddress(resR.get(0).getAddress());
            resV.setEndTime(stampToDate(timeEnd));
            resV.setStartTime(stampToDate(timeStart));
            resV.setPlaceID(PlaceId);
            resV.setRecords(resR);
        }

        return resV;
    }

    /**
     * 根据探测地点名称查询车辆信息
     *
     * @param Address
     */
    public PlaceVO searchByAddress(String Address,String timeStart,String timeEnd) {
        Scan scan = new Scan();
        SingleColumnValueFilter scvf= new SingleColumnValueFilter(Bytes.toBytes("info"), Bytes.toBytes("address"),
                CompareFilter.CompareOp.EQUAL,Address.getBytes());
        scvf.setFilterIfMissing(true);
        scan.setFilter(scvf);
        Map<String, Map<String, String>> resM = queryData("record",scan);
        List<Record> resR = new ArrayList<Record>();
        PlaceVO resV = new PlaceVO();
        resM.forEach((k,v)->{
            String[] tempRowKey = k.split("##");
            Record record = new Record();
            record.setEid(tempRowKey[2]);
            record.setPlaceID(tempRowKey[0]);
            record.setTime(stampToDate(tempRowKey[1]));
            record.setAddress(v.get("address"));
            record.setLatitude(v.get("latitude"));
            record.setLongitude(v.get("longitude"));
            if (Integer.valueOf(timeStart)<=Integer.valueOf(tempRowKey[1]) && Integer.valueOf(timeEnd)>=Integer.valueOf(tempRowKey[1])){
                resR.add(record);
            }
        });
        if (!resR.isEmpty()) {
            resV.setCarNum(String.valueOf(resR.size()));
            resV.setAddress(Address);
            resV.setEndTime(stampToDate(timeEnd));
            resV.setStartTime(stampToDate(timeStart));
            resV.setPlaceID(resR.get(0).getPlaceID());
            resV.setRecords(resR);
        }

        return resV;
    }

    /**
     * 根据车辆ID查询相遇信息
     *
     * @param EID
     */
    public List<MeetVO> searchMeetEvent(String EID) {
        Get get = new Get(Bytes.toBytes(EID));
        // 获取表
        Table table = null;
        List<MeetVO> resM = new ArrayList<>();
        try {
            table = getTable("MeetCount");
            Result hTableResult = table.get(get);
            if (hTableResult != null && !hTableResult.isEmpty()) {
                for (Cell cell : hTableResult.listCells()) {
                    MeetVO tmeetv0 = new MeetVO();
                    tmeetv0.setEid(EID);
                    tmeetv0.setMeetEid(Bytes.toString(cell.getQualifierArray(),
                            cell.getQualifierOffset(),
                            cell.getQualifierLength()));
                    tmeetv0.setTimes(Bytes.toString(cell.getValueArray(),
                            cell.getValueOffset(),
                            cell.getValueLength()));
                    resM.add(tmeetv0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        return resM;
    }

    /**
     * 查询非法数据
     */
    public List<Record> searchIlligalInfo() {
        return null;
    }

    /**
     * 查询轨迹
     *
     * @param EID
     * @param timeStart
     * @param timeEnd
     */
    public List<Record> searchTrace(String EID, String timeStart, String timeEnd) {
        return null;
    }
}
