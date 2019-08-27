package com.kafkaspring.testservice.application.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    private static final Logger LOG = LoggerFactory.getLogger(TestListener.class);

    @KafkaListener(topics = "test", autoStartup = "false", groupId = "test")
    public void listen(final ConsumerRecord<?, ?> record) {
        LOG.debug("Record consumed: {}", record);
    }
}
