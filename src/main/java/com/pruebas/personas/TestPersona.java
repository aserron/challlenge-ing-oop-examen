package com.pruebas.personas;

public class TestPersona {
    public static void main(String[] args) {
        // Test normal case
        Persona persona1 = new Persona("Juan", 25);
        System.out.println(persona1.saludar());

        // Test with null name
        try {
            Persona persona2 = new Persona(null, 30);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear persona con nombre nulo: " + e.getMessage());
        }

        // Test with empty name
        try {
            Persona persona3 = new Persona("", 35);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear persona con nombre vacío: " + e.getMessage());
        }

        // Test with whitespace name
        try {
            Persona persona4 = new Persona("   ", 40);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear persona con nombre solo espacios: " + e.getMessage());
        }
    }
} 