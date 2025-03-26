/**
 * @author Andres Serron
 * @version 1.0
 * @implNote Implementación del patrón Singleton para un juego
 * (Ejercicio 19)
 * @implNote Resolves
 * ## #19. Patrón Singleton en un Juego
 * <p>
 * Definicion del problema
 * <p>
 * Crea una clase Juego que utilice el patrón de diseño Singleton para asegurar
 * que solo exista una instancia en la aplicación.
 * o	Incluye un método iniciarJuego() que imprima un mensaje indicando que el juego ha comenzado.
 * @implNote Características implementadas:
 * - Patrón Singleton con instancia única
 * - Gestión de estados del juego (ESPERANDO, INICIADO, CORRIENDO, PAUSADO, REANUDADO, FINALIZADO, FALLADO)
 * - Registro de mensajes de estado
 * - Métodos de control del ciclo de vida del juego
 * - Limpieza de estado para pruebas
 * @implNote Consideraciones de diseño:
 * - Constructor privado para prevenir instanciación directa
 * - Método getInstance() para obtener la única instancia
 * - Estado mutable para tracking del ciclo de vida
 * - Mensajes descriptivos para cada cambio de estado
 * @since 2025-03-21
 */
package com.examen.singleton;
