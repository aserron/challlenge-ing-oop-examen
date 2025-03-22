# Soluciones de Examen OOP

Este repositorio contiene una colección de soluciones para problemas de Programación Orientada a Objetos (OOP), implementadas en Java y probadas con JUnit. Las soluciones demuestran conceptos fundamentales de OOP y buenas prácticas de programación.

## 📁 Enlaces Directos a las Soluciones



### 💻 Implementaciones
- [Soluciones Practicas (main.java.com.examen)](src/main/java/com/examen)

### 🧪 Pruebas
- [Pruebas Unitarias (main.test.com.examen)](src/test/java/com/examen)

### 📚 Soluciones Teorícas
- [Examen Teórico](docs/README.md)


## 🚀 Soluciones Practicas

- [#11 Clase Persona](/src/main/java/com/examen/animales)
- [#12 Jerarquía de Cuentas Bancarias:](/src/main/java/com/examen/animales)
- [#13 Interfaz Operable](/src/main/java/com/examen/operar)
- [#14 Sobrecarga en Calculadora](/src/main/java/com/examen/overloadcal)
- [#15 Herencia en Vehículos](/src/main/java/com/examen/veh)
- [#16 Gestión de Empleados](/src/main/java/com/examen/gestion)
- [#17 Excepciones Personalizadas](/src/main/java/com/examen/customexc)
- [#18 Sistema de Préstamo de Libros](/src/main/java/com/examen/bookstore)
- [#19 Patrón Singleton en un Juego](/src/main/java/com/examen/singleton)


### 🔄 Ejercicios Prácticos

- [#4 Abstracción](/src/main/java/com/examen/bookstore)
- [#5 Constructores](/src/main/java/com/examen/personas)
- [#6 Interfaces](/src/main/java/com/examen/operar)
- [#7 Sobrecarga vs Sobreescritura](/src/main/java/com/examen/overloadcal)
- [#8 Palabras clave "this" y "super"](/src/main/java/com/examen/banco)
- [#9 Herencia Múltiple](/src/main/java/com/examen/gestion)
- [#10 Patrones de Diseño](/src/main/java/com/examen/singleton)







### 📝 Detalles de los Ejercicios

#### #13 Interfaz Operable
- Define una interfaz `Operable` con método `operar(int a, int b)`
- Implementa clases `Suma` y `Multiplicacion`
- Comportamientos distintos para el método `operar`

#### #14 Sobrecarga en Calculadora
- Clase `Calculadora` con métodos `sumar` sobrecargados:
  - Suma de dos enteros
  - Suma de tres enteros
  - Suma de dos números punto flotante

#### #15 Herencia en Vehículos
- Clase `Vehiculo` con atributos marca y modelo
- Método `mostrarInfo()`
- Subclases `Coche` y `Moto` que extienden `Vehiculo`
- Sobreescritura del método `mostrarInfo()`

#### #16 Gestión de Empleados
- Clase `Empleado` (nombre, id, salario)
- Clase `Empresa` con ArrayList de empleados
- Métodos para agregar y listar empleados

#### #17 Excepciones Personalizadas
- Excepción `ProductoNoEncontradoException`
- Clase `Inventario` con búsqueda por ID
- Manejo de excepciones con try-catch

#### #18 Sistema de Préstamo de Libros
- Clase `Libro` (titulo, autor, disponibilidad)
- Clase `Biblioteca` con gestión de libros
- Método `prestarLibro(String titulo)`
- Manejo de excepciones para disponibilidad

#### #19 Patrón Singleton en un Juego
- Clase `Juego` con patrón Singleton
- Método `iniciarJuego()`
- Demostración de instancia única

----

## Requisitos Previos

- Java JDK 11 o superior
- Maven 3.6 o superior
- IDE recomendado: IntelliJ IDEA / VSCODE

## Instalación

### 1. Clonar el repositorio  

```bash  
    git clone git
    cd challlenge-ing-oop-examen

```

### 2. Compilar el proyecto

```bash
mvn clean install
```

### 3. Ejecutar las examen

```bash
mvn test
```

## Estructura del Proyecto

```
gestion-empleados/
├── src/                    # Código fuente
├── docs/                   # Documentación
├── pom.xml                 # Configuración de Maven
└── README.md               # Este archivo
```

## Tecnologías Utilizadas

- Java 11
- JUnit 5.8.2
- Maven

## Configuración del IDE

#### 1. Abrir el proyecto en IntelliJ IDEA
#### 2. Importar el proyecto como proyecto Maven
#### 3. Asegurarse de que el JDK 11 esté configurado en el proyecto

## Contribución

1. Fork el proyecto
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request


-----
### Contacto
Andrés Serrón [aserron.dev@gmail.com](mailto:aserron.dev@gmail.com)   
[@andresserron](https://twitter.com/andresserron)

### Link del Proyecto: 
[https://github.com/aserron/challlenge-ing-oop-examen](https://github.com/aserron/challlenge-ing-oop-examen)
     
# Herencia en Vehículos

## Descripción del Problema
Implementar un sistema de herencia para vehículos que demuestre el concepto de herencia en Java. El sistema debe incluir:

1. Una clase base `Vehiculo` con atributos generales
2. Dos subclases (`Coche` y `Moto`) que extiendan la clase base
3. Sobrescritura del método `mostrarInfo()` en cada subclase

## Estructura de Clases

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

## Pruebas Unitarias

### VehiculoTest
```java
@Test
void testMostrarInfo() {
    vehiculo.mostrarInfo();
    assertEquals("Vehículo: Toyota Corolla" + System.lineSeparator(), 
                 outputStreamCaptor.toString());
}
```

### CocheTest
```java
@Test
void testMostrarInfo() {
    coche.mostrarInfo();
    String expectedOutput = "Coche: Honda Civic" + System.lineSeparator() +
                          "Número de puertas: 4" + System.lineSeparator() +
                          "Tipo de combustible: Gasolina" + System.lineSeparator();
    assertEquals(expectedOutput, outputStreamCaptor.toString());
}
```

### MotoTest
```java
@Test
void testMostrarInfo() {
    moto.mostrarInfo();
    String expectedOutput = "Moto: Honda CBR" + System.lineSeparator() +
                          "Cilindrada: 600cc" + System.lineSeparator() +
                          "Tiene maletero: Sí" + System.lineSeparator();
    assertEquals(expectedOutput, outputStreamCaptor.toString());
}
```

## Ejemplo de Uso
```java

  package com.examen.vehiculos;
  
  // Crear instancias
  Vehiculo vehiculo = new Vehiculo("Toyota", "Corolla");
  Coche coche = new Coche("Honda", "Civic", 4, "Gasolina");
  Moto moto = new Moto("Honda", "CBR", 600, true);
    
  // Mostrar información
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

## Consideraciones Técnicas
- Uso de herencia con `extends`
- Sobrescritura de métodos con `@Override`
- Captura de salida del sistema para pruebas
- Manejo de separadores de línea para compatibilidad multiplataforma
- Pruebas unitarias completas con JUnit
     
 