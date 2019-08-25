package com.kafkaspring.testservice.domain.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Test {

    @Id
    private UUID id;
}
