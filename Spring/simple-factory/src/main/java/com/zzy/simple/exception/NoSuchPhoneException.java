package com.zzy.simple.exception;

public class NoSuchPhoneException extends RuntimeException{
    public NoSuchPhoneException(String message) {
        super(message);
    }
}
