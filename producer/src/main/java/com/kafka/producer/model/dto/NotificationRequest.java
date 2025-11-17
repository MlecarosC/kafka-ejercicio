package com.kafka.producer.model.dto;

import com.kafka.producer.model.enums.NotificationType;
import com.kafka.producer.model.enums.Priority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    
    @NotBlank(message = "User ID is required")
    private String userId;
    
    @NotNull(message = "Notification type is required")
    private NotificationType notificationType;
    
    @NotBlank(message = "Title is required")
    private String title;
    
    @NotBlank(message = "Message is required")
    private String message;
    
    @NotNull(message = "Priority is required")
    private Priority priority;
    
    private Map<String, Object> metadata;
}
