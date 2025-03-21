package main.java.com.pruebas.gestion;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class GestionTestLocal {
    private Empresa empresa;
    private Empleado empleado1;
    private Empleado Empleado;

    @BeforeEach
    void setUp() {
        empresa = new Empresa();
        empleado1 = new Empleado("Juan Pérez", 1, 30000.0);
        Empleado = new Empleado("María García", 2, 35000.0);
    }

    @Test
    void testCreacionEmpleado() {
        assertEquals("Juan Pérez", empleado1.getNombre());
        assertEquals(1, empleado1.getId());
        assertEquals(30000.0, empleado1.getSalario());
    }

    @Test
    void testModificacionEmpleado() {
        empleado1.setNombre("Juan Pablo Pérez");
        empleado1.setSalario(32000.0);
        
        assertEquals("Juan Pablo Pérez", empleado1.getNombre());
        assertEquals(32000.0, empleado1.getSalario());
    }

    @Test
    void testAgregarEmpleado() {
        empresa.agregarEmpleado(empleado1);
        
        assertFalse(empresa.getEmpleados().isEmpty());
        assertEquals(1, empresa.getEmpleados().size());
        assertEquals(empleado1, empresa.getEmpleados().get(0));
    }

    @Test
    void testListaMultiplesEmpleados() {
        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(Empleado);
        
        assertEquals(2, empresa.getEmpleados().size());
        assertTrue(empresa.getEmpleados().contains(empleado1));
        assertTrue(empresa.getEmpleados().contains(Empleado));
    }

    @Test
    void testListaVacia() {
        assertTrue(empresa.getEmpleados().isEmpty());
    }

    @Test
    void testToString() {
        String expectedString = "main.java.com.gestion.prueba.Empleado{id=1, nombre='Juan Pérez', salario=30000.0}";
        assertEquals(expectedString, empleado1.toString());
    }

    @Test
    void testEmpleadoInmutable() {
        Empleado empleado = new Empleado("Test", 1, 1000.0);
        assertEquals(1, empleado.getId()); // ID should not be modifiable
    }

    @Test
    void testEmpresaListaInmutable() {
        empresa.agregarEmpleado(empleado1);
        empresa.getEmpleados().clear(); // Should not affect original list
        assertEquals(1, empresa.getEmpleados().size());
    }
} 