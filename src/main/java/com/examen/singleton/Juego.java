package com.examen.singleton;

import java.util.ArrayList;

public class Juego {

    // Public static method to get the instance
    public static Juego getInstance() {
        if (instance == null) {
            instance = new Juego();
        }
        return instance;
    }

    private EstadosJuegos estado;

    /**
     * bitácora de actividad, ciclo de vida, eventos notables
     */
    private final ArrayList<String> updateStatusMsgs = new ArrayList<>();
    private static Juego instance;

    // Private constructor to prevent instantiation
    private Juego() {
        this.estado = EstadosJuegos.ESPERANDO;
        this.updateStatusMsgs.add("Juego esperando a que el usuario inicie el juego");
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
        updateStatus(EstadosJuegos.INICIADO);
        System.out.println("El juego ha comenzado!");
    }

    public void pausarJuego() {
        updateStatus(EstadosJuegos.PAUSADO);
        System.out.println("El juego ha sido pausado!");
    }

    public void reanudarJuego() {
        updateStatus(EstadosJuegos.CORRIENDO);
        System.out.println("El juego ha sido reanudado!");
    }

    public void finalizarJuego() {
        updateStatus(EstadosJuegos.FINALIZADO);
        System.out.println("El juego ha sido finalizado!");
    }

    private void updateStatus(EstadosJuegos nuevoEstado) {
        estado = nuevoEstado;
        updateStatusMsgs.add("El juego ha comenzado!");
    }

    public void info() {
        System.out.println("Estado actual del juego: " + estado);
        System.out.println("Información sobre el ciclo de vida del juego:");


        // imprimir uno por lina
        System.out.println("actividad: ...");
        for (String msg : updateStatusMsgs) {
            System.out.println("> " +msg);
        }        
    }

    public EstadosJuegos getEstado() {
        return estado;
    }

    public ArrayList<String> getUpdateStatusMsgs() {
        return updateStatusMsgs;
    }

    // cleanup fn
    public void limpiarEstado() {
        updateStatusMsgs.clear();
    }
}