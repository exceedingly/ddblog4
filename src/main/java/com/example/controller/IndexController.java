package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/* 类注解 */
@Api(value = "类注解")
@Controller
public class IndexController {

    /* 方法注解 */
    @ApiOperation(value = "方法注解", notes = "方法注解笔记")
    @PostMapping("/123")
    @ResponseBody
    public String indexController(@ApiParam(value = "参数注解" , required=true ) String test){
        return "index";
    }

    /* 方法注解 */
    @ApiOperation(value = "方法注解", notes = "方法注解笔记")
    @PostMapping("/test")
    @ResponseBody
    public String testController(@ApiParam(value = "参数注解test"  ) String test,@ApiParam(value = "参数注解test2"  ) String test2){
        return "test";
    }
}
