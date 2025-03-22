package com.examen.vehiculos;

/**
 * @implNote
 *           15. Herencia en Vehículos:
 *           Define una clase Vehiculo con atributos generales (por ejemplo,
 *           marca y modelo) y un método mostrarInfo().
 *           Luego, crea dos subclases Coche y Moto que extiendan Vehiculo y
 *           sobrescriban el método mostrarInfo() para mostrar información
 *           específica de cada tipo de vehículo.
 * 
 */
public class Vehiculo {
    private String marca;
    private String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void mostrarInfo() {
        System.out.println("Vehículo: " + marca + " " + modelo);
    }
}
