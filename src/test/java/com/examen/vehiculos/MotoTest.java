package com.examen.vehiculos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MotoTest {
    private Moto moto;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        moto = new Moto("Honda", "CBR", 600, true);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testConstructor() {
        assertEquals("Honda", moto.getMarca());
        assertEquals("CBR", moto.getModelo());
        assertEquals(600, moto.getCilindrada());
        assertTrue(moto.isTieneMaletero());
    }

    @Test
    void testSetCilindrada() {
        moto.setCilindrada(750);
        assertEquals(750, moto.getCilindrada());
    }

    @Test
    void testSetTieneMaletero() {
        moto.setTieneMaletero(false);
        assertFalse(moto.isTieneMaletero());
    }

    @Test
    void testInheritance() {
        assertTrue(moto instanceof Vehiculo);
    }

    @Test
    void testMostrarInfo() {
        moto.mostrarInfo();
        String expectedOutput = "Moto: Honda CBR" + System.lineSeparator() +
                              "Cilindrada: 600cc" + System.lineSeparator() +
                              "Tiene maletero: Sí" + System.lineSeparator();
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
} 