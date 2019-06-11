package com.xdu.cloud.controller;

import com.xdu.cloud.common.JSONResult;
import com.xdu.cloud.service.Impl.MyHBaseServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "RecordController")
@Api(value = "记录模块API", tags = {"Record Controller"})
public class RecordController extends BasicController{


    @Autowired
    MyHBaseServiceImpl myHBaseService;

    @ApiOperation(value = "根据电子车牌eid获取信息", notes = "根据电子车牌eid获取信息")
    @ApiImplicitParam(name = "eid", value = "eid", required = true, dataType = "String", paramType = "query")
    @ApiResponses({ @ApiResponse(code = 502, message = "Missing parameter"),
                    @ApiResponse(code = 200, message = "ok") })
    @GetMapping("/searchByEID")
    @CrossOrigin
    public JSONResult getAllRecordsByUserID(String eid){
        System.err.println("searchByEID 请求接入：" + System.currentTimeMillis());
        if(eid == null || eid.equals("")){
            return JSONResult.errorMsg("Missing parameter");
        }
        return JSONResult.ok(myHBaseService.searchByEID(eid));
    }


    @ApiOperation(value = "根据采集地点ID或名字查询接口", notes = "根据采集地点ID或名字查询接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "idaddress", value = "idaddress", required = true, dataType = "String", paramType = "query"),
                        @ApiImplicitParam(name = "startTime", value = "startTime", required = true, dataType = "String", paramType = "query"),
                        @ApiImplicitParam(name = "endTime", value = "endTime", required = true, dataType = "String", paramType = "query"),
                        @ApiImplicitParam(name = "method", value = "method", required = true, dataType = "boolean", paramType = "query")})
    @ApiResponses({ @ApiResponse(code = 502, message = "Missing parameter"),
            @ApiResponse(code = 200, message = "ok") })
    @GetMapping("/searchByPlaceIDOrAddress")
    @CrossOrigin
    public JSONResult getAllRecordsByPlaceIDOrAddress(String idaddress, String startTime, String endTime, boolean method){

        System.err.println("searchByPlaceIDOrAddress 请求接入：" + System.currentTimeMillis());
        if(idaddress == null || idaddress.equals("") || startTime == null
                || startTime.equals("") || endTime == null || endTime.equals("")){
            return JSONResult.errorMsg("Missing parameter");
        }
        System.err.println("idaddress : " + idaddress);
        System.err.println("startTime : " + startTime);
        System.err.println("endTime : " + endTime);
        System.err.println("method : " + method);
        if(method){
            return JSONResult.ok(myHBaseService.searchByPlaceID(idaddress, startTime, endTime));
        }
        else {
            return JSONResult.ok(myHBaseService.searchByAddress(idaddress, startTime, endTime));
        }
    }


    @ApiOperation(value = "根据电子车牌eid获取相遇信息", notes = "根据电子车牌eid获取相遇信息")
    @ApiImplicitParam(name = "eid", value = "eid", required = true, dataType = "String", paramType = "query")
    @ApiResponses({ @ApiResponse(code = 502, message = "Missing parameter"),
            @ApiResponse(code = 200, message = "ok") })
    @GetMapping("/searchMeet")
    @CrossOrigin
    public JSONResult getMeetRecordByEID(String eid){

        System.err.println("searchMeet 请求接入：" + System.currentTimeMillis());
        if(eid == null || eid.equals("")){
            return JSONResult.errorMsg("Missing parameter");
        }
        return JSONResult.ok(myHBaseService.searchMeetEvent(eid));
    }


    @ApiOperation(value = "获取非法数据信息", notes = "获取非法数据信息")
    @ApiResponse(code = 200, message = "ok")
    @GetMapping("/searchIllegalInfo")
    @CrossOrigin
    public JSONResult getIllegalInfo(){

        System.err.println("searchIllegalInfo 请求接入：" + System.currentTimeMillis());
        return JSONResult.ok(myHBaseService.searchIlligalInfo());
    }


    @ApiOperation(value = "根据placeID获取车辆统计信息", notes = "根据placeID获取车辆统计信息")
    @ApiResponse(code = 200, message = "ok")
    @GetMapping("/searchVehicleCount")
    @CrossOrigin
    public JSONResult getVehicleCount(String placeID){

        System.err.println("searchVehicleCount 请求接入：" + System.currentTimeMillis());
        if(placeID == null){
            return JSONResult.errorMsg("Missing parameter");
        }
        return JSONResult.ok(myHBaseService.searchVehicleCount(placeID));
    }
}
