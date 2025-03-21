package com.pruebas.animales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalesTest {

    @Test
    public void testPerroHacerSonido() {
        Perro perro = new Perro();
        AnimalSoundEnum sonido = perro.hacerSonido();
        assertEquals(AnimalSoundEnum.DOG, sonido);
        assertEquals("woof", sonido.getSound());
    }

    @Test
    public void testGatoHacerSonido() {
        Gato gato = new Gato();
        AnimalSoundEnum sonido = gato.hacerSonido();
        assertEquals(AnimalSoundEnum.CAT, sonido);
        assertEquals("meow", sonido.getSound());
    }

    @Test
    public void testAnimalSoundEnumValues() {
        // Test all enum values and their sounds
        assertEquals("woof", AnimalSoundEnum.DOG.getSound());
        assertEquals("meow", AnimalSoundEnum.CAT.getSound());
        assertEquals("moo", AnimalSoundEnum.COW.getSound());
        assertEquals("baa", AnimalSoundEnum.SHEEP.getSound());
        assertEquals("cluck", AnimalSoundEnum.CHICKEN.getSound());
        assertEquals("oink", AnimalSoundEnum.PIG.getSound());
        assertEquals("quack", AnimalSoundEnum.DUCK.getSound());
        assertEquals("neigh", AnimalSoundEnum.HORSE.getSound());
        assertEquals("roar", AnimalSoundEnum.LION.getSound());
        assertEquals("hiss", AnimalSoundEnum.SNAKE.getSound());
    }

    @Test
    public void testPolimorfismo() {
        Animal[] animales = {new Perro(), new Gato(), new Perro()};
        
        // Test first animal (Perro)
        assertEquals(AnimalSoundEnum.DOG, animales[0].hacerSonido());
        assertEquals("woof", animales[0].hacerSonido().getSound());
        
        // Test second animal (Gato)
        assertEquals(AnimalSoundEnum.CAT, animales[1].hacerSonido());
        assertEquals("meow", animales[1].hacerSonido().getSound());
        
        // Test third animal (Perro)
        assertEquals(AnimalSoundEnum.DOG, animales[2].hacerSonido());
        assertEquals("woof", animales[2].hacerSonido().getSound());
    }
} 