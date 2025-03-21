package test.java.com.pruebas.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import main.java.com.pruebas.exceptions.Inventario;
import main.java.com.pruebas.exceptions.Producto;
import main.java.com.pruebas.exceptions.ProductoNoEncontradoException;

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
            Producto encontrado = inventario.buscarProductoPorId(3);
            assertEquals(auriculares, encontrado);
        });
    }

    @Test
    void testBuscarProductoExistente() {
        assertDoesNotThrow(() -> {
            Producto encontrado = inventario.buscarProductoPorId(1);
            assertEquals(laptop, encontrado);
        });
    }

    @Test
    void testBuscarProductoNoExistente() {
        ProductoNoEncontradoException exception = assertThrows(
            ProductoNoEncontradoException.class,
            () -> inventario.buscarProductoPorId(999)
        );
        
        assertTrue(exception.getMessage().contains("No se encontró el producto con ID: 999"));
    }

    @Test
    void testListarProductos() {
        var productos = inventario.listarProductos();
        assertEquals(2, productos.size());
        assertTrue(productos.contains(laptop));
        assertTrue(productos.contains(smartphone));
    }

    @Test
    void testProductoNoEncontradoException() {
        ProductoNoEncontradoException exception = new ProductoNoEncontradoException("Test message");
        assertEquals("Test message", exception.getMessage());
    }
} 