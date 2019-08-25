package com.kafkaspring.testservice.application.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopic {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaTopic.class);

    private final String bootstrapAddress;

    public KafkaTopic(@Value("${kafka.bootstrap-address}") final String bootstrapAddress) {
        this.bootstrapAddress = bootstrapAddress;
        LOG.debug("Configuring KafkaTopic with bootstrap address: {}", bootstrapAddress);
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic testTopic() {
        return new NewTopic("test", 1, (short) 1);
    }
}
