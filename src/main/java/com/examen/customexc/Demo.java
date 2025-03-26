package com.examen.customexc;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    static class ProductoNoEncontradoException extends Exception {
        public ProductoNoEncontradoException(int id) {
            super("No se encontró el producto con ID: " + id);
        }
    }

    static class Producto {
        private int id;

        public Producto(int id, String nombre, double precio) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    static class Inventario {
        private List<Producto> productos;

        public Inventario() {
            this.productos = new ArrayList<>();
        }

        public void agregarProducto(Producto producto) {
            productos.add(producto);
        }

        public Producto buscarProductoPorId(int id) throws ProductoNoEncontradoException {
            for (Producto producto : productos) {
                if (producto.getId() == id) {
                    return producto;
                }
            }
            throw new ProductoNoEncontradoException(id);
        }
    }

    public static void main(String[] args) {

        Inventario inventario = new Inventario();

        // Agregar algunos productos
        inventario.agregarProducto(
                new Producto(1, "Laptop", 999.99));
        inventario.agregarProducto(
                new Producto(2, "Smartphone", 499.99));
        inventario.agregarProducto(
                new Producto(3, "Auriculares", 79.99));

        try {
            // Demostrar búsqueda exitosa
            System.out.println("Buscando producto con ID 2...");
            System.out.println(inventario.buscarProductoPorId(2));
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Fallo con producto ID 4...");
        try {
            Producto producto = inventario
                    .buscarProductoPorId(4);
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
