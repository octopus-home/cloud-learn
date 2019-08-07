package com.octopus.controller;

import com.octopus.api.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Value("${server.port}")
    String port;

    @Autowired
    private FeignService feignService;

    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name) {
        return "hi " + name + "this is serviceTwo, my port is:" + port;
    }

    @GetMapping("/sayHelloFromServiceOne")
    public String sayHelloFromServiceOne(@RequestParam("name") String name) {
        return feignService.sayHello(name);
    }
}
