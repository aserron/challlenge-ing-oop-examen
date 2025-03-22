11.	Clase Persona:
       Crea una clase Persona con atributos privados como nombre y edad. Incluye un constructor, métodos getter y setter, y un método saludar que imprima:
       "Hola, soy [nombre] y tengo [edad] años."

12.	Jerarquía de Cuentas Bancarias:
       Diseña una jerarquía de clases para representar una cuenta bancaria. Crea una clase base CuentaBancaria y dos subclases: CuentaCorriente y CuentaAhorros.
       a.	Implementa métodos para depositar y retirar dinero.
       b.	Demuestra el uso de la sobreescritura en uno de los métodos (por ejemplo, un método para calcular intereses o aplicar comisiones).

14. Interfaz Operable:
    Define una interfaz Operable con un método operar(int a, int b) que retorne un entero.
    * Implementa dos clases: Suma y Multiplicacion, que implementen la interfaz con comportamientos distintos para el método operar.

14. Sobrecarga en Calculadora:
    Crea una clase Calculadora que contenga varios métodos sumar sobrecargados:
    * Uno que sume dos enteros,
    * Otro que sume tres enteros,
    * Y uno que sume dos números de punto flotante.
    
15. Herencia en Vehículos:
    Define una clase Vehiculo con atributos generales (por ejemplo, marca y modelo) y un método mostrarInfo().
    * Luego, crea dos subclases Coche y Moto que extiendan Vehiculo y sobrescriban el método mostrarInfo() para mostrar información específica de cada tipo de vehículo.
    
16. Gestión de Empleados en una Empresa:
    Desarrolla una clase Empleado con atributos como nombre, id y salario.
    * Crea una clase Empresa que contenga una colección (por ejemplo, un ArrayList) de empleados.
    * Implementa métodos para agregar un empleado y listar todos los empleados.

17. Excepciones Personalizadas:
    Diseña una excepción personalizada llamada ProductoNoEncontradoException.
    Crea un método en una clase Inventario que busque un producto por su ID y lance la excepción si el producto no se encuentra.
    * Demuestra cómo manejar esta excepción con un bloque try-catch.

18. Sistema de Préstamo de Libros:
    Crea una clase Libro con atributos como titulo, autor y un indicador de disponibilidad.
    * Implementa una clase Biblioteca que gestione una lista de libros.
    * Desarrolla un método prestarLibro(String titulo) que verifique la disponibilidad del libro, actualice su estado
    y maneje el caso en que el libro no esté disponible mediante excepciones.
19. Patrón Singleton en un Juego:
    Crea una clase Juego que utilice el patrón de diseño Singleton para asegurar que solo exista una instancia en la
    aplicación.
    * Incluye un método iniciarJuego() que imprima un mensaje indicando que el juego ha comenzado.
    * Demuestra, en un método main, que solo se crea una única instancia de la clase Juego.
