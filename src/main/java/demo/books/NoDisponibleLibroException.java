package demo.books;

class NoDisponibleLibroException extends Exception {
    public NoDisponibleLibroException(String titulo) {
        super("El libro '" + titulo + "' no está disponible para préstamo.");
    }
}
