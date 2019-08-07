package com.octopus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Value("${server.port}")
    private String port;

    @Value("${democonfigclient.message}")
    private String configMessage;

    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name) {
        return "hi " + name + " this is serviceOne, my port is:" + port;
    }

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam("name") String name) {
        return "hi " + name + " this is serviceOne, my port is:" + port + " feign success";
    }

    @GetMapping("/getConfigMessage")
    public String getConfigMessage() {
        return configMessage;
    }

}
