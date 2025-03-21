package  com.pruebas.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
    public void testGameStateManagement() {
        Juego juego = Juego.getInstance();
        
        // Test initial state
        assertFalse(juego.isRunning(), "El juego debería iniciar pausado");
        assertEquals(0, juego.getScore(), "La puntuación inicial debería ser 0");
        assertEquals("Nivel 1", juego.getCurrentLevel(), "El nivel inicial debería ser 'Nivel 1'");
        
        // Test game flow
        juego.iniciarJuego();
        assertTrue(juego.isRunning(), "El juego debería estar en ejecución");
        
        juego.updateScore(100);
        assertEquals(100, juego.getScore(), "La puntuación debería actualizarse correctamente");
        
        juego.changeLevel("Nivel 2");
        assertEquals("Nivel 2", juego.getCurrentLevel(), "El nivel debería actualizarse correctamente");
        
        juego.pausarJuego();
        assertFalse(juego.isRunning(), "El juego debería estar pausado");
        
        juego.finalizarJuego();
        assertFalse(juego.isRunning(), "El juego debería estar finalizado");
        assertEquals(0, juego.getScore(), "La puntuación debería reiniciarse");
        assertEquals("Nivel 1", juego.getCurrentLevel(), "El nivel debería reiniciarse");
    }
    
    @Test
    public void testMultipleThreads() throws InterruptedException {
        // Create an array to store instances from different threads
        Juego[] instances = new Juego[5];
        
        // Create multiple threads to get instances
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                instances[index] = Juego.getInstance();
            });
            threads[i].start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }
        
        // Verify all instances are the same
        Juego firstInstance = instances[0];
        for (Juego instance : instances) {
            assertSame(firstInstance, instance, "Todas las instancias deberían ser la misma");
        }
    }
    
    @Test
    public void testReflectionAttack() {
        try {
            Constructor<Juego> constructor = Juego.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
            fail("Debería lanzar una excepción al intentar crear una instancia mediante reflexión");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException, 
                "Debería lanzar IllegalStateException al intentar crear una instancia mediante reflexión");
        }
    }
    
    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        Juego original = Juego.getInstance();
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(original);
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Juego deserialized = (Juego) ois.readObject();
        
        // Verify singleton
        assertSame(original, deserialized, "La instancia deserializada debería ser la misma");
    }
    
    @Test
    public void testClonePrevention() {
        Juego juego = Juego.getInstance();
        assertThrows(CloneNotSupportedException.class, () -> {
            juego.clone();
        }, "Debería lanzar CloneNotSupportedException al intentar clonar");
    }
} 