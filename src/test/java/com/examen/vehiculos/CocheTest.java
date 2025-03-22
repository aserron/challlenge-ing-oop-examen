package com.examen.vehiculos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CocheTest {
    private Coche coche;

    @BeforeEach
    void setUp() {
        coche = new Coche("Honda", "Civic", 4, "Gasolina");
    }

    @Test
    void testConstructor() {
        assertEquals("Honda", coche.getMarca());
        assertEquals("Civic", coche.getModelo());
        assertEquals(4, coche.getNumPuertas());
        assertEquals("Gasolina", coche.getTipoCombustible());
    }

    @Test
    void testSetNumPuertas() {
        coche.setNumPuertas(5);
        assertEquals(5, coche.getNumPuertas());
    }

    @Test
    void testSetTipoCombustible() {
        coche.setTipoCombustible("Diesel");
        assertEquals("Diesel", coche.getTipoCombustible());
    }

    @Test
    void testInheritance() {
        assertTrue(coche instanceof Vehiculo);
    }
} 