package com.examen.singleton;

import java.util.ArrayList;

public final class Juego {

    // singleton pattern implementation
    public static Juego getInstance() {
        if (instance == null) {
            instance = new Juego();
        }
        return instance;
    }

    /**
     * Asegura que la instancia se cree si la clase se invoca directamente.
     */
    public static void main(String[] args) {
        // Obtener primera instancia
        Juego juego1 = Juego.getInstance();
        
        // Obtener segunda instancia
        Juego juego2 = Juego.getInstance();

        boolean isSame = juego1 == juego2;
        assert isSame : "Las instancias deben ser iguales";
        
        // Demostrar que son la misma instancia
        System.out.println("¿Son la misma instancia? Juego1 == juego2 ="+ isSame);
    }
    

    private EstadosJuegos estado;

    /**
     * bitácora de actividad, ciclo de vida, eventos notables
     */
    private final ArrayList<String> activityMessages = new ArrayList<>();
    private static Juego instance;

    // Private constructor to prevent instantiation
    private Juego() {
        this.estado = EstadosJuegos.READY;
        this.activityMessages.add("Juego esperando el inicio del juego.");
    }
    

    /**
     * @implNote REQUERIDO: 1) El juego debe estar en estado ESPERANDO para poder ser iniciado
     */
    public void iniciarJuego() {        
        
        if (estado != EstadosJuegos.READY) {
            throw new IllegalStateException("El juego no puede ser iniciado en este estado");
        }
        setEstado(EstadosJuegos.INICIADO);
        System.out.println("¡El juego ha comenzado!");
    }
    public void pausarJuego() {
        setEstado(EstadosJuegos.PAUSADO);
        System.out.println("¡El juego ha sido pausado!");
    }
    public void reanudarJuego() {
        setEstado(EstadosJuegos.CORRIENDO);
        System.out.println("¡El juego ha sido reanudado!");
    }
    public void finalizarJuego() {
        setEstado(EstadosJuegos.FINALIZADO);
        System.out.println("El juego ha sido finalizado!");
    }

    public EstadosJuegos getEstado() {
        return estado;
    }
    private void setEstado(EstadosJuegos nuevoEstado) {
        estado = nuevoEstado;
        activityMessages.add("¡El juego ha comenzado!");
    }

    public void info() {
        System.out.println("Estado actual del juego: " + estado);        
        System.out.println("actividad: ...");
        for (String msg : activityMessages) {
            System.out.println("> " +msg);
        }        
    }

    public ArrayList<String> getActivity() {
        return activityMessages;
    }

    public void limpiarEstado() {
        this.activityMessages.clear();
        this.setEstado(EstadosJuegos.READY);
    }
}