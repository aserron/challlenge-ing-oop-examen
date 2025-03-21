/**
 * @description: Clase para realizar operaciones de suma
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package  com.pruebas.operar;

public class Suma implements Operable {
    @Override
    public int operar(int a, int b) {
        return a + b;
    }
} 