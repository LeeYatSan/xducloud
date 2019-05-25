package com.xdu.cloud.pojo.VO;


public class MeetVO {

    /**
     * 电子车牌
     */
    private String eid;

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
