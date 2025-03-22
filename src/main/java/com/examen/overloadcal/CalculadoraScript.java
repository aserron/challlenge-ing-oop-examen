package com.examen.overloadcal;

/**
 * @description: Script de ejemplo que muestra cómo crear un programa Java sin una clase
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
public class CalculadoraScript {
    public static void main(String[] args) {
        // Crear una instancia de OverCalculadora
        OverCalculadora calc = new OverCalculadora();
        
        // Probar los diferentes métodos sobrecargados
        System.out.println("Suma de dos enteros: " + calc.sumar(5, 3));
        System.out.println("Suma de tres enteros: " + calc.sumar(5, 3, 2));
        System.out.println("Suma de dos doubles: " + calc.sumar(5.5, 3.2));
    }
} 