package com.examen.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {
    
    @Test
    public void testSingletonInstance() {
        // Get two instances
        Juego juego1 = Juego.getInstance();
        Juego juego2 = Juego.getInstance();
        
        // Verify they are the same instance
        assertSame(juego1, juego2, "Las instancias deberían ser la misma");
    }
    
    @Test
    public void testGameStateFlow() {
        Juego juego = Juego.getInstance();


        // Test initial state
        assertEquals(EstadosJuegos.ESPERANDO, juego.getEstado(), "El estado inicial debería ser ESPERANDO: " + juego.getEstado());
        
        // Test game flow
        juego.iniciarJuego();
        assertEquals(EstadosJuegos.INICIADO, juego.getEstado(), "El estado debería ser INICIADO");
        
        juego.pausarJuego();
        assertEquals(EstadosJuegos.PAUSADO, juego.getEstado(), "El estado debería ser PAUSADO");
        
        juego.reanudarJuego();
        assertEquals(EstadosJuegos.CORRIENDO, juego.getEstado(), "El estado debería ser CORRIENDO");
        
        juego.finalizarJuego();
        assertEquals(EstadosJuegos.FINALIZADO, juego.getEstado(), "El estado debería ser FINALIZADO");
        
        // Clean up for next test
        juego.limpiarEstado();
    }
    
    @Test
    public void testStatusMessages() {
        Juego juego = Juego.getInstance();
        
        // Test initial message
        assertTrue(juego.getUpdateStatusMsgs().contains("Juego esperando a que el usuario inicie el juego"), 
            "Debería contener el mensaje inicial");
        
        // Test message after starting
        juego.iniciarJuego();
        assertTrue(juego.getUpdateStatusMsgs().contains("El juego ha comenzado!"), 
            "Debería contener el mensaje de inicio");
        
        // Clean up
        juego.limpiarEstado();
    }
} 