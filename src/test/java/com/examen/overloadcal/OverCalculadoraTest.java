package com.examen.overloadcal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OverCalculadoraTest {

    private final OverCalculadora calculadora = new OverCalculadora();

    @Test
    public void testSumarDosEnteros() {
        assertEquals(5, calculadora.sumar(2, 3));
        assertEquals(0, calculadora.sumar(-1, 1));
        assertEquals(-6, calculadora.sumar(-3, -3));
    }

    @Test
    public void testSumarTresEnteros() {
        assertEquals(6, calculadora.sumar(1, 2, 3));
        assertEquals(0, calculadora.sumar(-1, 0, 1));
        assertEquals(-9, calculadora.sumar(-3, -3, -3));
    }

    @Test
    public void testSumarDosDoubles() {
        assertEquals(5.5, calculadora.sumar(2.2, 3.3));
        assertEquals(0.0, calculadora.sumar(-1.5, 1.5));
        assertEquals(-6.6, calculadora.sumar(-3.3, -3.3));
    }    
}