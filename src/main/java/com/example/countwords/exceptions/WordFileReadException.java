package com.example.countwords.exceptions;

public class WordFileReadException extends RuntimeException {
    public WordFileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
