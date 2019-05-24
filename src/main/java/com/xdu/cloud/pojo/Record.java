package com.xdu.cloud.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "车主信息")
public class Record {

    /**
     * 电子车牌
     */
    @ApiModelProperty(value = "eid")
    private String eid;

    /**
     * 记录时间
     */
    @ApiModelProperty(value = "time")
    private Date time;

    /**
     * 地点ID
     */
    @ApiModelProperty(value = "placeID")
    private String placeID;

    /**
     * 地点名称
     */
    @ApiModelProperty(value = "address")
    private String address;

    /**
     * 经度
     */
    @ApiModelProperty(value = "longitude")
    private String longitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "latitude")
    private String latitude;


    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}