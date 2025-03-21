/**
 * @description: Clase para cuentas corrientes
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package prueba.banco;

public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;
    private static final double COMISION_SOBREGIRO = 0.05; // 5% de comisión

    public CuentaCorriente(String numeroCuenta, String titular, double limiteSobregiro) {
        super(numeroCuenta, titular);
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public boolean retirar(double monto) {
        if (monto > 0) {
            if (monto <= saldo) {
                return super.retirar(monto);
            } else if (monto <= (saldo + limiteSobregiro)) {
                double sobregiro = monto - saldo;
                double comision = sobregiro * COMISION_SOBREGIRO;
                saldo = -sobregiro - comision;
                System.out.println("Retiro con sobregiro exitoso. Comisión aplicada: $" + comision);
                System.out.println("Nuevo saldo: $" + saldo);
                return true;
            } else {
                System.out.println("No se puede realizar el retiro. Excede el límite de sobregiro");
                return false;
            }
        } else {
            System.out.println("El monto del retiro debe ser mayor a 0");
            return false;
        }
    }

    @Override
    public void calcularInteres() {
        // Las cuentas corrientes no generan intereses
        System.out.println("Las cuentas corrientes no generan intereses");
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }
} 