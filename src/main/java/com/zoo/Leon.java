package com.zoo;

public class Leon extends Animal {  

    public Leon(String nombre, String color) {
        super(nombre, color);
    }

    @Override
    public void comer() {
        System.out.println("Soy un león y como!");
    }
}
