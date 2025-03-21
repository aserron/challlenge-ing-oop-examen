## #11. Clase Persona:  

[./prueba/Persona.java](./Persona.java) 

## #12. Cuentas Banco
[./prueba/Persona.java](banco/CuentaMain.java) 


## #14. Sobrecarga en Calculadora

Crea una clase Calculadora que contenga varios métodos sumar sobrecargados:

1. Uno que sume dos enteros,
2. Otro que sume tres enteros,
3. Y uno que sume dos números de punto flotante.
  
#### Solution : [Calculadora](./calc/Calculadora.java)

#### Test: [CalculadoraTest](/src/test/java/com/pruebas/calc/CalculadoraTest.java)
---

## #15. Herencia en Vehículos:

1. Define una clase Vehiculo con tributos generales (por ejemplo, marca y modelo) y un método `mostrarInfo()`.

2. Luego, crea dos subclases Coche y Moto que extiendan Vehiculo y sobrescriban el método mostrarInfo() para mostrar información específica de cada tipo de vehículo.


## #16. Clase Abstracta Animal

1. Crea una clase abstracta Animal que defina un método abstracto hacerSonido().

2. Luego, implementa dos clases concretas, Perro y Gato, que extiendan Animal e implementen el método hacerSonido() mostrando, por ejemplo, "Guau" y "Miau" respectivamente.


## #17.  Gestión de Empleados en una Empresa:

    Desarrolla una clase main.com.gestion.prueba.Empleado con atributos como nombre, id y salario.
    1. Crea una clase Empresa que contenga una colección (por ejemplo, un ArrayList) de empleados.
    2. Implementa métodos para agregar un empleado y listar todos los empleados.


## #18 Excepciones Personalizadas:

    Diseña una excepción personalizada llamada ProductoNoEncontradoException.
    - Crea un método en una clase Inventario que busque un producto por su ID y
      lance la excepción si el producto no se encuentra.
    - Demuestra cómo manejar esta excepción con un bloque try-catch.

## #19 Sistema de Préstamo de Libros:

    Crea una clase Libro con atributos como titulo, autor y un indicador de disponibilidad.
    - Implementa una clase Biblioteca que gestione una lista de libros.
    - Desarrolla un método prestarLibro(String titulo) que verifique la disponibilidad
      del libro, actualice su estado y maneje el caso en que el libro no esté disponible mediante excepciones.

## #20 Patrón Singleton en un Juego:

    Crea una clase Juego que utilice el patrón de diseño Singleton para asegurar que solo exista una instancia en la
    aplicación.

| --------------------------------- | ---------------------------------------------- |

| Ejercicio | Solucion |
| --------------------------------- | ----------------------------------------------------- |
| 11. Clase Persona: | [./prueba/Persona.java](./Persona.java) |
| 12. Cuentas Banco | [./prueba/Persona.java](banco/CuentaMain.java) |
| | - ./banco/CuentaBancaria.java | |
| | - ./banco/CuentaCorriente.java | |
| | - ./banco/CuentaAhorros.java | |
| --------------------------------- | ---------------------------------------------- |
| 13. Interfaz Operable | [ns:prueba/banco.*](./operar) |
| | [operar.Operable](operar/Operable.java) |
| | [operar.Sum](operar/Suma.java) |
| | [operar.Multiplicacion](operar/Multiplicacion.java) |
| --------------------------------- | ---------------------------------------------- |
| 14. Sobrecarga en Calculadora: | [ns:main.com.calc.prueba.Calculadora](calc/Calculadora.java) |
| --------------------------------- | ---------------------------------------------- |
| 13. Clase Abstracta Animal        | [ns:prueba/animales.*](./animales) |
| | [operar.Operable](operar/Operable.java)          |                                                |
| | [operar.Sum](operar/Suma.java)               |                                                |
| | [operar.Multiplicacion](operar/Multiplicacion.java)    |                                              |

### 18

Solution.
demo    : InventarioMain
test    :
carpeta : src\main\java\com\pruebas\exceptions
package :  com.pruebas.exceptions
