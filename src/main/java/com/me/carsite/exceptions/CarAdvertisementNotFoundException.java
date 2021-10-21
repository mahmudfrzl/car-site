package com.me.carsite.exceptions;

public class CarAdvertisementNotFoundException extends RuntimeException {
    public CarAdvertisementNotFoundException(String message) {
        super(message);
    }
}
