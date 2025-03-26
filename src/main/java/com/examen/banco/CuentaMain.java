package  com.examen.banco;

public final class CuentaMain {
    public static void main(String[] args) {
        CuentaAhorros cuentaAhorros = new CuentaAhorros("1234567890", "Juan Perez");
        cuentaAhorros.depositar(1000);
        cuentaAhorros.retirar(500);
        cuentaAhorros.calcularInteres();

        cuentaAhorros.depositar(1000);
        cuentaAhorros.retirar(500);
        cuentaAhorros.calcularInteres();    

        // Cuenta Corriente
        CuentaCorriente cuentaCorriente = new CuentaCorriente("1234567890", "Juan Perez", 1000);
        System.out.println("Creando cuenta corriente:" + cuentaCorriente.getNumeroCuenta());
        cuentaCorriente.depositar(1000);
        cuentaCorriente.retirar(1500);
        cuentaCorriente.calcularInteres();      
    }
}