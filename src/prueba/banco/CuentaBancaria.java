/**
 * @description: Examen ejercicio 12: Clase base para cuentas bancarias
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package prueba.banco;

public abstract class CuentaBancaria {
    protected String numeroCuenta;
    protected double saldo;
    protected String titular;

    public CuentaBancaria(String numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("El monto del depósito debe ser mayor a 0");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("No se puede realizar el retiro. Saldo insuficiente o monto inválido");
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    // Método abstracto para calcular intereses que será implementado por las subclases
    public abstract void calcularInteres();
} 