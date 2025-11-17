package com.kafka.producer.service;

import com.kafka.producer.model.dto.NotificationRequest;
import com.kafka.producer.model.dto.NotificationResponse;

public interface NotificationService {
    NotificationResponse createNotification(NotificationRequest request);
}
