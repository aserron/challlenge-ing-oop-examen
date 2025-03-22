package com.examen.banco;

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
    void testCuentaCuentaCorrienteBasicas() {

        assertEquals(0.0, cuentaCorriente.getSaldo());

        // Prueba de depósito
        cuentaCorriente.depositar(500.0);
        assertEquals(500.0, cuentaCorriente.getSaldo());


        // Prueba de retiro normal
        assertEquals(200, cuentaCorriente.retirar(200.0));
        assertEquals(300.0, cuentaCorriente.getSaldo());


        // Prueba de retiro con monto mayor al saldo en cuenta de ahorros
        assertEquals(500.0, cuentaCorriente.retirar(500.0));

        // El saldo es negativo = -(sobregiro + la comisión)
        assertEquals(-210.0, cuentaCorriente.getSaldo());
    }

    @Test
    void testCuentaCuentaAhorroBasicas() {
        // Prueba de depósito
        cuentaAhorros.depositar(500.0);
        assertEquals(500.0, cuentaAhorros.getSaldo());

        // Prueba de retiro normal
        assertEquals(200, cuentaAhorros.retirar(200.0));
        assertEquals(300.0, cuentaAhorros.getSaldo());
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