package  com.examen.singleton;

public class JuegoMain {
    public static void main(String[] args) {
        // Get the game instance
        Juego juego1 = Juego.getInstance();
        Juego juego2 = Juego.getInstance();
        
        // Demonstrate that both references point to the same instance
        System.out.println("¿Son la misma instancia? " + (juego1 == juego2));
        
        // Use the game instance
        juego1.iniciarJuego();
        juego1.pausarJuego();
        juego1.reanudarJuego();
        juego1.finalizarJuego();
    }
} 