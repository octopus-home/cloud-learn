package com.octpous.service.impl;

import com.octpous.model.NotificationLog;
import com.octpous.service.SendLogService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SendLogServiceImpl implements SendLogService {

    @Autowired
    private AmqpTemplate amqpTemplate;


    @Override
    public Map<String, Object> sendLog(NotificationLog notificationLog) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", 1);
        try {
            amqpTemplate.convertAndSend("notificationlog","", notificationLog);
        } catch (Exception e) {
            result.put("success", 0);
            result.put("msg", e.getMessage());
        }
        return result;
    }
}
