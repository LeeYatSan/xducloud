package com.xdu.cloud.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController(value = "RecordController")
@Api(value = "记录模块API", tags = {"Record Controller"})
@RequestMapping("/record")
public class RecordController extends BasicController{
    
//    private final RecordRepository repository;
//
//    @Autowired
//    public RecordController(RecordRepository repository) {
//        this.repository = repository;
//    }
//
//    @ApiImplicitParam(name = "model", value = "model", required = true, dataType = "Model", paramType = "query")
//    @ApiResponses({ @ApiResponse(code = 502, message = "Invalid Session Token"), @ApiResponse(code = 200, message = "ok") })
//    @GetMapping("")
//    public String get(Model model) {
//        model.addAttribute("title", "过车统计");
//        model.addAttribute("condition", new Record());
//        return "record";
//    }
//
//    @ApiImplicitParams({@ApiImplicitParam(name = "model", value = "model", required = true, dataType = "Model", paramType = "query"),
//                    @ApiImplicitParam(name = "record", value = "record", required = true, dataType = "Record", paramType = "query")})
//    @ApiResponses({ @ApiResponse(code = 502, message = "Invalid Session Token"), @ApiResponse(code = 200, message = "ok") })
//    @PostMapping("")
//    public String post(Model model, Record record) {
//        List<Record> recordList = repository.findAllByRecord(record);
//        model.addAttribute("recordList", recordList);
//        model.addAttribute("title", "过车统计");
//        model.addAttribute("condition", record);
//        return "record";
//    }
    
}
