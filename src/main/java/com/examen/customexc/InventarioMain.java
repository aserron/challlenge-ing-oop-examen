package  com.examen.customexc;

public final class InventarioMain {
    public static void main(String[] args) {
        // Crear un inventario
        Inventario inventario = new Inventario();

        // Agregar algunos productos
        inventario.agregarProducto(new Producto(1, "Laptop", 999.99));
        inventario.agregarProducto(new Producto(2, "Smartphone", 499.99));
        inventario.agregarProducto(new Producto(3, "Auriculares", 79.99));

        // Demostrar búsqueda exitosa
        try {
            Producto producto = inventario.buscarProductoStreamPorId(2);
            System.out.println("Producto encontrado: " + producto);
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Demostrar manejo de excepción
        try {
            Producto producto = inventario.buscarProductoStreamPorId(999);
            System.out.println("Producto encontrado: " + producto);
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Listar todos los productos
        System.out.println("\nLista de todos los productos:");
        inventario.listarProductos();
    }
} 