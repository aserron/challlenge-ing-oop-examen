package prueba.banco;

public class CuentaMain {
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
        cuentaCorriente.depositar(1000);
        cuentaCorriente.retirar(500);
        cuentaCorriente.calcularInteres();      
    }
}