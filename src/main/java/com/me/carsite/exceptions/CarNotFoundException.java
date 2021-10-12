package com.me.carsite.exceptions;

public class CarNotFoundException extends RuntimeException{
    static final long serialVersionUID = 1L;
    public CarNotFoundException(String message) {
        super(message);
    }
}
