package com.kafka.producer.kafka;

import com.kafka.producer.model.dto.NotificationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${notification.kafka.topic}")
    private String topic;

    public void sendNotification(NotificationEvent event) {
        log.info("Sending notification to Kafka topic: {} with ID: {}", topic, event.getNotificationId());
        
        CompletableFuture<SendResult<String, Object>> future = 
            kafkaTemplate.send(topic, event.getNotificationId(), event);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Notification sent successfully. Offset: {}, Partition: {}", 
                    result.getRecordMetadata().offset(),
                    result.getRecordMetadata().partition());
            } else {
                log.error("Failed to send notification with ID: {}", event.getNotificationId(), ex);
            }
        });
    }
}
