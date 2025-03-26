package com.examen.overloadcal;

public final class CalculadoraScript {
    public static void main(String[] args) {
        // Crear una instancia de OverCalculadora
        OverCalculadora calc = new OverCalculadora();
        
        // Probar los diferentes métodos sobrecargados
        System.out.println("Suma de dos enteros: " + calc.sumar(5, 3));
        System.out.println("Suma de tres enteros: " + calc.sumar(5, 3, 2));
        System.out.println("Suma de dos doubles: " + calc.sumar(5.5, 3.2));
    }
} 