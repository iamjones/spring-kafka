package com.kafkaspring.testservice.domain.test;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class TestRequest {

    @Email(message = "testRequest.email.invalid")
    @NotBlank(message = "testRequest.email.isMissing")
    private String email;

    @NotBlank(message = "testRequest.password.isMissing")
    private String password;

    @NotBlank(message = "testRequest.something.isMissing")
    private String something;

    @Min(value = 1, message = "testRequest.somethingElse.tooSmall")
    private Integer somethingElse;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public Integer getSomethingElse() {
        return somethingElse;
    }

    public void setSomethingElse(Integer somethingElse) {
        this.somethingElse = somethingElse;
    }

    @Override
    public String toString() {
        return "TestRequest{" +
            "email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", something='" + something + '\'' +
            ", somethingElse=" + somethingElse +
            '}';
    }
}
