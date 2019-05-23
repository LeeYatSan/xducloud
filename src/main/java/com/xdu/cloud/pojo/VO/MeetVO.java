package com.xdu.cloud.pojo.VO;

import java.util.Date;

public class MeetVO {

    /**
     * 电子车牌
     */
    private Long eid;

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
    private Integer placeID;

    /**
     * 地点名称
     */
    private String address;

    /**
     * 相遇电子车牌
     */
    private Long meetEid;

    /**
     * 相遇次数
     */
    private Integer times;

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
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

    public Integer getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMeetEid() {
        return meetEid;
    }

    public void setMeetEid(Long meetEid) {
        this.meetEid = meetEid;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
