package com.zoo;

import java.util.Arrays;
import java.util.List;

public class Animales {

    public static void main(String[] args) {

        Animal miPajaro = new Pajaro("Pepito", "Amarillo");
        Animal miLeon = new Leon("Leoncito", "Amarillo");

        List<Animal> animales = Arrays.asList(miPajaro, miLeon);

        for (Animal a : animales) {
            a.comer();
        }
    }

}