package com.me.carsite.configurations.results;


import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult(T data, String message) {
        super(data,true, message);

    }
    public SuccessDataResult(T data) {
        super(data,true);
    }
    public SuccessDataResult(String message) {
        super(null,true,message);
    }

    public SuccessDataResult() {
        super(null, true);
    }

    public SuccessDataResult(T data, String message, LocalDateTime responseAt) {
        super(data, true, message, responseAt);
    }

    public SuccessDataResult(T data, String message, LocalDateTime responseAt, HttpStatus status, Integer statusCode) {
        super(data, true, message, responseAt, status,statusCode);
    }
}