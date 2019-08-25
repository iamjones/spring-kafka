package com.kafkaspring.testservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Application starting...");
		SpringApplication.run(Application.class, args);
		System.out.println("Application started.");
	}
}
