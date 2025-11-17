package com.kafka.producer.service;

import com.kafka.producer.kafka.NotificationProducer;
import com.kafka.producer.model.dto.NotificationEvent;
import com.kafka.producer.model.dto.NotificationRequest;
import com.kafka.producer.model.dto.NotificationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationProducer notificationProducer;

    @Override
    public NotificationResponse createNotification(NotificationRequest request) {
        log.info("Creating notification for user: {}", request.getUserId());

        String notificationId = UUID.randomUUID().toString();
        String correlationId = UUID.randomUUID().toString();

        NotificationEvent event = NotificationEvent.builder()
                .notificationId(notificationId)
                .correlationId(correlationId)
                .userId(request.getUserId())
                .notificationType(request.getNotificationType())
                .title(request.getTitle())
                .message(request.getMessage())
                .priority(request.getPriority())
                .metadata(request.getMetadata())
                .createdAt(LocalDateTime.now())
                .status("PENDING")
                .build();

        notificationProducer.sendNotification(event);
        
        log.info("Notification created successfully with ID: {}", notificationId);

        return NotificationResponse.builder()
                .notificationId(notificationId)
                .status("CREATED")
                .message("Notification sent successfully")
                .timestamp(LocalDateTime.now())
                .build();
    }
}
