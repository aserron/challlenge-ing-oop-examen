package  com.pruebas.customexc;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProductoStreamPorId(int id) throws ProductoNoEncontradoException {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductoNoEncontradoException(
                    "No se encontró el producto con ID: " + id));
    }

    public Producto buscarProductoPorId(int id) throws ProductoNoEncontradoException {
        try {
            for (Producto producto : productos) {
                if (producto.getId() == id) {
                    return producto;
                }
            }
            throw new ProductoNoEncontradoException("No se encontró el producto con ID: " + id);
        } catch (ProductoNoEncontradoException e) {
            System.err.println("Error al buscar producto: " + e.getMessage());
            throw e;
        }
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }
} 