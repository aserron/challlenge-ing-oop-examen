package com.examen.customexc;

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
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
    }

    /**
     * @return Producto
     */
    public Producto buscarProductoPorId(int id) throws ProductoNoEncontradoException {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        throw new ProductoNoEncontradoException(id);
    }

    public void listarProductos() {
        getProductos().forEach(System.out::println);
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }
}
