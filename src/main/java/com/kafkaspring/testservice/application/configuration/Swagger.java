package com.kafkaspring.testservice.application.configuration;

import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Profile("!production")
public class Swagger {

    private static final String JWT = "JWT";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .securitySchemes(Collections.singletonList(apiKey()))
            .securityContexts(Collections.singletonList(securityContext()))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.kafkaspring"))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .useDefaultResponseMessages(false);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(Collections.singletonList(defaultAuth()))
            .forPaths(PathSelectors.any())
            .forHttpMethods(httpMethod -> httpMethod != HttpMethod.OPTIONS)
            .build();
    }

    private SecurityReference defaultAuth() {
        return new SecurityReference(JWT, new AuthorizationScope[]{});
    }

    private ApiKey apiKey() {
        return new ApiKey(JWT, HttpHeaders.AUTHORIZATION, In.HEADER.toValue());
    }
}

