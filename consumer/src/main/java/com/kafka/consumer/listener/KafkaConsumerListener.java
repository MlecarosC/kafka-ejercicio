package com.kafka.consumer.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class KafkaConsumerListener {

    @Value("${notification.kafka.topic}")
    private String topic;

    @KafkaListener(topics = "${notification.kafka.topic}", groupId = "notification-group")
    public void listen(String message) {
        log.info("Received Message: {}", message);
    }
}
