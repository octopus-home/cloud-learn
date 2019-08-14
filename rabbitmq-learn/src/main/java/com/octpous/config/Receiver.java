package com.octpous.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RabbitListener(queues = "try")
public class Receiver {
    @RabbitHandler
    public void receiver(String str){
        String content = LocalDateTime.now().toString()+": Receiver receive a message: "+ str;
        System.out.println(content);
    }
}
