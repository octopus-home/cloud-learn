package com.octpous.service;

import com.octpous.model.NotificationLog;

import java.util.Map;

public interface SendLogService{

    Map<String, Object> sendLog(NotificationLog notificationLog);
}