package  com.examen.customexc;

public class ProductoNoEncontradoException extends Exception {
    static final String MSG_TPL = "No se encontró el producto con ID: %1$s";
    public ProductoNoEncontradoException(int id) {
        super(String.format(MSG_TPL, id));
    }
} 