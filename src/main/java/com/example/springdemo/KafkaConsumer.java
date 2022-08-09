package com.example.springdemo;

import lombok.Data;
import lombok.Getter;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Data
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private String payload;

    @KafkaListener(topics = "${test.topic}",
            containerFactory = "kafkaListenerContainerFactory")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info("11111received payload='{}'", consumerRecord.toString());
        payload = consumerRecord.toString();
    }

    @KafkaListener(topics = "${test.topic2}",
            containerFactory = "kafkaListenerContainerFactory2")
    public void receive2(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info("22222received payload='{}'", consumerRecord.toString());
        payload = consumerRecord.toString();
    }
}
