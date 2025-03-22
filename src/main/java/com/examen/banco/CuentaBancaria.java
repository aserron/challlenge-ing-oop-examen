/**
 * @description: Examen ejercicio 12: Clase base para cuentas bancarias
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package com.examen.banco;

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
    public double retirar(double monto) {

        if(monto <= 0) {            
            throw new IllegalArgumentException("Monto inválido: El monto debe ser mayor que 0  monto=" + monto);            
        }

        saldo -= monto;
        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        
        return monto;
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

    /**
     * @abstract: Método abstracto para calcular intereses
     */
    public abstract void calcularInteres();
} 