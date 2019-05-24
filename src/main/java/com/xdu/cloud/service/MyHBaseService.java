package com.xdu.cloud.service;
import com.xdu.cloud.pojo.*;
import com.xdu.cloud.pojo.VO.MeetVO;
import com.xdu.cloud.pojo.VO.PlaceVO;

import java.util.List;
import java.util.Map;

public interface MyHBaseService {
    /**
     * 根据EID查询车辆信息
     */
    public List<Record> searchByEID(String EID);


    /**
     * 根据探测地点ID查询车辆信息
     */
    public PlaceVO serchByPlaceID(String PlaceId);

    /**
     * 根据探测地点名称查询车辆信息
     */
    public PlaceVO searchByAddress(String Address);

    /**
     * 根据车辆ID查询相遇信息
     */
    public MeetVO searchMeetEvent(String EID);

    /**
     * 查询非法数据
     */
    public List<Record> searchIlligalInfo();

    /**
     * 查询轨迹
     */
    public List<Record> searchTrace(String EID,String timeStart,String timeEnd);


}
