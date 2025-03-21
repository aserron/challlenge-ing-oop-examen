/**
 * @description: Clase para cuentas de ahorros
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package prueba.banco;

public class CuentaAhorros extends CuentaBancaria {
    private static final double TASA_INTERES = 0.02; // 2% de interés anual
    private int mesesSinRetiros;

    public CuentaAhorros(String numeroCuenta, String titular) {
        super(numeroCuenta, titular);
        this.mesesSinRetiros = 0;
    }

    @Override
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            boolean resultado = super.retirar(monto);
            if (resultado) {
                mesesSinRetiros = 0;
            }
            return resultado;
        } else {
            System.out.println("No se puede realizar el retiro. Saldo insuficiente o monto inválido");
            return false;
        }
    }

    @Override
    public void calcularInteres() {
        double interes = saldo * TASA_INTERES;
        saldo += interes;
        mesesSinRetiros++;
        System.out.println("Interés calculado: $" + interes);
        System.out.println("Nuevo saldo: $" + saldo);
        System.out.println("Meses sin retiros: " + mesesSinRetiros);
    }

    public int getMesesSinRetiros() {
        return mesesSinRetiros;
    }
} 