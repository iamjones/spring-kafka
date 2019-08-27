package com.kafkaspring.testservice.ui;

import com.kafkaspring.testservice.application.producers.TestProducer;
import com.kafkaspring.testservice.domain.test.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    private final TestProducer testProducer;

    @Autowired
    public TestController(final TestProducer testProducer) {
        this.testProducer = testProducer;
    }

    @PostMapping(
        value = "/test",
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity postSomeData(@RequestBody @Valid final TestRequest testRequest) {
        System.out.println(testRequest);
        testProducer.produce(testRequest);
        return ResponseEntity.ok().build();
    }
}
