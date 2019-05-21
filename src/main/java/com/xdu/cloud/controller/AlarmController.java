package com.xdu.cloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "AlarmController")
@Api(value = "警报模块API", tags = {"Alarm Controller"})
@RequestMapping("/alarm")
public class AlarmController extends BasicController{

    @ApiImplicitParam(name = "model", value = "model", required = true, dataType = "Model", paramType = "query")
    @ApiResponses({ @ApiResponse(code = 502, message = "Invalid Session Token"), @ApiResponse(code = 200, message = "ok") })
    @GetMapping("")
    public String alarm(Model model) {
        model.addAttribute("title", "实时报警");
        model.addAttribute("hint", "此为加分项，动手能力强的同学可以尝试完成。");
        return "alarm";
    }
    
}
