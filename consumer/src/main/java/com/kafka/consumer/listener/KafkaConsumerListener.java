package com.kafka.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class KafkaConsumerListener {
    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void listen(String message) {
        log.info("Received Message: {}", message);
    }
}
