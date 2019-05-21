package com.xdu.cloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "IndexController")
@Api(value = "首页模块API", tags = {"Index Controller"})
@RequestMapping("/")
public class IndexController extends BasicController{

    @ApiImplicitParam(name = "model", value = "model", required = true, dataType = "Model", paramType = "query")
    @ApiResponses({ @ApiResponse(code = 502, message = "Invalid Session Token"), @ApiResponse(code = 200, message = "ok") })
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "项目介绍");
        return "index";
    }

    @ApiImplicitParam(name = "model", value = "model", required = true, dataType = "Model", paramType = "query")
    @ApiResponses({ @ApiResponse(code = 502, message = "Invalid Session Token"), @ApiResponse(code = 200, message = "ok") })
    @GetMapping("bmap")
    public String mapview(Model model) {
        model.addAttribute("title", "百度地图示例");
        return "bmap";
    }
    
}
