package com.me.carsite.configurations.results;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResult extends Result{


    public ErrorResult() {
        super(false);
    }

    public ErrorResult( String message) {
        super(false, message);
    }
    public ErrorResult( String message, LocalDateTime responseAt) {
        super(false, message, responseAt);
    }

    public ErrorResult(String message, LocalDateTime responseAt, HttpStatus status) {
        super(false, message, responseAt, status, status.value());
    }
}
