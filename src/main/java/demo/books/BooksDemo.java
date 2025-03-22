package demo.books;

public class BooksDemo {
    public static void main(String[] args) 
    throws 
            Books.NoExisteLibreException,
            Books.NoDisponibleLibroException 
    {
        Books.Biblioteca biblioteca = new Books.Biblioteca();
        Books.Libro libro1 = new Books.Libro("Don Quijote", "Miguel de Cervantes");
        Books.Libro libro2 = new Books.Libro("La Celestina", "Fernando de Rojas");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        try {
            Books.Libro libroPrestado = biblioteca.prestarLibro("Don Quijote");
            System.out.println("Libro prestado: " + libroPrestado.getTitulo());

            // Intentar prestar un libro que no existe
            Books.Libro libroNoExiste2 = biblioteca.prestarLibro("No Existe");
            
            // nunca se va a ejecutar
            System.out.println("Libro prestado: " + libroNoExiste2.getTitulo());

        } catch (Books.NoExisteLibreException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Books.NoDisponibleLibroException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Puedo ver el mensaje porque la excepcion fue contenida");
    }
}
