# Ejemplos de Spring Framework

## 1. Ejemplo de Encapsulación en Spring

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

## 2. Ejemplo de Herencia y Polimorfismo en Spring

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

## 3. Ejemplo de Abstracción en Spring

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

## 4. Ejemplo de Constructores en Spring

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

## 5. Ejemplo de Controladores en Spring

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