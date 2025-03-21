package com.pruebas.bookstore;

public class NoDisponibleLibroException extends Exception {
    public NoDisponibleLibroException(String message) {
        super(message);
    }
} 