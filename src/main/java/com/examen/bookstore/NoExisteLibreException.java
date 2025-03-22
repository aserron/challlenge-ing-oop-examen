package com.examen.bookstore;

public class NoExisteLibreException extends Exception {
    public NoExisteLibreException(String message) {
        super(message);
    }
} 