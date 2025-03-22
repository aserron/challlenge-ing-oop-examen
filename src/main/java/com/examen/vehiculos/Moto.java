package com.examen.vehiculos;

public class Moto extends Vehiculo {
    private int cilindrada;
    private boolean tieneMaletero;

    public Moto(String marca, String modelo, int cilindrada, boolean tieneMaletero) {
        super(marca, modelo);
        this.cilindrada = cilindrada;
        this.tieneMaletero = tieneMaletero;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public boolean isTieneMaletero() {
        return tieneMaletero;
    }

    public void setTieneMaletero(boolean tieneMaletero) {
        this.tieneMaletero = tieneMaletero;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Moto: " + getMarca() + " " + getModelo());
        System.out.println("Cilindrada: " + cilindrada + "cc");
        System.out.println("Tiene maletero: " + (tieneMaletero ? "Sí" : "No"));
    }
} 