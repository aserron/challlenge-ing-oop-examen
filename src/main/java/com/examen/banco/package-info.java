/**
 * Jerarquía de Cuentas Bancarias
 *
 * Este paquete implementa una jerarquía de clases para representar una cuenta bancaria.
 * La estructura incluye:
 * <ul>
 *   <li>Una clase base {@link com.examen.banco.CuentaBancaria}</li>
 *   <li>Dos subclases: {@link com.examen.banco.CuentaCorriente} y {@link com.examen.banco.CuentaAhorros}</li>
 * </ul>
 * 
 * Características principales:
 * <ul>
 *   <li>Implementación de métodos para depositar y retirar dinero</li>
 *   <li>Demostración de sobreescritura de métodos para calcular intereses y aplicar comisiones</li>
 * </ul>
 * 
 * Requisitos de implementación:
 * <ul>
 *   <li>La clase base {@link com.examen.banco.CuentaBancaria} debe definir los métodos básicos de operación bancaria</li>
 *   <li>{@link com.examen.banco.CuentaCorriente} debe implementar comisiones por retiro</li>
 *   <li>{@link com.examen.banco.CuentaAhorros} debe implementar cálculo de intereses</li>
 *   <li>Todas las operaciones monetarias deben validar saldos suficientes</li>
 *   <li>Los montos no pueden ser negativos</li>
 * </ul>
 */
package com.examen.banco;