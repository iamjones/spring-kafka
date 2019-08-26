package com.kafkaspring.testservice.application.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopic {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaTopic.class);

    // Bean is ignored if the topic already exists.
    @Bean
    public NewTopic testTopic() {
        final NewTopic testTopic = new NewTopic("test", 1, (short) 1);
        LOG.debug("Created a new test topic: {}", testTopic);
        return testTopic;
    }
}
