package com.pruebas.personas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    void testConstructorAndSaludar() {
        Persona persona = new Persona("Juan", 25);
        assertEquals("Hola, soy Juan y tengo 25 años.", persona.saludar());
    }

    @Test
    void testConstructorWithNullName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Persona(null, 30);
        });
        assertEquals("El nombre no puede ser nulo o vacío", exception.getMessage());
    }

    @Test
    void testConstructorWithEmptyName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Persona("", 30);
        });
        assertEquals("El nombre no puede ser nulo o vacío", exception.getMessage());
    }

    @Test
    void testConstructorWithWhitespaceName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Persona("   ", 30);
        });
        assertEquals("El nombre no puede ser nulo o vacío", exception.getMessage());
    }

    @Test
    void testSetNombre() {
        Persona persona = new Persona("Juan", 25);
        persona.setNombre("María");
        assertEquals("Hola, soy María y tengo 25 años.", persona.saludar());
    }

    @Test
    void testSetNombreWithNull() {
        Persona persona = new Persona("Juan", 25);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            persona.setNombre(null);
        });
        assertEquals("El nombre no puede ser nulo o vacío", exception.getMessage());
    }

    @Test
    void testSetNombreWithEmpty() {
        Persona persona = new Persona("Juan", 25);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            persona.setNombre("");
        });
        assertEquals("El nombre no puede ser nulo o vacío", exception.getMessage());
    }

    @Test
    void testSetEdad() {
        Persona persona = new Persona("Juan", 25);
        persona.setEdad(30);
        assertEquals("Hola, soy Juan y tengo 30 años.", persona.saludar());
    }

    @Test
    void testGetNombre() {
        Persona persona = new Persona("Juan", 25);
        assertEquals("Juan", persona.getNombre());
    }

    @Test
    void testGetEdad() {
        Persona persona = new Persona("Juan", 25);
        assertEquals(25, persona.getEdad());
    }
} 