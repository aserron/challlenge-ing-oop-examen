package test.java.com.pruebas.animales;

import main.java.com.pruebas.animales.Animal;
import main.java.com.pruebas.animales.AnimalSoundEnum;
import main.java.com.pruebas.animales.Gato;
import main.java.com.pruebas.animales.Perro;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AnimalTest {

    @Test
    void testPerroHacerSonido() {
        Animal perro = new Perro();
        assertEquals(AnimalSoundEnum.DOG, perro.hacerSonido(), "El perro debería hacer el sonido de perro");
    }

    @Test
    void testGatoHacerSonido() {
        Animal gato = new Gato();
        assertEquals(AnimalSoundEnum.CAT, gato.hacerSonido(), "El gato debería hacer el sonido de gato");
    }

    @Test
    void testPolimorfismo() {
        Animal[] animales = {new Perro(), new Gato(), new Perro()};
        
        assertEquals(AnimalSoundEnum.DOG, animales[0].hacerSonido(), "El primer animal debería ser un perro");
        assertEquals(AnimalSoundEnum.CAT, animales[1].hacerSonido(), "El segundo animal debería ser un gato");
        assertEquals(AnimalSoundEnum.DOG, animales[2].hacerSonido(), "El tercer animal debería ser un perro");
    }
} 