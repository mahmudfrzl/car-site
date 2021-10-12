package com.me.carsite.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private LocalDateTime timeStamp;

    private String path;

    private String message;

    private String code;

    public ExceptionResponse(LocalDateTime timeStamp,  String message, String code) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.code = code;
    }
}
