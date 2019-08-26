package com.kafkaspring.testservice.application.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    private static final Logger LOG = LoggerFactory.getLogger(TestListener.class);

//    @KafkaListener(topics = "test")
//    public void listen(final ConsumerRecord<?, ?> record) {
//        LOG.debug("Record consumed: {}", record);
//    }
}
