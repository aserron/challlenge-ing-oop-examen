package com.examen.bookstore;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro prestarLibro(String titulo) throws NoDisponibleLibroException, NoExisteLibreException {

        Libro libroEncontrado;

        // Buscar el libro por título
        libroEncontrado = buscarLibrePorTitulo(titulo);

        // Si no se encuentra el libro
        if (libroEncontrado == null) {
            throw new NoExisteLibreException("El libro '" + titulo + "' no existe en la biblioteca.");
        }

        // Si el libro no está disponible
        if (!libroEncontrado.isDisponible()) {
            throw new NoDisponibleLibroException("El libro '" + titulo + "' no está disponible para préstamo.");
        }

        // Marcar el libro como prestado
        libroEncontrado.setDisponible(false);
        return libroEncontrado;
    }

    public void devolverLibro(String titulo) throws NoExisteLibreException {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.setDisponible(true);
                return;
            }
        }
        throw new NoExisteLibreException("El libro '" + titulo + "' no existe en la biblioteca.");
    }

    public List<Libro> getLibros() {
        return new ArrayList<>(libros);
    }


    private Libro buscarLibrePorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

}