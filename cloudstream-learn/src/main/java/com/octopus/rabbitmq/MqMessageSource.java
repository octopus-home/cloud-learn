package com.octopus.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MqMessageSource {

    String LOG_INPUT_CHANNEL = "log_consumer";
    String LOG_OUTPUT_CHANNEL = "log_producer";

    @Input(MqMessageSource.LOG_INPUT_CHANNEL)
    MessageChannel logInputChannel();

    @Output(MqMessageSource.LOG_OUTPUT_CHANNEL)
    MessageChannel logOutputChannel();
}
