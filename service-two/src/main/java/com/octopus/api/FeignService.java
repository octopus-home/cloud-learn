package com.octopus.api;

import com.octopus.api.fallback.FeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-one", fallback = FeignFallBack.class)
public interface FeignService {


    @GetMapping(value = "/sayHello")
    String sayHello(@RequestParam("name") String name) ;

}
