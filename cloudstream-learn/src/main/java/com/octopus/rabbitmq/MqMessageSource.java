package com.octopus.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface MqMessageSource {

    String LOG_INPUT_CHANNEL = "log_input_channel";

    @Input(MqMessageSource.LOG_INPUT_CHANNEL)
    MessageChannel logInputChannel();
}
