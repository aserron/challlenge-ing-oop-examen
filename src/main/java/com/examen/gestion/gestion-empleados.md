# 17. Gestión de Empleados en una Empresa

17. Gestión de Empleados en una Empresa:
    Desarrolla una clase Empleado con atributos como nombre, id y salario.
    a. Crea una clase Empresa que contenga una colección (por ejemplo, un ArrayList) de empleados.
    b. Implementa métodos para agregar un empleado y listar todos los empleados.

## Descripción

Sistema simple de gestión de empleados que permite mantener un registro de empleados en una empresa.

## Requisitos Principales

### 1. Clase Empleado

- Atributos privados:
  - nombre (String)
  - id (int)
  - salario (double)
- Constructor
- Getters y Setters
- Método toString() para representación en string

### 2. Clase Empresa

- Colección de empleados (ArrayList)
- Métodos principales:
  - agregarEmpleado(Empleado)
  - listarEmpleados()

## Implementación

### Clase Empleado

```java
public class Empleado {
    private String nombre;
    private int id;
    private double salario;

    public Empleado(String nombre, int id, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getId() { return id; }
    
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                '}';
    }
}
```

### Clase Empresa

```java
public class Empresa {
    private List<Empleado> empleados;

    public Empresa() {
        this.empleados = new ArrayList<>();
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
```

## Ejemplo de Uso

```java
public class Main {
    public static void main(String[] args) {
        // Crear una empresa
        Empresa empresa = new Empresa();
        
        // Crear empleados
        Empleado empleado1 = new Empleado("Juan Pérez", 1, 30000.0);
        Empleado empleado2 = new Empleado("María García", 2, 35000.0);
        
        // Agregar empleados a la empresa
        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(empleado2);
        
        // Listar empleados
        empresa.listarEmpleados();
    }
}
```

## Pruebas

El sistema incluye pruebas unitarias que verifican:

- Creación correcta de empleados
- Modificación de datos de empleados
- Agregar empleados a la empresa
- Listar empleados
- Manejo de casos especiales (lista vacía)
