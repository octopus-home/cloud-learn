package com.octopus.rabbitmq;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@EnableBinding(MqMessageSource.class)
public class MqMessageConsumer {

    @StreamListener(MqMessageSource.LOG_INPUT_CHANNEL)
    public void messageInput(Message<String> message,
                             @Header(AmqpHeaders.CHANNEL) Channel channel,
                             @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag) throws IOException {

        AtomicInteger deliveryAttempt = message.getHeaders().get("deliveryAttempt", AtomicInteger.class);
        Boolean redelivered = message.getHeaders().get("amqp_redelivered", Boolean.class);
        try {
            System.err.println("消息接收成功："+message.getPayload());
            System.out.println(message.getHeaders());
            System.out.println(deliveryTag);
            System.out.println(1/0);
        } catch (Exception e) {
             if(deliveryAttempt.intValue() == 3 && redelivered){
                channel.basicAck(deliveryTag,false);
                throw new AmqpRejectAndDontRequeueException("retry i times ,send to dlq");
            }else if(deliveryAttempt.intValue() == 3){
                channel.basicNack(deliveryTag,false,false);
            }
            e.printStackTrace();
            throw e;
        }
        channel.basicAck(deliveryTag,false);
    }
}
