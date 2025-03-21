/**
 * @description: Clase Gato que extiende de Animal
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package  com.pruebas.animales;

public class Gato extends Animal {
    /**
     * Implementa el método hacerSonido para el gato
     * @return String con el sonido del gato
     */
    @Override
    public AnimalSoundEnum hacerSonido() {
        return AnimalSoundEnum.CAT;
    }
} 