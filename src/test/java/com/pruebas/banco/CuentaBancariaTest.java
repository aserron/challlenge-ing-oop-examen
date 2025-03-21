package com.pruebas.banco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaBancariaTest {
    private CuentaCorriente cuentaCorriente;
    private CuentaAhorros cuentaAhorros;
    private static final String NUMERO_CUENTA = "123456789";
    private static final String TITULAR = "Juan Pérez";
    private static final double LIMITE_SOBREGIRO = 1000.0;

    @BeforeEach
    void setUp() {
        cuentaCorriente = new CuentaCorriente(NUMERO_CUENTA, TITULAR, LIMITE_SOBREGIRO);
        cuentaAhorros = new CuentaAhorros(NUMERO_CUENTA, TITULAR);
    }

    @Test
    void testOperacionesBasicas() {
        // Prueba de depósito
        cuentaCorriente.depositar(500.0);
        assertEquals(500.0, cuentaCorriente.getSaldo());

        cuentaAhorros.depositar(500.0);
        assertEquals(500.0, cuentaAhorros.getSaldo());

        // Prueba de retiro normal
        assertThrows(IllegalArgumentException.class, () -> cuentaCorriente.retirar(200.0));
        assertEquals(300.0, cuentaCorriente.getSaldo());

        assertThrows(IllegalArgumentException.class, () -> cuentaAhorros.retirar(200.0));
        assertEquals(300.0, cuentaAhorros.getSaldo());

        // Prueba de retiro con monto mayor al saldo en cuenta de ahorros
        assertThrows(IllegalArgumentException.class, () -> cuentaAhorros.retirar(500.0));
        assertEquals(300.0, cuentaAhorros.getSaldo());
    }

    @Test
    void testSobregiroEnCuentaCorriente() {
        // Depositar fondos iniciales
        cuentaCorriente.depositar(500.0);
        assertEquals(500.0, cuentaCorriente.getSaldo());


        double SOBREGIRO = 1000.0;
        
        // Realizar retiro con sobregiro
        assertThrows(IllegalArgumentException.class, () -> cuentaCorriente.retirar(SOBREGIRO));
        
        // Verificar que se aplicó el sobregiro y la comisión
        double sobregiro = 1000.0 - 500.0; // = 500.0
        double comision = sobregiro * 0.05; // = 25.0
        assertEquals(-sobregiro - comision, cuentaCorriente.getSaldo()); // -500 - 25
    }

    @Test
    void testCalculoIntereses() {
        // Prueba cálculo de intereses en cuenta de ahorros
        cuentaAhorros.depositar(1000.0);
        cuentaAhorros.calcularInteres();
        assertEquals(1020.0, cuentaAhorros.getSaldo()); // 1000 + (1000 * 0.02)

        // Prueba que cuenta corriente no genera intereses
        cuentaCorriente.depositar(1000.0);
        cuentaCorriente.calcularInteres();
        assertEquals(1000.0, cuentaCorriente.getSaldo());
    }
}