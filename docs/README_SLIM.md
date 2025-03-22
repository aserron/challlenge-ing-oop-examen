## Respuestas Detalladas

### Introducción

Este documento presenta respuestas detalladas a un cuestionario teórico sobre Programación Orientada a Objetos (POO),
con énfasis en Java. Las respuestas están dirigidas a un público profesional, utilizando el español como idioma principal,
permitiendo términos técnicos en inglés donde sea necesario.

## Respuesta Detallada a Cada Pregunta

### 1. Definición y Principios de la POO

La Programación Orientada a Objetos (POO) es un paradigma que organiza el código alrededor de objetos, que son unidades que combinan datos (atributos) y comportamiento (métodos). Este enfoque permite modelar software de manera similar a cómo percibimos objetos en el mundo real.

#### Los Cuatro Pilares

1. **Encapsulación**
   - Oculta los detalles internos de implementación
   - Expone solo una interfaz controlada
   - Protege la integridad de los datos
   - Ejemplo: Atributos privados con getters/setters

2. **Abstracción**
   - Representa características esenciales
   - Oculta complejidad innecesaria
   - Define interfaces claras
   - Ejemplo: Interfaces y clases abstractas

3. **Herencia**
   - Permite crear clases basadas en otras
   - Facilita la reutilización de código
   - Establece jerarquías de clases
   - Ejemplo: Una clase que extiende otra

4. **Polimorfismo**
   - Permite tratar objetos de diferentes clases uniformemente
   - Facilita el código genérico y flexible
   - Permite sobrescribir comportamientos
   - Ejemplo: Métodos con la misma firma en diferentes clases

#### Ejemplo Integrado

```java
// Abstracción mediante interfaz
interface Animal {
    void hacerSonido();
    void moverse();
}

// Encapsulación y herencia
class Gato implements Animal {
    private String nombre;  // Encapsulación
    private int edad;
    
    public Gato(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    // Getters y setters encapsulados
    public String getNombre() {
        return nombre;
    }
    
    // Implementación de métodos abstractos
    @Override
    public void hacerSonido() {
        System.out.println("Miau!");
    }
    
    @Override
    public void moverse() {
        System.out.println("El gato camina sigilosamente");
    }
}

// Polimorfismo en acción
class Zoo {
    public static void hacerActuar(Animal animal) {
        animal.hacerSonido();  // Llamada polimórfica
        animal.moverse();      // Comportamiento específico de cada animal
    }
    
    public static void main(String[] args) {
        Animal gato = new Gato("Michi", 3);
        hacerActuar(gato);     // El método funciona con cualquier Animal
    }
}
```

Este ejemplo demuestra:
- **Encapsulación**: Atributos privados con acceso controlado
- **Abstracción**: Interfaz `Animal` define comportamiento esencial
- **Herencia**: `Gato` implementa `Animal`
- **Polimorfismo**: Método `hacerActuar` funciona con cualquier `Animal`

### 2. Encapsulación: Explica el concepto de encapsulación y cómo se implementa en Java.

La encapsulación es un principio fundamental de la POO que consiste en ocultar los detalles internos de una clase y exponer solo una interfaz pública controlada. En Java, esto se implementa mediante modificadores de acceso y métodos getters/setters.

#### Modificadores de Acceso en Java

| Modificador | Acceso | Descripción | Uso Común |
|-------------|---------|-------------|------------|
| `private` | Solo dentro de la clase | Mayor nivel de encapsulamiento | Atributos internos |
| `protected` | Dentro de la clase y sus subclases | Acceso para herencia | Métodos y atributos heredables |
| `public` | Desde cualquier clase | Acceso total | Interfaz pública |
| (default) | Solo dentro del mismo paquete | Acceso a nivel de paquete | Componentes relacionados |

#### Ejemplo Básico de Encapsulación

```java
class CuentaBancaria {
    private double saldo;
    private String numeroCuenta;
    
    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }
    
    public double getSaldo() { return saldo; }
    
    public void setSaldo(double saldo) {
        if (saldo >= 0) this.saldo = saldo;
    }
    
    public void depositar(double cantidad) {
        if (cantidad > 0) this.saldo += cantidad;
    }
    
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            this.saldo -= cantidad;
            return true;
        }
        return false;
    }
}
```

### 3. Herencia y Polimorfismo

La herencia y el polimorfismo son conceptos fundamentales que trabajan juntos para crear código reutilizable y flexible. 

La **herencia** permite que una clase (subclase) herede atributos y métodos de otra clase (superclase), estableciendo una relación "es un" entre ellas. Esto facilita la reutilización de código y la creación de jerarquías de clases.

El **polimorfismo** permite que objetos de diferentes clases respondan al mismo mensaje de diferentes maneras. Esto se logra principalmente a través de la sobrescritura de métodos, donde una subclase proporciona su propia implementación de un método heredado.

#### Tipos de Herencia
- **Simple**: Una clase hereda de una sola clase base
- **Multinivel**: Una clase hereda de otra que ya hereda
- **Jerárquica**: Múltiples clases heredan de una base común

#### Ejemplo Práctico

```java
// Clase base
public class Animal {
    protected String nombre;
    
    public void comer() {
        System.out.println("El animal come");
    }
}

// Herencia: extiende la funcionalidad de Animal
public class Gato extends Animal {
    @Override
    public void comer() {
        System.out.println("El gato come pescado");
    }
    
    public void maullar() {
        System.out.println("El gato maulla");
    }
}

// Polimorfismo en acción
public class Main {
    public static void alimentarAnimal(Animal animal) {
        animal.comer();  // Llamada polimórfica
    }
    
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal gato = new Gato();
        
        alimentarAnimal(animal);  // Imprime: "El animal come"
        alimentarAnimal(gato);    // Imprime: "El gato come pescado"
    }
}
```

#### Beneficios
1. **Reutilización de código**: La herencia permite compartir código entre clases relacionadas
2. **Extensibilidad**: Facilita la adición de nuevas funcionalidades sin modificar código existente
3. **Flexibilidad**: El polimorfismo permite tratar objetos de diferentes clases de manera uniforme
4. **Mantenibilidad**: Los cambios en la clase base se propagan automáticamente a todas las subclases

La combinación de herencia y polimorfismo es esencial en el diseño orientado a objetos, permitiendo crear sistemas modulares y extensibles. La herencia proporciona la estructura jerárquica, mientras que el polimorfismo aporta la flexibilidad necesaria para manejar objetos de diferentes clases de manera uniforme.

### 4. Abstracción: ¿Qué es la abstracción en el contexto de la POO?

La abstracción es un principio fundamental de la POO que permite ocultar los detalles de implementación y mostrar solo las características esenciales de un objeto. En Java, la abstracción se logra principalmente a través de clases abstractas e interfaces.

#### Tipos de Abstracción en Java

| Tipo | Descripción | Características | Uso Común |
|------|-------------|-----------------|------------|
| **Clases Abstractas** | Clases que no pueden ser instanciadas directamente | - Pueden tener métodos abstractos y concretos<br>- Pueden tener constructores<br>- Pueden tener campos de instancia | Jerarquías de clases con comportamiento compartido |
| **Interfaces** | Contratos que definen un conjunto de métodos | - Métodos abstractos por defecto<br>- Métodos default desde Java 8<br>- Campos estáticos y finales | Definición de comportamientos compartidos |

#### Ejemplo Práctico: Sistema de Notificaciones

```java
interface Notificacion {
    void enviar(String mensaje);
    boolean validarDestino(String destino);
}

abstract class NotificacionElectronica implements Notificacion {
    protected String destino;
    protected String remitente;
    
    public NotificacionElectronica(String destino, String remitente) {
        this.destino = destino;
        this.remitente = remitente;
    }
    
    @Override
    public boolean validarDestino(String destino) {
        return destino != null && destino.contains("@");
    }
    
    protected void registrarEnvio() {
        System.out.println("Registrando envío a: " + destino);
    }
}

class NotificacionEmail extends NotificacionElectronica {
    private String asunto;
    
    public NotificacionEmail(String destino, String remitente, String asunto) {
        super(destino, remitente);
        this.asunto = asunto;
    }
    
    @Override
    public void enviar(String mensaje) {
        if (validarDestino(destino)) {
            System.out.println("Enviando email a: " + destino);
            System.out.println("Asunto: " + asunto);
            System.out.println("Mensaje: " + mensaje);
            registrarEnvio();
        }
    }
}
```

### 5. Constructores: ¿Cuál es el propósito de un constructor en una clase Java?

Los constructores son métodos especiales en Java que se utilizan para inicializar objetos cuando se crean. Su propósito principal es asegurar que los objetos estén en un estado válido y consistente desde su creación.

#### Tipos de Constructores en Java

| Tipo | Descripción | Características | Uso Común |
|------|-------------|-----------------|------------|
| **Constructor por Defecto** | Constructor sin parámetros | - Se crea automáticamente si no hay otros constructores<br>- Inicializa atributos con valores predeterminados | Clases simples |
| **Constructor Parametrizado** | Constructor con uno o más parámetros | - Se define explícitamente<br>- Permite inicializar atributos con valores específicos | Creación de objetos con datos iniciales |
| **Constructor de Copia** | Constructor que crea una copia de otro objeto | - Toma un objeto de la misma clase como parámetro<br>- Crea una copia profunda o superficial | Implementación del patrón Prototype |

#### Ejemplo Práctico: Sistema de Gestión de Empleados

```java


class main.com.gestion.prueba.

Empleado {
    private String id;
    private String nombre;
    private double salario;
    private LocalDate fechaIngreso;
    private List<String> habilidades;

    // Constructor por defecto
    public main.com.gestion.prueba.Empleado() {
        this.id = UUID.randomUUID().toString();
        this.fechaIngreso = LocalDate.now();
        this.habilidades = new ArrayList<>();
    }

    // Constructor parametrizado básico
    public main.com.gestion.prueba.Empleado(String nombre, double salario){
        this();
        this.nombre = nombre;
        this.salario = salario;
    }

    // Constructor parametrizado completo
    public main.com.gestion.prueba.Empleado(String nombre, double salario, List<String > habilidades){
        this(nombre, salario);
        this.habilidades = new ArrayList<>(habilidades);
    }

    // Constructor de copia
    public main.com.gestion.prueba.Empleado(com.examen.gestion.Empleado otro) {
        this.id = UUID.randomUUID().toString();
        this.nombre = otro.nombre;
        this.salario = otro.salario;
        this.fechaIngreso = otro.fechaIngreso;
        this.habilidades = new ArrayList<>(otro.habilidades);
    }
}
```

### 6. Interfaces: Define qué es una interfaz en Java.

Una interfaz en Java es un contrato que define un conjunto de métodos que una clase debe implementar. Es una forma de lograr la abstracción y el polimorfismo, permitiendo definir comportamientos que pueden ser implementados por diferentes clases.

#### Comparación entre Interfaces y Clases Abstractas

| Característica | Interfaces | Clases Abstractas |
|----------------|------------|-------------------|
| **Herencia** | Múltiple (una clase puede implementar varias interfaces) | Simple (una clase solo puede extender una clase abstracta) |
| **Constructores** | No pueden tener constructores | Pueden tener constructores |
| **Campos** | Solo campos estáticos y finales | Pueden tener campos de instancia |
| **Métodos** | Métodos abstractos por defecto, métodos default y static desde Java 8 | Pueden tener métodos abstractos y concretos |
| **Modificadores de Acceso** | Métodos públicos por defecto | Pueden tener cualquier modificador de acceso |

#### Ejemplo Práctico: Sistema de Pagos con Interfaces

```java
interface Pago {
    boolean procesarPago();
    String obtenerDetalles();
}

interface Descuentable {
    double calcularDescuento();
    void aplicarDescuento();
}

interface Fidelizable {
    int calcularPuntos();
    void acumularPuntos();
}

class PagoTarjeta implements Pago, Descuentable, Fidelizable {
    private double monto;
    private String numeroTarjeta;
    private double descuento;
    private int puntosAcumulados;
    
    public PagoTarjeta(double monto, String numeroTarjeta) {
        this.monto = monto;
        this.numeroTarjeta = numeroTarjeta;
        this.descuento = 0.0;
        this.puntosAcumulados = 0;
    }
    
    @Override
    public boolean procesarPago() {
        return validarTarjeta() && procesarTransaccion();
    }
    
    @Override
    public String obtenerDetalles() {
        return String.format("Pago con tarjeta: %s, Monto: %.2f", 
            numeroTarjeta, monto);
    }
    
    @Override
    public double calcularDescuento() {
        return monto * 0.05;
    }
    
    @Override
    public void aplicarDescuento() {
        monto -= calcularDescuento();
    }
    
    @Override
    public int calcularPuntos() {
        return (int) (monto * 0.1);
    }
    
    @Override
    public void acumularPuntos() {
        puntosAcumulados += calcularPuntos();
    }
}
```

### 7. Sobrecarga vs. Sobrescritura: Explica la diferencia.

La sobrecarga y la sobrescritura son dos mecanismos diferentes en Java que permiten reutilizar nombres de métodos, pero cada uno tiene un propósito y comportamiento específico.

#### Comparación entre Sobrecarga y Sobrescritura

| Característica | Sobrecarga (Overloading) | Sobrescritura (Overriding) |
|----------------|-------------------------|---------------------------|
| **Definición** | Múltiples métodos con el mismo nombre pero diferentes firmas en la misma clase | Método en subclase que reemplaza la implementación de un método de la superclase |
| **Firma** | Debe ser diferente (número o tipo de parámetros) | Debe ser idéntica a la del método de la superclase |
| **Retorno** | Puede ser diferente | Debe ser compatible con el tipo de retorno de la superclase |
| **Acceso** | Puede ser diferente | No puede ser más restrictivo que en la superclase |
| **Excepciones** | Puede lanzar cualquier excepción | No puede lanzar excepciones más amplias que la superclase |

#### Ejemplo Práctico: Sistema de Validación

```java
class Validador {
    // Sobrecarga: diferentes tipos de parámetros
    public boolean validar(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }
    
    public boolean validar(Integer numero) {
        return numero != null && numero > 0;
    }
    
    public boolean validar(List<?> lista) {
        return lista != null && !lista.isEmpty();
    }
    
    // Sobrecarga: diferente número de parámetros
    public boolean validar(String texto, int longitudMinima) {
        return validar(texto) && texto.length() >= longitudMinima;
    }
}

class ValidadorEmail extends Validador {
    // Sobrescritura: misma firma que el método de la superclase
    @Override
    public boolean validar(String texto) {
        return super.validar(texto) && 
               texto.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    // Sobrecarga: nuevo método con firma diferente
    public boolean validar(String email, String dominio) {
        return validar(email) && email.endsWith("@" + dominio);
    }
}
```

### 8. Palabras clave "this" y "super": ¿Qué significan y para qué se utilizan?

Las palabras clave `this` y `super` son referencias especiales en Java que permiten acceder a miembros de la clase actual y de la clase padre respectivamente.

#### Usos de this y super

| Palabra Clave | Uso | Descripción | Ejemplo |
|---------------|-----|-------------|----------|
| **this** | Referencia a la instancia actual | Accede a miembros de la clase actual | `this.nombre = nombre;` |
| **this()** | Llamada a constructor de la misma clase | Invoca otro constructor de la clase actual | `this(nombre, edad);` |
| **super** | Referencia a la clase padre | Accede a miembros de la clase padre | `super.metodo();` |
| **super()** | Llamada al constructor de la clase padre | Invoca el constructor de la clase padre | `super(nombre);` |

#### Ejemplo Práctico: Sistema de Gestión de Empleados

```java
class Persona {
    protected String nombre;
    protected String dni;
    protected LocalDate fechaNacimiento;
    
    public Persona(String nombre, String dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
    }
}

class main.com.gestion.prueba.Empleado extends Persona {
    private String cargo;
    private double salario;
    private List<String> habilidades;
    
    public main.com.gestion.prueba.Empleado(String nombre, String dni, LocalDate fechaNacimiento, 
                   String cargo, double salario) {
        super(nombre, dni, fechaNacimiento);
        this.cargo = cargo;
        this.salario = salario;
        this.habilidades = new ArrayList<>();
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Cargo: " + cargo);
        System.out.println("Salario: " + salario);
        System.out.println("Habilidades: " + habilidades);
    }
}
```

### 9. Herencia Múltiple: ¿Cómo se puede simular en Java?

Java no permite la herencia múltiple de clases para evitar la ambigüedad del "problema del diamante", pero proporciona mecanismos alternativos para lograr funcionalidad similar: las interfaces y la composición.

#### Mecanismos para Simular Herencia Múltiple

| Mecanismo | Descripción | Ventajas | Desventajas |
|-----------|-------------|-----------|-------------|
| **Interfaces** | Una clase puede implementar múltiples interfaces | - Permite definir contratos claros<br>- Facilita el desacoplamiento<br>- Soporta herencia múltiple de comportamiento | - No puede contener estado<br>- No puede tener constructores |
| **Composición** | Una clase contiene instancias de otras clases | - Mayor flexibilidad<br>- Mejor encapsulamiento<br>- Evita problemas de herencia | - Requiere más código<br>- Mayor complejidad inicial |

#### Ejemplo con Composición y Delegación

```java
class ProcesadorPago {
    public boolean procesar(double monto) {
        return monto > 0;
    }
}

class CalculadorDescuento {
    public double calcular(double monto) {
        return monto * 0.05;
    }
}

class GestorPuntos {
    public int calcular(double monto) {
        return (int) (monto * 0.1);
    }
}

class PagoComplejo {
    private final ProcesadorPago procesador;
    private final CalculadorDescuento calculador;
    private final GestorPuntos gestor;
    private double monto;
    
    public PagoComplejo(double monto) {
        this.monto = monto;
        this.procesador = new ProcesadorPago();
        this.calculador = new CalculadorDescuento();
        this.gestor = new GestorPuntos();
    }
    
    public boolean procesarPago() {
        return procesador.procesar(monto);
    }
    
    public void aplicarDescuento() {
        monto -= calculador.calcular(monto);
    }
    
    public int obtenerPuntos() {
        return gestor.calcular(monto);
    }
}
```

### 10. Patrones de Diseño: Explica brevemente qué son y menciona dos ejemplos.

Los patrones de diseño son soluciones generales y reutilizables a problemas comunes en el diseño de software. Se clasifican en tres categorías: creacionales, estructurales y de comportamiento.

#### Singleton:

- **Utilidad:** Garantiza que una clase tenga solo una instancia y proporcione un punto de acceso global a esa instancia.
- **Ejemplo:**
```java
class Singleton {
    private static Singleton instancia;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }
}
```

#### Factory (Fábrica):

- **Utilidad:** Proporciona una interfaz para crear objetos en una familia de clases relacionadas sin especificar sus clases concretas.
- **Ejemplo:**
```java
interface Forma {
    void dibujar();
}

class Circulo implements Forma {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}

class FactoryForma {
    public static Forma crearForma(String tipo) {
        if ("circulo".equals(tipo)) {
            return new Circulo();
        }
        return null;
    }
}
``` 