## Respuestas Detalladas

### Introducción

Este documento presenta respuestas detalladas a un cuestionario teórico sobre Programación Orientada a Objetos (POO),
con énfasis en Java, considerando el contexto de backends con Java/SpringFramework y aplicaciones web/data/lambda con
Python y Node. Las respuestas están dirigidas a un público profesional, asegurando factuality y utilizando fuentes
educativas de primer nivel, con referencias incluidas para cada respuesta. Se emplea el español como idioma principal,
permitiendo términos técnicos en inglés donde sea necesario.

## Respuesta Detallada a Cada Pregunta

### 1. Definición y Principios: ¿Qué es la Programación Orientada a Objetos (POO) y cuáles son sus cuatro pilares fundamentales?

La Programación Orientada a Objetos (POO) es un paradigma de programación que organiza el código en torno a "objetos" que encapsulan datos (atributos) y comportamiento (métodos). Este enfoque permite modelar el mundo real de manera más natural y mantener el código más organizado y mantenible.

#### Los Cuatro Pilares Fundamentales

| Pilar | Descripción | Beneficio Principal | Ejemplo Práctico |
|-------|-------------|---------------------|------------------|
| **Encapsulación** | Ocultar la implementación interna y exponer solo lo necesario | Protección de datos y control de acceso | Getters y setters para atributos privados |
| **Abstracción** | Simplificar la complejidad mostrando solo características relevantes | Reducción de complejidad y mejor mantenibilidad | Interfaces y clases abstractas |
| **Herencia** | Crear nuevas clases basadas en clases existentes | Reutilización de código y organización jerárquica | Clases base y derivadas |
| **Polimorfismo** | Tratar objetos de diferentes clases de manera uniforme | Flexibilidad y extensibilidad | Sobrescritura de métodos |

#### Ejemplo Práctico: Sistema de Vehículos

```java
// Abstracción: Definimos una interfaz común
public interface Vehiculo {
    void acelerar();
    void frenar();
}

// Encapsulación: Ocultamos detalles internos
public class Coche implements Vehiculo {
    private int velocidad;  // Atributo privado
    private String marca;   // Atributo privado
    
    // Getters y setters para acceso controlado
    public int getVelocidad() {
        return velocidad;
    }
    
    public void setVelocidad(int velocidad) {
        if (velocidad >= 0) {
            this.velocidad = velocidad;
        }
    }
    
    // Implementación de métodos de la interfaz
    @Override
    public void acelerar() {
        velocidad += 10;
    }
    
    @Override
    public void frenar() {
        velocidad = Math.max(0, velocidad - 10);
    }
}

// Herencia: Crear una clase específica
public class CocheElectrico extends Coche {
    private int nivelBateria;
    
    @Override
    public void acelerar() {
        if (nivelBateria > 0) {
            super.acelerar();
            nivelBateria -= 5;
        }
    }
}

// Polimorfismo: Tratar diferentes vehículos de manera uniforme
public class TestVehiculos {
    public static void main(String[] args) {
        Vehiculo[] vehiculos = new Vehiculo[2];
        vehiculos[0] = new Coche();
        vehiculos[1] = new CocheElectrico();
        
        // Polimorfismo: cada vehículo responde según su implementación
        for (Vehiculo v : vehiculos) {
            v.acelerar();
        }
    }
}
```

#### Aplicación en el Mundo Real

En aplicaciones web modernas, estos principios son fundamentales:

1. **Encapsulación**: Protege datos sensibles en entidades de base de datos
2. **Abstracción**: Define contratos claros entre capas de la aplicación
3. **Herencia**: Reutiliza código en controladores y servicios
4. **Polimorfismo**: Permite manejar diferentes tipos de respuestas HTTP

Por ejemplo, en Spring Framework:
```java
// Abstracción: Definimos un servicio genérico
public interface UserService {
    User findById(Long id);
    List<User> findAll();
}

// Encapsulación: Implementación con datos protegidos
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    
    @Override
    public User findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
    }
    
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
```

**Referencias:**
- [Oracle Java Documentation: Object-Oriented Programming Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Spring Framework Documentation: Core Technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

---

### 2. Encapsulación: Explica el concepto de encapsulación y cómo se implementa en Java. ¿Qué ventajas ofrece a la hora de diseñar aplicaciones?

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
public class CuentaBancaria {
    // Atributos privados
    private double saldo;
    private String numeroCuenta;
    
    // Constructor
    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }
    
    // Getters y setters con validación
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }
    
    // Métodos públicos que encapsulan la lógica de negocio
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
        }
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

#### Ejemplo Avanzado: Encapsulación en Spring Framework

```java
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String passwordHash;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;
    
    // Constructor privado para JPA
    protected Usuario() {}
    
    // Constructor público con validación
    public Usuario(String email, String password) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }
        this.email = email;
        this.passwordHash = hashPassword(password);
        this.pedidos = new ArrayList<>();
    }
    
    // Getters y setters con validación
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }
        this.email = email;
    }
    
    // Método privado para hash de contraseña
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
    // Método público para verificar contraseña
    public boolean verificarPassword(String password) {
        return BCrypt.checkpw(password, this.passwordHash);
    }
    
    // Método para agregar pedido con validación
    public void agregarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        pedido.setUsuario(this);
        this.pedidos.add(pedido);
    }
}
```

#### Ventajas de la Encapsulación

1. **Seguridad de Datos**
   - Protege información sensible
   - Controla el acceso a los datos
   - Permite validación de datos

2. **Mantenibilidad**
   - Facilita cambios internos sin afectar el código cliente
   - Mejora la organización del código
   - Reduce acoplamiento entre componentes

3. **Flexibilidad**
   - Permite cambiar implementaciones sin afectar el código cliente
   - Facilita la evolución del sistema
   - Mejora la reutilización de código

4. **Abstracción**
   - Oculta la complejidad interna
   - Simplifica la interfaz pública
   - Mejora la usabilidad de las clases

#### Mejores Prácticas

1. **Atributos**
   - Declarar atributos como `private` por defecto
   - Usar `protected` solo cuando sea necesario para herencia
   - Evitar atributos `public`

2. **Métodos**
   - Proporcionar getters/setters solo cuando sea necesario
   - Incluir validación en setters
   - Usar métodos privados para lógica interna

3. **Constructores**
   - Validar parámetros en constructores
   - Proporcionar constructores que inicialicen todos los atributos necesarios
   - Usar el patrón Builder para objetos complejos

**Referencias:**
- [Oracle Java Documentation: Access Control](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
- [Spring Framework Documentation: Data Access](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html)

---

### 3. Herencia y Polimorfismo: Describe la relación entre herencia y polimorfismo. ¿Cómo permite la herencia reutilizar código y qué rol juega el polimorfismo en la extensión de comportamientos?

La herencia y el polimorfismo son dos pilares fundamentales de la POO que trabajan juntos para crear sistemas flexibles y extensibles. La herencia permite la reutilización de código, mientras que el polimorfismo permite que diferentes objetos respondan de manera específica a las mismas operaciones.

#### Tipos de Herencia en Java

| Tipo | Descripción | Ejemplo |
|------|-------------|---------|
| **Simple** | Una clase hereda de una sola clase base | `class Perro extends Animal` |
| **Multinivel** | Una clase hereda de otra que ya hereda | `class Cachorro extends Perro` |
| **Jerárquica** | Múltiples clases heredan de una base | `class Gato extends Animal` |
| **Interfaces** | Una clase implementa múltiples interfaces | `class Pajaro implements Volador, Cantor` |

#### Ejemplo Básico: Sistema de Pagos

```java
// Clase base abstracta
public abstract class Pago {
    protected double monto;
    protected String moneda;
    protected LocalDateTime fecha;
    
    public Pago(double monto, String moneda) {
        this.monto = monto;
        this.moneda = moneda;
        this.fecha = LocalDateTime.now();
    }
    
    // Método abstracto que será implementado por las subclases
    public abstract boolean procesarPago();
    
    // Método común para todas las subclases
    public String obtenerDetalles() {
        return String.format("Pago de %s %s realizado el %s", 
            monto, moneda, fecha);
    }
}

// Subclase concreta
public class PagoTarjeta extends Pago {
    private String numeroTarjeta;
    private String cvv;
    
    public PagoTarjeta(double monto, String moneda, 
                      String numeroTarjeta, String cvv) {
        super(monto, moneda);
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
    }
    
    @Override
    public boolean procesarPago() {
        // Implementación específica para tarjeta
        return validarTarjeta() && procesarTransaccion();
    }
    
    private boolean validarTarjeta() {
        // Lógica de validación
        return true;
    }
    
    private boolean procesarTransaccion() {
        // Lógica de procesamiento
        return true;
    }
}

// Otra subclase concreta
public class PagoPayPal extends Pago {
    private String email;
    private String password;
    
    public PagoPayPal(double monto, String moneda, 
                     String email, String password) {
        super(monto, moneda);
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean procesarPago() {
        // Implementación específica para PayPal
        return autenticarPayPal() && procesarPagoPayPal();
    }
    
    private boolean autenticarPayPal() {
        // Lógica de autenticación
        return true;
    }
    
    private boolean procesarPagoPayPal() {
        // Lógica de procesamiento
        return true;
    }
}
```

#### Polimorfismo en Acción

```java
public class ProcesadorPagos {
    public void procesarPagos(List<Pago> pagos) {
        for (Pago pago : pagos) {
            // Polimorfismo: cada tipo de pago responde de manera diferente
            if (pago.procesarPago()) {
                System.out.println("Pago exitoso: " + pago.obtenerDetalles());
            } else {
                System.out.println("Error en el pago: " + pago.obtenerDetalles());
            }
        }
    }
    
    public static void main(String[] args) {
        ProcesadorPagos procesador = new ProcesadorPagos();
        List<Pago> pagos = new ArrayList<>();
        
        // Crear diferentes tipos de pagos
        pagos.add(new PagoTarjeta(100.0, "USD", "1234-5678", "123"));
        pagos.add(new PagoPayPal(200.0, "EUR", "usuario@email.com", "****"));
        
        // Procesar todos los pagos de manera polimórfica
        procesador.procesarPagos(pagos);
    }
}
```

#### Aplicación en Spring Framework

```java
// Interfaz base para servicios
public interface UserService {
    User findById(Long id);
    List<User> findAll();
    User save(User user);
}

// Implementación básica
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    
    @Override
    public User findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
    }
    
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
    
    @Override
    public User save(User user) {
        return repository.save(user);
    }
}

// Implementación extendida con caché
@Service
public class CachedUserServiceImpl extends UserServiceImpl {
    @Autowired
    private CacheManager cacheManager;
    
    @Override
    public User findById(Long id) {
        Cache cache = cacheManager.getCache("users");
        Cache.ValueWrapper wrapper = cache.get(id);
        
        if (wrapper != null) {
            return (User) wrapper.get();
        }
        
        User user = super.findById(id);
        cache.put(id, user);
        return user;
    }
}
```

#### Ventajas de la Herencia y Polimorfismo

1. **Reutilización de Código**
   - Evita duplicación de código
   - Centraliza funcionalidad común
   - Facilita el mantenimiento

2. **Extensibilidad**
   - Permite añadir nuevas funcionalidades
   - Facilita la creación de nuevas clases
   - Mantiene la compatibilidad con código existente

3. **Flexibilidad**
   - Permite tratar objetos de manera uniforme
   - Facilita la creación de sistemas modulares
   - Mejora la adaptabilidad del código

4. **Mantenibilidad**
   - Centraliza cambios comunes
   - Reduce la duplicación de código
   - Facilita las examen unitarias

**Referencias:**
- [Oracle Java Documentation: Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Spring Framework Documentation: Core Technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

---

### 4. Abstracción: ¿Qué es la abstracción en el contexto de la POO? Explica cómo se puede lograr en Java mediante clases abstractas e interfaces.

La abstracción es un principio fundamental de la POO que permite ocultar los detalles de implementación y mostrar solo las características esenciales de un objeto. En Java, la abstracción se logra principalmente a través de clases abstractas e interfaces.

#### Tipos de Abstracción en Java

| Tipo | Descripción | Características | Uso Común |
|------|-------------|-----------------|------------|
| **Clases Abstractas** | Clases que no pueden ser instanciadas directamente | - Pueden tener métodos abstractos y concretos<br>- Pueden tener constructores<br>- Pueden tener campos de instancia | Jerarquías de clases con comportamiento compartido |
| **Interfaces** | Contratos que definen un conjunto de métodos | - Métodos abstractos por defecto<br>- Métodos default desde Java 8<br>- Campos estáticos y finales | Definición de comportamientos compartidos |

#### Ejemplo Práctico: Sistema de Notificaciones

```java
// Interfaz base para notificaciones
public interface Notificacion {
    void enviar(String mensaje);
    boolean validarDestino(String destino);
}

// Clase abstracta para notificaciones electrónicas
public abstract class NotificacionElectronica implements Notificacion {
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
    
    // Método común para todas las notificaciones electrónicas
    protected void registrarEnvio() {
        System.out.println("Registrando envío a: " + destino);
    }
}

// Implementación concreta para email
public class NotificacionEmail extends NotificacionElectronica {
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

// Implementación concreta para SMS
public class NotificacionSMS implements Notificacion {
    private String numeroTelefono;
    
    public NotificacionSMS(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    
    @Override
    public boolean validarDestino(String destino) {
        return destino != null && destino.matches("\\d{10}");
    }
    
    @Override
    public void enviar(String mensaje) {
        if (validarDestino(numeroTelefono)) {
            System.out.println("Enviando SMS a: " + numeroTelefono);
            System.out.println("Mensaje: " + mensaje);
        }
    }
}
```

#### Interfaces Funcionales y Métodos Default

```java
// Interfaz funcional con métodos default
public interface Validador<T> {
    boolean validar(T valor);
    
    default boolean validarLista(List<T> valores) {
        return valores.stream()
                     .allMatch(this::validar);
    }
    
    default boolean validarAlguno(List<T> valores) {
        return valores.stream()
                     .anyMatch(this::validar);
    }
    
    static <T> Validador<T> siempreVerdadero() {
        return valor -> true;
    }
}

// Implementación de interfaz funcional
public class ValidadorEmail implements Validador<String> {
    @Override
    public boolean validar(String email) {
        return email != null && 
               email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}

// Uso de la interfaz funcional
public class ProcesadorEmails {
    private final Validador<String> validador;
    
    public ProcesadorEmails(Validador<String> validador) {
        this.validador = validador;
    }
    
    public void procesarEmails(List<String> emails) {
        if (validador.validarLista(emails)) {
            emails.forEach(email -> 
                System.out.println("Procesando email: " + email));
        }
    }
}
```

#### Aplicación en Spring Framework

```java
// Interfaz base para servicios de persistencia
public interface PersistenceService<T> {
    T save(T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
    void delete(T entity);
    
    // Método default para operaciones comunes
    default boolean existsById(Long id) {
        return findById(id).isPresent();
    }
    
    // Método default para operaciones en lote
    default List<T> saveAll(Iterable<T> entities) {
        List<T> result = new ArrayList<>();
        entities.forEach(entity -> result.add(save(entity)));
        return result;
    }
}

// Interfaz para servicios con caché
public interface CacheableService<T> {
    T findById(Long id);
    
    default T findByIdWithCache(Long id, Cache cache) {
        Cache.ValueWrapper wrapper = cache.get(id);
        if (wrapper != null) {
            return (T) wrapper.get();
        }
        T entity = findById(id);
        cache.put(id, entity);
        return entity;
    }
}

// Implementación que usa múltiples interfaces
@Service
public class UsuarioService implements PersistenceService<Usuario>, CacheableService<Usuario> {
    private final UsuarioRepository repository;
    private final Cache cache;
    
    public UsuarioService(UsuarioRepository repository, Cache cache) {
        this.repository = repository;
        this.cache = cache;
    }
    
    @Override
    public Usuario save(Usuario entity) {
        return repository.save(entity);
    }
    
    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }
    
    @Override
    public void delete(Usuario entity) {
        repository.delete(entity);
    }
    
    @Override
    public Usuario findById(Long id) {
        return findByIdWithCache(id, cache);
    }
}
```

#### Ventajas de la Abstracción

1. **Reducción de Complejidad**
   - Oculta detalles de implementación
   - Simplifica la interfaz pública
   - Mejora la legibilidad del código

2. **Flexibilidad**
   - Permite cambiar implementaciones
   - Facilita la extensibilidad
   - Mejora la mantenibilidad

3. **Reutilización**
   - Comparte código común
   - Define comportamientos estándar
   - Facilita la creación de frameworks

4. **Desacoplamiento**
   - Reduce dependencias
   - Mejora la modularidad
   - Facilita las examen

**Referencias:**
- [Oracle Java Documentation: Abstract Methods and Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Spring Framework Documentation: Core Technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

---

### 5. Constructores: ¿Cuál es el propósito de un constructor en una clase Java? Menciona la diferencia entre un constructor por defecto y un constructor parametrizado.

Los constructores son métodos especiales en Java que se utilizan para inicializar objetos cuando se crean. Su propósito principal es asegurar que los objetos estén en un estado válido y consistente desde su creación, estableciendo los valores iniciales de sus atributos.

#### Tipos de Constructores en Java

| Tipo | Descripción | Características | Uso Común |
|------|-------------|-----------------|------------|
| **Constructor por Defecto** | Constructor sin parámetros | - Se crea automáticamente si no hay otros constructores<br>- Inicializa atributos con valores predeterminados | Clases simples o frameworks que requieren instanciación sin parámetros |
| **Constructor Parametrizado** | Constructor con uno o más parámetros | - Se define explícitamente<br>- Permite inicializar atributos con valores específicos | Creación de objetos con datos iniciales |
| **Constructor de Copia** | Constructor que crea una copia de otro objeto | - Toma un objeto de la misma clase como parámetro<br>- Crea una copia profunda o superficial | Implementación del patrón Prototype |

#### Ejemplo Práctico: Sistema de Gestión de Empleados

```java


public class Empleado

Empleado {
   private String id;
   private String nombre;
   private double salario;
   private LocalDate fechaIngreso;
   private List<String> habilidades;

   // Constructor por defecto
    public main.com.gestion.prueba.Empleado()

   {
      this.id = UUID.randomUUID().toString();
      this.fechaIngreso = LocalDate.now();
      this.habilidades = new ArrayList<>();
   }

   // Constructor parametrizado básico
    public main.com.gestion.prueba.Empleado(
   String nombre, double salario)

   {
      this(); // Llama al constructor por defecto
      this.nombre = nombre;
      this.salario = salario;
   }

   // Constructor parametrizado completo
    public main.com.gestion.prueba.Empleado(
   String nombre, double salario, List<String>habilidades)

   {
      this(nombre, salario); // Llama al constructor parametrizado básico
      this.habilidades = new ArrayList<>(habilidades);
   }

   // Constructor de copia
    public main.com.gestion.prueba.Empleado(
   com.examen.gestion.Empleado otro)

   {
      this.id = UUID.randomUUID().toString(); // Nueva ID para la copia
      this.nombre = otro.nombre;
      this.salario = otro.salario;
      this.fechaIngreso = otro.fechaIngreso;
      this.habilidades = new ArrayList<>(otro.habilidades); // Copia profunda
   }

   // Getters y setters
   public String getId() {
      return id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public double getSalario() {
      return salario;
   }

   public void setSalario(double salario) {
      this.salario = salario;
   }

   public LocalDate getFechaIngreso() {
      return fechaIngreso;
   }

   public List<String> getHabilidades() {
      return new ArrayList<>(habilidades);
   }
}
```

#### Encadenamiento de Constructores y Validación

```java
public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    private String titular;
    private List<Transaccion> historial;
    
    // Constructor privado para inicialización común
    private CuentaBancaria() {
        this.numeroCuenta = generarNumeroCuenta();
        this.historial = new ArrayList<>();
    }
    
    // Constructor público con validación
    public CuentaBancaria(String titular, double saldoInicial) {
        this(); // Llama al constructor privado
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular no puede ser nulo o vacío");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    // Constructor para cuentas empresariales
    public CuentaBancaria(String titular, double saldoInicial, String tipoEmpresa) {
        this(titular, saldoInicial); // Llama al constructor público
        if (tipoEmpresa == null || tipoEmpresa.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de empresa no puede ser nulo o vacío");
        }
        // Lógica adicional para cuentas empresariales
    }
    
    private String generarNumeroCuenta() {
        return "ACC-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
```

#### Aplicación en Spring Framework

```java
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private BigDecimal precio;
    
    @Column(nullable = false)
    private Integer stock;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    // Constructor protegido para JPA
    protected Producto() {}
    
    // Constructor público con validación
    public Producto(String nombre, BigDecimal precio, Integer stock) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }
        if (stock == null || stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    // Constructor para productos con categoría
    public Producto(String nombre, BigDecimal precio, Integer stock, Categoria categoria) {
        this(nombre, precio, stock);
        this.categoria = categoria;
    }
}
```

#### Ventajas de los Constructores

1. **Inicialización Controlada**
   - Asegura estado válido del objeto
   - Previene objetos en estado inconsistente
   - Facilita la validación de datos

2. **Encapsulamiento**
   - Controla el acceso a los atributos
   - Permite validación de datos
   - Mantiene la integridad del objeto

3. **Flexibilidad**
   - Permite diferentes formas de inicialización
   - Facilita la creación de objetos
   - Mejora la reutilización de código

4. **Mantenibilidad**
   - Centraliza la lógica de inicialización
   - Facilita cambios en la creación de objetos
   - Mejora la legibilidad del código

**Referencias:**
- [Oracle Java Documentation: Providing Constructors for Your Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)
- [Spring Framework Documentation: Core Technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

---

### 6. Interfaces: Define qué es una interfaz en Java y explica en qué se diferencia de una clase abstracta. ¿Cuándo es preferible utilizar una interfaz?

Una interfaz en Java es un contrato que define un conjunto de métodos que una clase debe implementar. Es una forma de lograr la abstracción y el polimorfismo, permitiendo definir comportamientos que pueden ser implementados por diferentes clases sin necesidad de una jerarquía de herencia.

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
// Interfaz base para pagos
public interface Pago {
    boolean procesarPago();
    String obtenerDetalles();
}

// Interfaz para pagos con descuento
public interface Descuentable {
    double calcularDescuento();
    void aplicarDescuento();
}

// Interfaz para pagos con puntos de fidelidad
public interface Fidelizable {
    int calcularPuntos();
    void acumularPuntos();
}

// Implementación que usa múltiples interfaces
public class PagoTarjeta implements Pago, Descuentable, Fidelizable {
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
        // Implementación del procesamiento de pago
        return true;
    }
    
    @Override
    public String obtenerDetalles() {
        return String.format("Pago con tarjeta: %s, Monto: %.2f", 
            numeroTarjeta, monto);
    }
    
    @Override
    public double calcularDescuento() {
        return monto * 0.05; // 5% de descuento
    }
    
    @Override
    public void aplicarDescuento() {
        monto -= calcularDescuento();
    }
    
    @Override
    public int calcularPuntos() {
        return (int) (monto * 0.1); // 1 punto por cada 10 unidades monetarias
    }
    
    @Override
    public void acumularPuntos() {
        puntosAcumulados += calcularPuntos();
    }
}
```

#### Interfaces Funcionales y Métodos Default

```java
// Interfaz funcional con métodos default
public interface Validador<T> {
    boolean validar(T valor);
    
    default boolean validarLista(List<T> valores) {
        return valores.stream()
                     .allMatch(this::validar);
    }
    
    default boolean validarAlguno(List<T> valores) {
        return valores.stream()
                     .anyMatch(this::validar);
    }
    
    static <T> Validador<T> siempreVerdadero() {
        return valor -> true;
    }
}

// Implementación de interfaz funcional
public class ValidadorEmail implements Validador<String> {
    @Override
    public boolean validar(String email) {
        return email != null && 
               email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}

// Uso de la interfaz funcional
public class ProcesadorEmails {
    private final Validador<String> validador;
    
    public ProcesadorEmails(Validador<String> validador) {
        this.validador = validador;
    }
    
    public void procesarEmails(List<String> emails) {
        if (validador.validarLista(emails)) {
            emails.forEach(email -> 
                System.out.println("Procesando email: " + email));
        }
    }
}
```

#### Aplicación en Spring Framework

```java
// Interfaz base para servicios de persistencia
public interface PersistenceService<T> {
    T save(T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
    void delete(T entity);
    
    // Método default para operaciones comunes
    default boolean existsById(Long id) {
        return findById(id).isPresent();
    }
    
    // Método default para operaciones en lote
    default List<T> saveAll(Iterable<T> entities) {
        List<T> result = new ArrayList<>();
        entities.forEach(entity -> result.add(save(entity)));
        return result;
    }
}

// Interfaz para servicios con caché
public interface CacheableService<T> {
    T findById(Long id);
    
    default T findByIdWithCache(Long id, Cache cache) {
        Cache.ValueWrapper wrapper = cache.get(id);
        if (wrapper != null) {
            return (T) wrapper.get();
        }
        T entity = findById(id);
        cache.put(id, entity);
        return entity;
    }
}

// Implementación que usa múltiples interfaces
@Service
public class UsuarioService implements PersistenceService<Usuario>, CacheableService<Usuario> {
    private final UsuarioRepository repository;
    private final Cache cache;
    
    public UsuarioService(UsuarioRepository repository, Cache cache) {
        this.repository = repository;
        this.cache = cache;
    }
    
    @Override
    public Usuario save(Usuario entity) {
        return repository.save(entity);
    }
    
    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }
    
    @Override
    public void delete(Usuario entity) {
        repository.delete(entity);
    }
    
    @Override
    public Usuario findById(Long id) {
        return findByIdWithCache(id, cache);
    }
}
```

#### Cuándo Usar Interfaces

1. **Definición de Contratos**
   - Cuando se necesita definir un comportamiento que puede ser implementado por diferentes clases
   - Para establecer una API clara y consistente
   - En la definición de servicios y repositorios

2. **Herencia Múltiple**
   - Cuando una clase necesita implementar múltiples comportamientos
   - Para simular herencia múltiple de comportamiento
   - En la implementación de patrones de diseño

3. **Desacoplamiento**
   - Para reducir el acoplamiento entre componentes
   - En la implementación de patrones de diseño como Strategy
   - Para facilitar las examen unitarias

4. **Extensibilidad**
   - Cuando se necesita añadir nuevas funcionalidades sin modificar código existente
   - En la implementación de plugins o módulos
   - Para facilitar la evolución del sistema

**Referencias:**
- [Oracle Java Documentation: Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
- [Spring Framework Documentation: Core Technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

---

### 7. Sobrecarga vs. Sobrescritura: Explica la diferencia entre sobrecarga (overloading) y sobrescritura (overriding) de métodos. ¿Qué ventajas ofrece cada uno en el diseño de clases?

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
// Clase base con métodos sobrecargados
public class Validador {
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
    
    public boolean validar(String texto, int longitudMinima, int longitudMaxima) {
        return validar(texto, longitudMinima) && 
               texto.length() <= longitudMaxima;
    }
}

// Clase derivada que sobrescribe y sobrecarga
public class ValidadorEmail extends Validador {
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

#### Ejemplo Avanzado: Sistema de Pagos

```java
// Clase base para pagos
public abstract class Pago {
    protected double monto;
    protected String moneda;
    
    // Método base para procesar pagos
    public abstract boolean procesarPago();
    
    // Método sobrecargado para validar montos
    protected boolean validarMonto(double monto) {
        return monto > 0;
    }
    
    protected boolean validarMonto(double monto, double limite) {
        return validarMonto(monto) && monto <= limite;
    }
}

// Clase concreta
public class PagoTarjeta extends Pago {
    private String numeroTarjeta;
    
    // Sobrescritura del método abstracto
    @Override
    public boolean procesarPago() {
        return validarTarjeta() && validarMonto(monto);
    }
    
    // Sobrecarga del método validarMonto
    protected boolean validarMonto(double monto, double limite, String tipoTarjeta) {
        return validarMonto(monto, limite) && 
               validarLimiteTarjeta(tipoTarjeta, monto);
    }
    
    private boolean validarTarjeta() {
        return numeroTarjeta != null && 
               numeroTarjeta.matches("\\d{16}");
    }
    
    private boolean validarLimiteTarjeta(String tipoTarjeta, double monto) {
        // Lógica específica para validar límites según tipo de tarjeta
        return true;
    }
}
```

#### Aplicación en Spring Framework

```java
// Controlador base con métodos sobrecargados
@RestController
@RequestMapping("/api")
public class BaseController {
    // Sobrecarga: diferentes tipos de respuestas
    protected ResponseEntity<Object> responder(Object data) {
        return ResponseEntity.ok(data);
    }
    
    protected ResponseEntity<Object> responder(Object data, HttpStatus status) {
        return ResponseEntity.status(status).body(data);
    }
    
    protected ResponseEntity<Object> responder(Object data, String mensaje) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("mensaje", mensaje);
        return ResponseEntity.ok(response);
    }
}

// Controlador específico que sobrescribe y sobrecarga
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController extends BaseController {
    @Autowired
    private UsuarioService usuarioService;
    
    // Sobrescritura: personaliza la respuesta base
    @Override
    protected ResponseEntity<Object> responder(Object data) {
        return super.responder(data, "Usuario procesado exitosamente");
    }
    
    // Sobrecarga: nuevo método específico para usuarios
    protected ResponseEntity<Object> responder(Usuario usuario, List<String> roles) {
        Map<String, Object> response = new HashMap<>();
        response.put("usuario", usuario);
        response.put("roles", roles);
        return ResponseEntity.ok(response);
    }
}
```

#### Ventajas y Casos de Uso

1. **Sobrecarga**
   - **Flexibilidad en APIs**: Permite ofrecer diferentes formas de usar un método
   - **Reutilización de nombres**: Mejora la legibilidad al usar nombres descriptivos
   - **Compatibilidad**: Facilita la evolución de APIs sin romper código existente
   - **Validación**: Permite diferentes niveles de validación según el contexto

2. **Sobrescritura**
   - **Polimorfismo**: Permite que diferentes clases respondan de manera específica
   - **Extensibilidad**: Facilita la personalización de comportamientos
   - **Mantenibilidad**: Centraliza cambios comunes en la clase base
   - **Abstracción**: Permite definir comportamientos genéricos en clases abstractas

#### Mejores Prácticas

1. **Sobrecarga**
   - Mantener la consistencia en el comportamiento
   - Evitar ambigüedad en la selección de métodos
   - Documentar las diferencias entre versiones
   - Usar tipos de retorno compatibles

2. **Sobrescritura**
   - Usar la anotación `@Override`
   - Mantener el contrato de la superclase
   - Considerar llamar a `super` cuando sea apropiado
   - No reducir la visibilidad del método

**Referencias:**
- [Oracle Java Documentation: Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)
- [Spring Framework Documentation: Core Technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

---

### 8. Palabras clave "this" y "super": ¿Qué significan y para qué se utilizan las palabras clave this y super en Java? Proporciona ejemplos de situaciones en las que se usan.

Las palabras clave `this` y `super` son referencias especiales en Java que permiten acceder a miembros de la clase actual y de la clase padre respectivamente. Son fundamentales para la gestión de herencia y la clarificación de referencias en el código.

#### Usos de this y super

| Palabra Clave | Uso | Descripción | Ejemplo |
|---------------|-----|-------------|----------|
| **this** | Referencia a la instancia actual | Accede a miembros de la clase actual | `this.nombre = nombre;` |
| **this()** | Llamada a constructor de la misma clase | Invoca otro constructor de la clase actual | `this(nombre, edad);` |
| **super** | Referencia a la clase padre | Accede a miembros de la clase padre | `super.metodo();` |
| **super()** | Llamada al constructor de la clase padre | Invoca el constructor de la clase padre | `super(nombre);` |

#### Ejemplo Práctico: Sistema de Gestión de Empleados

```java
// Clase base
public class Persona {
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

// Clase derivada
public class main.com.gestion.prueba.Empleado extends Persona {
    private String cargo;
    private double salario;
    private List<String> habilidades;
    
    // Constructor que usa this() y super()
    public main.com.gestion.prueba.Empleado(String nombre, String dni, LocalDate fechaNacimiento, 
                   String cargo, double salario) {
        super(nombre, dni, fechaNacimiento); // Llama al constructor de Persona
        this.cargo = cargo;
        this.saldo = salario;
        this.habilidades = new ArrayList<>();
    }
    
    // Constructor sobrecargado que usa this()
    public main.com.gestion.prueba.Empleado(String nombre, String dni, LocalDate fechaNacimiento, 
                   String cargo, double salario, List<String> habilidades) {
        this(nombre, dni, fechaNacimiento, cargo, salario); // Llama al otro constructor
        this.habilidades = new ArrayList<>(habilidades);
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llama al método de la clase padre
        System.out.println("Cargo: " + cargo);
        System.out.println("Salario: " + salario);
        System.out.println("Habilidades: " + habilidades);
    }
    
    public void agregarHabilidad(String habilidad) {
        if (habilidad != null && !habilidad.trim().isEmpty()) {
            this.habilidades.add(habilidad);
        }
    }
}
```

#### Ejemplo Avanzado: Sistema de Pagos con Validación

```java
// Clase base abstracta
public abstract class Pago {
    protected double monto;
    protected String moneda;
    protected LocalDateTime fecha;
    
    public Pago(double monto, String moneda) {
        this.monto = monto;
        this.moneda = moneda;
        this.fecha = LocalDateTime.now();
    }
    
    protected boolean validarMonto(double monto) {
        return monto > 0;
    }
    
    public abstract boolean procesarPago();
}

// Clase concreta
public class PagoTarjeta extends Pago {
    private String numeroTarjeta;
    private String cvv;
    private String tipoTarjeta;
    
    // Constructor que usa super()
    public PagoTarjeta(double monto, String moneda, 
                      String numeroTarjeta, String cvv, String tipoTarjeta) {
        super(monto, moneda); // Llama al constructor de Pago
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.tipoTarjeta = tipoTarjeta;
    }
    
    @Override
    public boolean procesarPago() {
        if (!validarMonto(this.monto)) { // Usa this para clarificar
            return false;
        }
        return validarTarjeta() && procesarTransaccion();
    }
    
    private boolean validarTarjeta() {
        return this.numeroTarjeta != null && // Usa this para clarificar
               this.numeroTarjeta.matches("\\d{16}");
    }
    
    private boolean procesarTransaccion() {
        // Lógica de procesamiento
        return true;
    }
}
```

#### Aplicación en Spring Framework

```java
// Controlador base
@RestController
@RequestMapping("/api")
public class BaseController {
    protected final Logger logger;
    
    public BaseController() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }
    
    protected ResponseEntity<Object> responder(Object data) {
        return ResponseEntity.ok(data);
    }
    
    protected ResponseEntity<Object> responder(Object data, HttpStatus status) {
        return ResponseEntity.status(status).body(data);
    }
}

// Controlador específico
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController extends BaseController {
    private final UsuarioService usuarioService;
    
    public UsuarioController(UsuarioService usuarioService) {
        super(); // Llama al constructor de BaseController
        this.usuarioService = usuarioService;
    }
    
    @Override
    protected ResponseEntity<Object> responder(Object data) {
        this.logger.info("Procesando respuesta para usuario"); // Usa this para clarificar
        return super.responder(data); // Llama al método de la clase padre
    }
    
    @PostMapping
    public ResponseEntity<Object> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario creado = this.usuarioService.save(usuario); // Usa this para clarificar
            return this.responder(creado, HttpStatus.CREATED);
        } catch (Exception e) {
            this.logger.error("Error al crear usuario", e);
            return this.responder(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
```

#### Casos de Uso y Mejores Prácticas

1. **Uso de this**
   - **Referencia a atributos**: Cuando hay ambigüedad con parámetros
   - **Encadenamiento de constructores**: Para reutilizar código de inicialización
   - **Clarificación de código**: Para hacer explícito el acceso a miembros de la clase
   - **Retorno de la instancia actual**: En patrones como Builder

2. **Uso de super**
   - **Llamada a constructor padre**: Siempre en la primera línea del constructor
   - **Acceso a métodos heredados**: Cuando se sobrescribe un método
   - **Acceso a atributos heredados**: Cuando hay shadowing
   - **Implementación de interfaces**: Para acceder a métodos default

3. **Mejores Prácticas**
   - Usar `this` cuando hay ambigüedad
   - Llamar a `super()` en constructores de clases derivadas
   - Usar `super` para acceder a métodos heredados
   - Mantener la consistencia en el uso de referencias

**Referencias:**
- [Oracle Java Documentation: Using the this Keyword](https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html)
- [Spring Framework Documentation: Core Technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

---

### 9. Herencia Múltiple: Java no permite la herencia múltiple de clases. ¿Cómo se puede simular o gestionar este concepto utilizando otras herramientas del lenguaje?

Java no permite la herencia múltiple de clases para evitar la ambigüedad del "problema del diamante", pero proporciona mecanismos alternativos para lograr funcionalidad similar. Las principales alternativas son las interfaces y la composición.

#### Mecanismos para Simular Herencia Múltiple

| Mecanismo | Descripción | Ventajas | Desventajas |
|-----------|-------------|-----------|-------------|
| **Interfaces** | Una clase puede implementar múltiples interfaces | - Permite definir contratos claros<br>- Facilita el desacoplamiento<br>- Soporta herencia múltiple de comportamiento | - No puede contener estado<br>- No puede tener constructores |
| **Composición** | Una clase contiene instancias de otras clases | - Mayor flexibilidad<br>- Mejor encapsulamiento<br>- Evita problemas de herencia | - Requiere más código<br>- Mayor complejidad inicial |

#### Ejemplo Práctico: Sistema de Pagos con Múltiples Comportamientos

```java
// Interfaces para diferentes comportamientos
public interface Pagable {
    boolean procesarPago();
    String obtenerDetalles();
}

public interface Descuentable {
    double calcularDescuento();
    void aplicarDescuento();
}

public interface Fidelizable {
    int calcularPuntos();
    void acumularPuntos();
}

// Clase que implementa múltiples interfaces
public class PagoTarjeta implements Pagable, Descuentable, Fidelizable {
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
        return monto * 0.05; // 5% de descuento
    }
    
    @Override
    public void aplicarDescuento() {
        monto -= calcularDescuento();
    }
    
    @Override
    public int calcularPuntos() {
        return (int) (monto * 0.1); // 1 punto por cada 10 unidades
    }
    
    @Override
    public void acumularPuntos() {
        puntosAcumulados += calcularPuntos();
    }
    
    private boolean validarTarjeta() {
        return numeroTarjeta != null && 
               numeroTarjeta.matches("\\d{16}");
    }
    
    private boolean procesarTransaccion() {
        // Lógica de procesamiento
        return true;
    }
}
```

#### Ejemplo con Composición y Delegación

```java
// Clases base para diferentes comportamientos
public class ProcesadorPago {
    public boolean procesar(double monto) {
        return monto > 0;
    }
}

public class CalculadorDescuento {
    public double calcular(double monto) {
        return monto * 0.05;
    }
}

public class GestorPuntos {
    public int calcular(double monto) {
        return (int) (monto * 0.1);
    }
}

// Clase que usa composición
public class PagoComplejo {
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

#### Aplicación en Spring Framework

```java
// Interfaces para servicios
public interface PersistenceService<T> {
    T save(T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
}

public interface CacheableService<T> {
    T findByIdWithCache(Long id);
    void invalidateCache(Long id);
}

public interface ValidationService<T> {
    boolean validate(T entity);
    List<String> getValidationErrors();
}

// Implementación que usa múltiples interfaces
@Service
public class UsuarioService implements 
    PersistenceService<Usuario>, 
    CacheableService<Usuario>, 
    ValidationService<Usuario> {
    
    private final UsuarioRepository repository;
    private final Cache cache;
    
    public UsuarioService(UsuarioRepository repository, Cache cache) {
        this.repository = repository;
        this.cache = cache;
    }
    
    @Override
    public Usuario save(Usuario entity) {
        if (validate(entity)) {
            return repository.save(entity);
        }
        throw new ValidationException(validationErrors);
    }
    
    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }
    
    @Override
    public void delete(Usuario entity) {
        repository.delete(entity);
    }
    
    @Override
    public Usuario findByIdWithCache(Long id) {
        Cache.ValueWrapper wrapper = cache.get(id);
        if (wrapper != null) {
            return (Usuario) wrapper.get();
        }
        Usuario usuario = findById(id)
            .orElseThrow(() -> new UsuarioNotFoundException(id));
        cache.put(id, usuario);
        return usuario;
    }
    
    @Override
    public void invalidateCache(Long id) {
        cache.evict(id);
    }
    
    @Override
    public boolean validate(Usuario usuario) {
        validationErrors.clear();
        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            validationErrors.add("Email inválido");
        }
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            validationErrors.add("Nombre no puede ser vacío");
        }
        return validationErrors.isEmpty();
    }
    
    @Override
    public List<String> getValidationErrors() {
        return new ArrayList<>(validationErrors);
    }
}
```

#### Mejores Prácticas

1. **Uso de Interfaces**
   - Definir interfaces pequeñas y cohesivas
   - Usar métodos default para comportamiento común
   - Evitar interfaces con demasiados métodos
   - Documentar claramente el contrato

2. **Uso de Composición**
   - Preferir composición sobre herencia
   - Encapsular la complejidad
   - Mantener las clases pequeñas y enfocadas
   - Usar inyección de dependencias

3. **Consideraciones de Diseño**
   - Evaluar si realmente se necesita herencia múltiple
   - Considerar el impacto en la mantenibilidad
   - Diseñar para la extensibilidad
   - Mantener la simplicidad

**Referencias:**
- [Oracle Java Documentation: Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
- [Spring Framework Documentation: Core Technologies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

---

### 10. Patrones de Diseño: Explica brevemente qué son los patrones de diseño en la POO y menciona dos ejemplos (por ejemplo, Singleton, Factory, Observer, etc.) indicando su utilidad.

Los patrones de diseño son soluciones generales y reutilizables a problemas comunes en el diseño de software. 
Proporcionan una forma estructurada de resolver situaciones recurrentes en el desarrollo de software, mejorando la flexibilidad, reutilización y mantenibilidad del código. Se clasifican en tres categorías: creacionales, estructurales y de comportamiento.

**Ejemplos:**

#### Singleton:

- **Utilidad:** Garantiza que una clase tenga solo una instancia y proporcione un punto de acceso global a esa instancia. Es útil para gestionar recursos compartidos, como una conexión a la base de datos o un gestor de configuración, evitando la creación de múltiples instancias costosas.

- **Ejemplo:**
    ```java
    public class Singleton {
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

- **Utilidad:** Proporciona una interfaz para crear objetos en una familia de clases relacionadas sin especificar
  sus clases concretas. Es útil cuando se necesita crear objetos de diferentes tipos sin que el código que los
  utiliza conozca las clases concretas, facilitando la extensibilidad en sistemas modulares.

- **Ejemplo:**
    ```java
    public interface Forma {
        void dibujar();
    }
    
    public class Circulo implements Forma {
      @Override
      public void dibujar() {
          System.out.println("Dibujando un círculo");
      }
    }
          
    public class FactoryForma {
        public static Forma crearForma(String tipo) {
            if ("circulo".equals(tipo)) {
                return new Circulo();
            } // Otros tipos...  
            return  null;
        } 
    }
    ```                      

En aplicaciones web, estos patrones son fundamentales para diseñar sistemas escalables y mantenibles, como en la gestión de conexiones en Spring o la creación de beans, mejorando la arquitectura de sistemas distribuidos.

**Referencias:**

- [Refactoring Guru: Patrones de diseño](https://refactoring.guru/es/design-patterns)
- [Solo Entendidos: Patrones de Diseño de Programación Orientada a Objetos](https://www.soloentendidos.com/patrones-de-diseno-de-programacion-orientada-a-objetos-1771)