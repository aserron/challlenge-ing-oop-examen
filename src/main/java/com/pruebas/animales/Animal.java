/**
 * @description: Clase abstracta Animal
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package main.java.com.pruebas.animales;

public abstract class Animal {
    /**
     * Método abstracto para hacer sonido
     * @return AnimalSound con el sonido del animal
     */
    public abstract AnimalSoundEnum hacerSonido();
} 