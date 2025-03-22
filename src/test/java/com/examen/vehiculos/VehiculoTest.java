package com.examen.vehiculos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehiculoTest {
    private Vehiculo vehiculo;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        vehiculo = new Vehiculo("Toyota", "Corolla");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testConstructor() {
        assertEquals("Toyota", vehiculo.getMarca());
        assertEquals("Corolla", vehiculo.getModelo());
    }

    @Test
    void testSetMarca() {
        vehiculo.setMarca("Honda");
        assertEquals("Honda", vehiculo.getMarca());
    }

    @Test
    void testSetModelo() {
        vehiculo.setModelo("Civic");
        assertEquals("Civic", vehiculo.getModelo());
    }

    @Test
    void testMostrarInfo() {
        vehiculo.mostrarInfo();
        assertEquals("Vehículo: Toyota Corolla" + System.lineSeparator(), outputStreamCaptor.toString());
    }
} 