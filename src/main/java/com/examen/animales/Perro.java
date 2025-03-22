/**
 * @description: Clase Perro que extiende de Animal
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package  com.examen.animales;

public class Perro extends Animal {

    /**
     * Implementa el método hacerSonido para el perro
     * 
     * @return AnimalSound con el sonido del perro
     */
    @Override
    public AnimalSoundEnum hacerSonido() {
        return AnimalSoundEnum.DOG;
    }
}