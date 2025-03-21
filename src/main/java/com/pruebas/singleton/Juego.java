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
    private ArrayList<String> updateStatusMsgs = new ArrayList<>();
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

    /**
     * @implNote REQUERIDO #2: El juego debe estar en estado ESPERANDO para poder ser iniciado
     */
    public static void main(String[] args) {
        // Obtener primera instancia
        Juego juego1 = Juego.getInstance();
        System.out.println("Primera instancia creada: " + juego1);
        
        // Obtener segunda instancia
        Juego juego2 = Juego.getInstance();
        System.out.println("Segunda instancia creada: " + juego2);
        
        // Demostrar que son la misma instancia
        System.out.println("¿Son la misma instancia? " + (juego1 == juego2));
    }

    /**
     * @implNote REQUERIDO: 1) El juego debe estar en estado ESPERANDO para poder ser iniciado
     */
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

    private void updateStatus(ESTADOS nuevoEstado) {
        estado = nuevoEstado;
        updateStatusMsgs.add("El juego ha comenzado!");
    }

    public void info() {
        System.out.println("Estado actual del juego: " + estado);
        System.out.println("Información sobre el ciclo de vida del juego:");
        // imporimir uno por lina
        for (String msg : updateStatusMsgs) {
            System.out.println(msg);
        }        
    }

    public String getEstado() {
        return estado.toString();
    }

    public ArrayList<String> getUpdateStatusMsgs() {
        return updateStatusMsgs;
    }

    // cleanup fn
    public void limpiarEstado() {
        updateStatusMsgs.clear();
    }
}