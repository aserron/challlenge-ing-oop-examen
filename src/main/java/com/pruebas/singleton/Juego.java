package com.pruebas.singleton;

import java.util.ArrayList;

enum ESTADOS {
    ESPERANDO,
    INICIADO,
    CORRIENDO,
    PAUSADO,
    REANUDADO,
    FINALIZADO,
    FALLADO
}

public class Juego {
    private ESTADOS estado;
    /**
     * Información sobre el ciclo de vida del juego
     */
    private ArrayList<String> updateStatusMsgs = [];
    private static Juego instance;

    // Private constructor to prevent instantiation
    private Juego() {
        this.estado = ESTADOS.ESPERANDO;
        this.updateStatusMsgs.add("Juego esperando a que el usuario inicie el juego");
    }

    // Public static method to get the instance
    public static Juego getInstance() {
        if (instance == null) {
            instance = new Juego();
        }
        return instance;
    }

    // Method to start the game
    public void iniciarJuego() {
        updateStatus(ESTADOS.INICIADO);
        System.out.println("El juego ha comenzado!");
    }

    public void pausarJuego() {
        updateStatus(ESTADOS.PAUSADO);
        System.out.println("El juego ha sido pausado!");
    }

    public void reanudarJuego() {
        updateStatus(ESTADOS.CORRIENDO);
        System.out.println("El juego ha sido reanudado!");
    }

    public void finalizarJuego() {
        updateStatus(ESTADOS.FINALIZADO);
        System.out.println("El juego ha sido finalizado!");
    }

    private void cuandoFallaJuego(Object reason) {
        updateStatus(ESTADOS.FALLADO);
        System.out.println("El juego ha fallado!");
    }

    private void updateStatus(ESTADOS nuevoEstado) {
        estado = nuevoEstado;
        updateStatusMsgs.add("El juego ha comenzado!");
    }

    // cleanup fn
    public void limpiarEstado() {
        updateStatusMsgs.clear();
    }
}