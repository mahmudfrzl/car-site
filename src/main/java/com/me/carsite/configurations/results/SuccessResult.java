package com.me.carsite.configurations.results;


import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class SuccessResult extends Result {

    public SuccessResult() {
        super(true);

    }

    public SuccessResult(String message) {
        super(true, message);
    }

    public SuccessResult( String message, LocalDateTime responseAt) {
        super(true, message, responseAt);
    }

    public SuccessResult(String message, LocalDateTime responseAt, HttpStatus status) {
        super(true, message, responseAt, status, status.value());
    }
}


