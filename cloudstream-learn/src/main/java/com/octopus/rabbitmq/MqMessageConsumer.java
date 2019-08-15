package com.octopus.rabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@EnableBinding(MqMessageSource.class)
public class MqMessageConsumer {

    @StreamListener(MqMessageSource.LOG_INPUT_CHANNEL)
    public void messageInput(Message<String> message){
        System.err.println("消息接收成功："+message.getPayload());
    }
}
