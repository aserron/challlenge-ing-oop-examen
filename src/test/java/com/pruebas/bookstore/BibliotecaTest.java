package com.pruebas.bookstore;

import com.pruebas.bookstore.Biblioteca;
import com.pruebas.bookstore.Libro;
import com.pruebas.bookstore.NoDisponibleLibroException;
import com.pruebas.bookstore.NoExisteLibreException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private Libro libro1;
    private Libro libro2;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        libro1 = new Libro("Don Quijote", "Miguel de Cervantes");
        libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
    }

    @Test
    void testAgregarLibro() {
        Libro nuevoLibro = new Libro("El Principito", "Antoine de Saint-Exupéry");
        biblioteca.agregarLibro(nuevoLibro);
        List<Libro> libros = biblioteca.getLibros();
        assertEquals(3, libros.size());
        assertTrue(libros.contains(nuevoLibro));
    }

    @Test
    void testPrestarLibroExitoso() throws NoDisponibleLibroException, NoExisteLibreException {
        Libro libroPrestado = biblioteca.prestarLibro("Don Quijote");
        assertNotNull(libroPrestado);
        assertEquals("Don Quijote", libroPrestado.getTitulo());
        assertFalse(libroPrestado.isDisponible());
    }

    @Test
    void testPrestarLibroNoExistente() {
        NoExisteLibreException exception = assertThrows(NoExisteLibreException.class, () -> {
            biblioteca.prestarLibro("Libro que no existe");
        });
        assertEquals("El libro 'Libro que no existe' no existe en la biblioteca.", exception.getMessage());
    }

    @Test
    void testPrestarLibroNoDisponible() throws NoDisponibleLibroException, NoExisteLibreException {
        // Primero prestamos el libro
        biblioteca.prestarLibro("Don Quijote");
        
        // Intentamos prestarlo de nuevo
        NoDisponibleLibroException exception = assertThrows(NoDisponibleLibroException.class, () -> {
            biblioteca.prestarLibro("Don Quijote");
        });
        assertEquals("El libro 'Don Quijote' no está disponible para préstamo.", exception.getMessage());
    }

    @Test
    void testDevolverLibroExitoso() throws NoExisteLibreException {
        // Primero prestamos el libro
        try {
            biblioteca.prestarLibro("Don Quijote");
        } catch (NoDisponibleLibroException e) {
            fail("No debería lanzar NoDisponibleLibroException");
        }

        // Devolvemos el libro
        biblioteca.devolverLibro("Don Quijote");
        
        // Verificamos que el libro está disponible
        List<Libro> libros = biblioteca.getLibros();
        for (Libro libro : libros) {
            if (libro.getTitulo().equals("Don Quijote")) {
                assertTrue(libro.isDisponible());
                return;
            }
        }
        fail("No se encontró el libro Don Quijote");
    }

    @Test
    void testDevolverLibroNoExistente() {
        NoExisteLibreException exception = assertThrows(NoExisteLibreException.class, () -> {
            biblioteca.devolverLibro("Libro que no existe");
        });
        assertEquals("El libro 'Libro que no existe' no existe en la biblioteca.", exception.getMessage());
    }

    @Test
    void testGetLibros() {
        List<Libro> libros = biblioteca.getLibros();
        assertEquals(2, libros.size());
        assertTrue(libros.contains(libro1));
        assertTrue(libros.contains(libro2));
        
        // Verificar que es una copia defensiva
        libros.add(new Libro("Nuevo Libro", "Autor"));
        assertEquals(2, biblioteca.getLibros().size());
    }
} 