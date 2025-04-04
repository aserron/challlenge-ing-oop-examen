package  com.examen.customexc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventarioTest {
    private Inventario inventario;
    private Producto laptop;
    private Producto smartphone;

    @BeforeEach
    void setUp() {
        inventario = new Inventario();
        laptop = new Producto(1, "Laptop", 999.99);
        smartphone = new Producto(2, "Smartphone", 499.99);
        inventario.agregarProducto(laptop);
        inventario.agregarProducto(smartphone);
    }

    @Test
    void testAgregarProducto() {
        Producto auriculares = new Producto(3, "Auriculares", 79.99);
        inventario.agregarProducto(auriculares);
        
        assertDoesNotThrow(() -> {
            Producto encontrado = inventario.buscarProductoStreamPorId(3);
            assertEquals(auriculares, encontrado);
        });
    }

    @Test
    void testBuscarProductoExistente() {
        assertDoesNotThrow(() -> {
            Producto encontrado = inventario.buscarProductoStreamPorId(1);
            assertEquals(laptop, encontrado);
        });
    }

    @Test
    void testBuscarProductoNoExistente() {
        ProductoNoEncontradoException exception = assertThrows(
            ProductoNoEncontradoException.class,
            () -> inventario.buscarProductoStreamPorId(999)
        );
        
        assertTrue(exception.getMessage().contains("No se encontró el producto con ID: 999"));
    }

    @Test
    void testGetProductos() {
        List<Producto> productos = inventario.getProductos();
        assertEquals(2, productos.size());
        assertTrue(productos.contains(laptop));
        assertTrue(productos.contains(smartphone));
    }

    @Test
    void testProductoNoEncontradoException() {
        ProductoNoEncontradoException exception = new ProductoNoEncontradoException(0);
        assertEquals("No se encontró el producto con ID: 0", exception.getMessage());
    }

    @Test
    void testBuscarProductoConIdInvalido() {
        // This test expects to fail by throwing ProductoNoEncontradoException
        ProductoNoEncontradoException exception = assertThrows(
            ProductoNoEncontradoException.class,
            () -> inventario.buscarProductoStreamPorId(-1)
        );
        
        // Verify the exception message
        assertEquals("No se encontró el producto con ID: -1", exception.getMessage());
    }
} 