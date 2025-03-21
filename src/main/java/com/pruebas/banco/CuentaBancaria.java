/**
 * @description: Examen ejercicio 12: Clase base para cuentas bancarias
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package com.pruebas.banco;

public abstract class CuentaBancaria {
    // Atributos protegidos para que las subclases puedan acceder
    protected String numeroCuenta;
    protected double saldo;
    protected String titular;

    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    // Método para depositar dinero
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        }
    }

    // Método para retirar dinero
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
            return true;
        }
        return false;
    }

    // Getters
    public double getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    // Método abstracto para calcular intereses
    public abstract void calcularInteres();
} 