package com.examen.gestion;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private final List<Empleado> empleados;

    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    // Método adicional para obtener la lista de empleados
    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        System.out.println("Lista de empleados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }


}
