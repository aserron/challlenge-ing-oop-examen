/**
 * @description: Clase Calculadora con métodos sobrecargados para sumar (Ejercicio 14)
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package com.pruebas.calc;

public class Calculadora {
    
    /**
     * Suma dos números enteros
     * @param a primer número entero
     * @param b segundo número entero
     * @return la suma de los dos números
     */
    public int sumar(int a, int b) {
        return a + b;
    }
    
    /**
     * Suma tres números enteros
     * @param a primer número entero
     * @param b segundo número entero
     * @param c tercer número entero
     * @return la suma de los tres números
     */
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }
    
    /**
     * Suma dos números de punto flotante
     * @param a primer número de punto flotante
     * @param b segundo número de punto flotante
     * @return la suma de los dos números
     */
    public double sumar(double a, double b) {
        return a + b;
    }
} 