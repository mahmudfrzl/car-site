package com.me.carsite.configurations.results;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorDataResult <T> extends DataResult<T>{

    public ErrorDataResult(T data, String message) {
        super(data,false, message);

    }
    public ErrorDataResult(T data) {
        super(data,false);
    }
    public ErrorDataResult(String message) {
        super(null,false,message);
    }

    public ErrorDataResult() {
        super(null, true);
    }

    public ErrorDataResult(T data, String message, LocalDateTime responseAt) {
        super(data, false, message, responseAt);
    }

    public ErrorDataResult(T data, String message, LocalDateTime responseAt, HttpStatus status, Integer statusCode) {
        super(data, false, message, responseAt, status, status.value());
    }
}
