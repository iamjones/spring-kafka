package com.kafkaspring.testservice.application.producers;

import com.kafkaspring.testservice.domain.test.TestRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestProducer {

    private final static Logger LOG = LoggerFactory.getLogger(TestProducer.class);

    private final static String TOPIC = "Test";

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public TestProducer(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(final TestRequest testRequest) {
        LOG.debug("Producing test request: {}", testRequest);
        kafkaTemplate.send(TestProducer.TOPIC, kafkaTemplate.toString());
    }
}
