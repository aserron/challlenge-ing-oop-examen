## #15 Herencia en Vehículos

## Desafío

```
Define una clase Vehiculo con atributos generales (por ejemplo, marca y modelo) y un método mostrarInfo().
o	Luego, crea dos subclases Coche y Moto que extiendan Vehiculo y sobrescriban el método mostrarInfo() para mostrar información específica de cada tipo de vehículo.
```

Implementar un sistema de herencia que demuestre el concepto de herencia en Java, donde:

1. Se define una clase base `Vehiculo` con atributos generales (marca y modelo)
2. Se crean dos subclases (`Coche` y `Moto`) que extienden `Vehiculo`
3. Cada subclase sobrescribe el método `mostrarInfo()` para mostrar información específica

## Solución

### Clase Base: Vehiculo

```java
public class Vehiculo {
    private String marca;
    private String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInfo() {
        System.out.println("Vehículo: " + marca + " " + modelo);
    }
}
```

### Subclase: Coche

```java
public class Coche extends Vehiculo {
    private int numPuertas;
    private String tipoCombustible;

    public Coche(String marca, String modelo, int numPuertas, String tipoCombustible) {
        super(marca, modelo);
        this.numPuertas = numPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Coche: " + getMarca() + " " + getModelo());
        System.out.println("Número de puertas: " + numPuertas);
        System.out.println("Tipo de combustible: " + tipoCombustible);
    }
}
```

### Subclase: Moto

```java
public class Moto extends Vehiculo {
    private int cilindrada;
    private boolean tieneMaletero;

    public Moto(String marca, String modelo, int cilindrada, boolean tieneMaletero) {
        super(marca, modelo);
        this.cilindrada = cilindrada;
        this.tieneMaletero = tieneMaletero;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Moto: " + getMarca() + " " + getModelo());
        System.out.println("Cilindrada: " + cilindrada + "cc");
        System.out.println("Tiene maletero: " + (tieneMaletero ? "Sí" : "No"));
    }
}
```

## Conceptos Demostrados

### Herencia

- Uso de `extends` para crear la jerarquía de clases
- Reutilización de código de la clase base
- Acceso a atributos y métodos heredados

### Polimorfismo

- Sobrescritura del método `mostrarInfo()`
- Cada subclase proporciona su propia implementación
- Comportamiento específico según el tipo de vehículo

### Sobrescritura (Override)

- **Concepto**: Permite que una subclase proporcione una implementación específica de un método que ya está definido en su clase base
- **Reglas**:
  - El método en la subclase debe tener la misma firma que el método en la clase base
  - El tipo de retorno debe ser el mismo o un subtipo (covariant return type)
  - No se puede reducir la visibilidad del método
  - No se pueden sobrescribir métodos privados o finales
- **Anotación @Override**:
  - Indica explícitamente que un método sobrescribe a otro
  - Ayuda a prevenir errores de escritura
  - Mejora la legibilidad del código
  - Permite al compilador verificar que el método existe en la clase base
- **Ejemplo en el código**:

  ```java
  // En la clase base
  public void mostrarInfo() {
      System.out.println("Vehículo: " + marca + " " + modelo);
  }

  // En la subclase
  @Override
  public void mostrarInfo() {
      System.out.println("Coche: " + getMarca() + " " + getModelo());
      // Implementación específica para coches
  }
  ```

### Encapsulamiento

- Atributos privados en cada clase
- Acceso controlado mediante getters y setters
- Constructor específico para cada tipo de vehículo

## Ejemplo de Uso

```java
// Crear instancias
Vehiculo vehiculo = new Vehiculo("Toyota", "Corolla");
Coche coche = new Coche("Honda", "Civic", 4, "Gasolina");
Moto moto = new Moto("Honda", "CBR", 600, true);

// Demostrar polimorfismo
vehiculo.mostrarInfo();
coche.mostrarInfo();
moto.mostrarInfo();
```

## Salida Esperada

```
Vehículo: Toyota Corolla
Coche: Honda Civic
Número de puertas: 4
Tipo de combustible: Gasolina
Moto: Honda CBR
Cilindrada: 600cc
Tiene maletero: Sí
```

## Verificación

El sistema incluye pruebas unitarias que verifican:

- Creación correcta de objetos
- Herencia y polimorfismo
- Formato de salida específico
- Funcionalidad de getters y setters
