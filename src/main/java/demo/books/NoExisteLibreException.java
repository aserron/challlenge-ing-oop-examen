package demo.books;

class NoExisteLibreException extends Exception {
    public NoExisteLibreException(String titulo) {
        super("El libro '" + titulo + "' no existe en la biblioteca.");
    }
}
