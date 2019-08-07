package com.octopus.api.fallback;

import com.octopus.api.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignFallBack implements FeignService {

    @Override
    public String sayHello(String name) {
        return "can not get message from service-one";
    }
}
