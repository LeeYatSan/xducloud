package com.xdu.cloud.controller;

import com.xdu.cloud.common.JSONResult;
import com.xdu.cloud.service.MyHBaseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController(value = "RecordController")
@Api(value = "记录模块API", tags = {"Record Controller"})
@RequestMapping("/record")
public class RecordController extends BasicController{


    @Autowired
    MyHBaseService myHBaseService;

    @ApiOperation(value = "根据电子车牌eid获取信息", notes = "根据电子车牌eid获取信息")
    @ApiImplicitParam(name = "eid", value = "eid", required = true, dataType = "String", paramType = "query")
    @ApiResponses({ @ApiResponse(code = 502, message = "Missing parameter"),
                    @ApiResponse(code = 200, message = "ok") })
    @GetMapping("/searchByEID")
    public JSONResult getAllCardsByUserID(String eid){

        if(eid == null || eid.equals("")){
            return JSONResult.errorMsg("Missing parameter");
        }
        return JSONResult.ok(myHBaseService.searchByEID(eid));
    }
    
}
