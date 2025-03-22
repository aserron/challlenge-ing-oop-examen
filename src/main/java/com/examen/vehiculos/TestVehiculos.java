package com.examen.vehiculos;

public class TestVehiculos {
    public static void main(String[] args) {
        // Crear instancias de cada tipo de vehículo
        Vehiculo vehiculoGeneral = new Vehiculo("Toyota", "Genérico");
        Coche coche = new Coche("Honda", "Civic", 4, "Gasolina");
        Moto moto = new Moto("Honda", "CBR", 600, true);

        System.out.println("=== Demostración de Vehículos ===");
        System.out.println("\n1. Información del Vehículo General:");
        vehiculoGeneral.mostrarInfo();

        System.out.println("\n2. Información del Coche:");
        coche.mostrarInfo();

        System.out.println("\n3. Información de la Moto:");
        moto.mostrarInfo();

        // Demostrar el uso de getters y setters
        System.out.println("\n=== Demostración de Getters y Setters ===");
        
        // Modificar y mostrar información del coche
        coche.setNumPuertas(5);
        coche.setTipoCombustible("Diesel");
        System.out.println("\nCoche modificado:");
        coche.mostrarInfo();

        // Modificar y mostrar información de la moto
        moto.setCilindrada(750);
        moto.setTieneMaletero(false);
        System.out.println("\nMoto modificada:");
        moto.mostrarInfo();
    }
} 