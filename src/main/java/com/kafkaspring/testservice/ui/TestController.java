package com.kafkaspring.testservice.ui;

import com.kafkaspring.testservice.domain.test.TestRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    @PostMapping(
        value = "/test",
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity postSomeData(@RequestBody @Valid final TestRequest testRequest) {
        System.out.println(testRequest);
        return ResponseEntity.ok().build();
    }
}
