package com.xdu.cloud.pojo.VO;

import java.util.Date;

public class MeetVO {

    /**
     * 电子车牌
     */
    private String eid;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 地点ID
     */
    private String placeID;

    /**
     * 地点名称
     */
    private String address;

    /**
     * 相遇电子车牌
     */
    private String meetEid;

    /**
     * 相遇次数
     */
    private String times;


    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPlaceID() {
        return placeID;
    }

    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMeetEid() {
        return meetEid;
    }

    public void setMeetEid(String meetEid) {
        this.meetEid = meetEid;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
