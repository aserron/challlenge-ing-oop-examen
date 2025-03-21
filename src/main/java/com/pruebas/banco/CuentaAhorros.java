/**
 * @description: Clase para cuentas de ahorros
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package  com.pruebas.banco;

public class CuentaAhorros extends CuentaBancaria {
    // Constante para la tasa de interés
    private static final double TASA_INTERES = 0.02; // 2% de interés anual

    // Constructor
    public CuentaAhorros(String numeroCuenta, String titular) {
        super(numeroCuenta, titular);
    }

    // Sobreescritura del método calcularInteres
    @Override
    public void calcularInteres() {
        double interes = saldo * TASA_INTERES;
        saldo += interes;
        System.out.println("Interés calculado: $" + interes);
        System.out.println("Nuevo saldo: $" + saldo);
    }
} 