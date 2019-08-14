package com.octpous.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send() {
        String content = LocalDateTime.now().toString() + ": Sender says: " + "'hello , I'm sender'";
        System.out.println(content);
        rabbitmqTemplate.convertAndSend("try", content);
    }
}
