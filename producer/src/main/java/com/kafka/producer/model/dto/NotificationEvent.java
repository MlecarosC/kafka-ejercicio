package com.kafka.producer.model.dto;

import com.kafka.producer.model.enums.NotificationType;
import com.kafka.producer.model.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEvent {
    
    private String notificationId;
    private String correlationId;
    private String userId;
    private NotificationType notificationType;
    private String title;
    private String message;
    private Priority priority;
    private Map<String, Object> metadata;
    private LocalDateTime createdAt;
    private String status;
}
