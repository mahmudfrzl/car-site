package com.me.carsite.exceptions;

public class SellerNotFoundException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SellerNotFoundException(String message) {
        super(message);
    }
}
