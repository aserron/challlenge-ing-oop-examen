package com.examen.bookstore;

public class NoDisponibleLibroException extends Exception {
    public NoDisponibleLibroException(String message) {
        super(message);
    }
} 