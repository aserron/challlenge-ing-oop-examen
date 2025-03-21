package com.zoo;

public class Pajaro extends Animal {

    public Pajaro(String nombre, String color) {
        super(nombre, color);
    }
    
    @Override
    public void comer() {
        System.out.println("Soy un pajaro y como!");
    }

}
