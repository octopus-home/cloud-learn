package com.octopus.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试接口")
@RestController
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(value="获取信息", notes="hello note")
    public String toString(@RequestParam("msg") String msg) {
        return "hello " + msg;
    }
}
