package demo.books;

import java.util.ArrayList;
import java.util.List;

public class Books {
    public static class Libro {
        private String titulo;
        private boolean disponible;

        public Libro(String titulo, String autor) {
            this.titulo = titulo;
            this.disponible = true;
        }

        public String getTitulo() {
            return titulo;
        }

        public boolean isDisponible() {
            return disponible;
        }

        public void setDisponible(boolean disponible) {
            this.disponible = disponible;
        }
    }

    public static class NoDisponibleLibroException extends Exception {
        public NoDisponibleLibroException(String titulo) {
            super(prepareMessage(titulo));
        }

        private NoDisponibleLibroException(String message, boolean dummy) {
            super(message);
        }

        public NoDisponibleLibroException(String titulo, String autor) {
            this(prepareMessage(titulo, autor), true);
        }

        private static String prepareMessage(String titulo) {
            return "El libro '" + titulo + "' no está disponible para préstamo.";
        }

        private static String prepareMessage(String titulo, String autor) {
            return "El libro '" + titulo + "' del autor '" + autor + "' no está disponible para préstamo.";
        }

        public NoDisponibleLibroException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class NoExisteLibreException extends Exception {
        public NoExisteLibreException(String titulo) {
            super("El libro '" + titulo + "' no existe en la biblioteca.");
        }
    }

    public static class Biblioteca {
        private List<Libro> libros;

        public Biblioteca() {
            this.libros = new ArrayList<>();
        }

        public void agregarLibro(Libro libro) {
            libros.add(libro);
        }

        public Libro prestarLibro(String titulo)
                throws NoDisponibleLibroException,
                NoExisteLibreException {
            Libro libroEncontrado = null;

            // Buscar el libro por título
            libroEncontrado = buscarLibrePorTitulo(titulo);

            // Si no se encuentra el libro
            if (libroEncontrado == null) {
                throw new NoExisteLibreException(titulo);
            }

            // Si el libro no está disponible
            if (!libroEncontrado.isDisponible()) {
                throw new NoDisponibleLibroException(titulo);
            }

            // Marcar el libro como prestado
            libroEncontrado.setDisponible(false);
            return libroEncontrado;
        }

        private Libro buscarLibrePorTitulo(String titulo) {
            for (Libro libro : libros) {
                if (libro.getTitulo().equals(titulo)) {
                    return libro;
                }
            }
            return null;
        }
    }
} 