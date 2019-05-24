package com.xdu.cloud.service.Impl;

import com.xdu.cloud.pojo.Record;
import com.xdu.cloud.pojo.VO.MeetVO;
import com.xdu.cloud.pojo.VO.PlaceVO;
import com.xdu.cloud.service.HBaseService;
import com.xdu.cloud.service.MyHBaseService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MyHBaseServiceImpl implements MyHBaseService {
    private HBaseService HBaseService;

    @Value("${HBase.nodes}")
    private String nodes;
    @Value("${HBase.maxsize}")
    private String maxsize;

    public static Date stampToDate(String s){
        long lt = new Long(s);
        Date date = new Date(lt);
        return date;
    }

    public MyHBaseServiceImpl(){
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum",nodes );
        conf.set("hbase.client.keyvalue.maxsize",maxsize);
        HBaseService = new HBaseServiceImpl();
        HBaseService.getConnection(conf);
    }
    /**
     * 根据EID查询车辆信息
     *
     * @param EID
     */
    @Override
    public List<Record> searchByEID(String EID) {
        Scan scan = new Scan();
        RowFilter rf = new RowFilter(CompareFilter.CompareOp.EQUAL,
                new SubstringComparator(EID));
        scan.setFilter(rf);
        Map<String, Map<String, String>> resM = HBaseService.queryData("Record",scan);
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
     * 根据探测地点ID查询车辆信息
     *
     * @param PlaceId
     */
    @Override
    public PlaceVO serchByPlaceID(String PlaceId) {
        return null;
    }

    /**
     * 根据探测地点名称查询车辆信息
     *
     * @param Address
     */
    @Override
    public PlaceVO searchByAddress(String Address) {
        return null;
    }

    /**
     * 根据车辆ID查询相遇信息
     *
     * @param EID
     */
    @Override
    public MeetVO searchMeetEvent(String EID) {
        return null;
    }

    /**
     * 查询非法数据
     */
    @Override
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
    @Override
    public List<Record> searchTrace(String EID, String timeStart, String timeEnd) {
        return null;
    }
}
