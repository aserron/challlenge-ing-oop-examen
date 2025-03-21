package com.pruebas.bookstore;

public class NoExisteLibreException extends Exception {
    public NoExisteLibreException(String message) {
        super(message);
    }
} 