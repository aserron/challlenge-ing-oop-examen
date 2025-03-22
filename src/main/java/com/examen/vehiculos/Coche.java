package com.examen.vehiculos;

public class Coche extends Vehiculo {
    private int numPuertas;
    private String tipoCombustible;

    public Coche(String marca, String modelo, int numPuertas, String tipoCombustible) {
        super(marca, modelo);
        this.numPuertas = numPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Coche: " + getMarca() + " " + getModelo());
        System.out.println("Número de puertas: " + numPuertas);
        System.out.println("Tipo de combustible: " + tipoCombustible);
    }
} 