package  com.pruebas.singleton;

import java.io.Serializable;

public class Juego implements Serializable {
    private static volatile Juego instance;
    private static final long serialVersionUID = 1L;
    
    // Game state
    private boolean isRunning;
    private int score;
    private String currentLevel;
    
    // Private constructor to prevent instantiation
    private Juego() {
        // Prevent reflection attack
        if (instance != null) {
            throw new IllegalStateException("Ya existe una instancia del juego");
        }
        
        // Initialize game state
        this.isRunning = false;
        this.score = 0;
        this.currentLevel = "Nivel 1";
    }
    
    // Public static method to get the instance
    public static Juego getInstance() {
        if (instance == null) {
            synchronized (Juego.class) {
                if (instance == null) {
                    instance = new Juego();
                }
            }
        }
        return instance;
    }
    
    // Prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("No se puede clonar el juego");
    }
    
    // Handle serialization
    protected Object readResolve() {
        return getInstance();
    }
    
    // Game methods with state management
    public void iniciarJuego() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("Juego iniciado!");
        } else {
            System.out.println("El juego ya está en ejecución");
        }
    }
    
    public void pausarJuego() {
        if (isRunning) {
            isRunning = false;
            System.out.println("Juego pausado!");
        } else {
            System.out.println("El juego ya está pausado");
        }
    }
    
    public void reanudarJuego() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("Juego reanudado!");
        } else {
            System.out.println("El juego ya está en ejecución");
        }
    }
    
    public void finalizarJuego() {
        isRunning = false;
        score = 0;
        currentLevel = "Nivel 1";
        System.out.println("Juego finalizado!");
    }
    
    // Getters for game state
    public boolean isRunning() {
        return isRunning;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getCurrentLevel() {
        return currentLevel;
    }
    
    // Method to update score
    public void updateScore(int points) {
        this.score += points;
        System.out.println("Puntuación actualizada: " + this.score);
    }
    
    // Method to change level
    public void changeLevel(String newLevel) {
        this.currentLevel = newLevel;
        System.out.println("Nivel cambiado a: " + newLevel);
    }
} 