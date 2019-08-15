package com.octpous.controller;

import com.octpous.model.NotificationLog;
import com.octpous.service.SendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SendController {
    @Autowired
    private SendLogService sendLogService;
    @PostMapping("/sendLog")
    public Map<String, Object> sendLog(@RequestBody NotificationLog notificationLog){
        return sendLogService.sendLog(notificationLog);
    }
}
