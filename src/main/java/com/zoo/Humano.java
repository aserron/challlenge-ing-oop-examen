package com.zoo;
// Ejemplo de Encapsulamiento en Java
public class Humano {
    // 1. Ocultamiento de datos - Atributos privados
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;
    
    // 2. Modificadores de acceso - Atributos protegidos
    protected String nacionalidad;
    protected String grupoSanguineo;
    
    // 3. Modificadores de acceso - Atributos públicos
    public String genero;
    public boolean esDonante;
    
    // Constructor
    public Humano(String nombre, int edad, String dni, double peso, double altura, 
                 String nacionalidad, String grupoSanguineo, String genero) {
        if (!validarDni(dni)) {
            throw new IllegalArgumentException("DNI inválido");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
        this.nacionalidad = nacionalidad;
        this.grupoSanguineo = grupoSanguineo;
        this.genero = genero;
        this.esDonante = false;
    }
    
    // 4. Getters y Setters - Métodos públicos para acceder a datos privados
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        if (edad >= 0 && edad <= 150) { // Validación de datos
            this.edad = edad;
        }
    }
    
    public String getDni() {
        return dni;
    }
    
    // No hay setter para DNI ya que no debería cambiar
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        if (peso > 0 && peso < 500) { // Validación de datos
            this.peso = peso;
        }
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(double altura) {
        if (altura > 0 && altura < 3) { // Validación de datos
            this.altura = altura;
        }
    }
    
    // 5. Métodos públicos que encapsulan lógica interna
    public double calcularIMC() {
        return peso / (altura * altura);
    }
    
    public String obtenerCategoriaIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) return "Bajo peso";
        if (imc < 25) return "Peso normal";
        if (imc < 30) return "Sobrepeso";
        return "Obesidad";
    }
    
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }
    
    // 6. Métodos protegidos que pueden ser usados por subclases
    protected void actualizarNacionalidad(String nuevaNacionalidad) {
        if (nuevaNacionalidad != null && !nuevaNacionalidad.trim().isEmpty()) {
            this.nacionalidad = nuevaNacionalidad;
        }
    }
    
    protected void actualizarGrupoSanguineo(String nuevoGrupo) {
        if (validarGrupoSanguineo(nuevoGrupo)) {
            this.grupoSanguineo = nuevoGrupo;
        }
    }
    
    // 7. Métodos privados para validación interna
    private boolean validarGrupoSanguineo(String grupo) {
        String[] gruposValidos = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        for (String valido : gruposValidos) {
            if (valido.equals(grupo)) return true;
        }
        return false;
    }
    
    private boolean validarDni(String dni) {
        return dni != null && dni.length() == 8 && dni.matches("\\d+");
    }
    
    // 8. Método toString para representación del objeto
    @Override
    public String toString() {
        return "Humano{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", genero='" + genero + '\'' +
                ", esDonante=" + esDonante +
                ", IMC=" + calcularIMC() +
                ", Categoría IMC='" + obtenerCategoriaIMC() + '\'' +
                '}';
    }
}

// Clase para demostrar el uso y errores de encapsulamiento
class Main {
    public static void main(String[] args) {
        Humano persona = new Humano("María", 30, "12345678", 65.5, 1.65, 
                                  "Española", "A+", "Femenino");
        
        // Ejecutar cada ejemplo
        demostrarAccesoPublico(persona);
        demostrarAccesoPrivado(persona);
        demostrarAccesoProtegido(persona);
        demostrarMetodosPublicos(persona);
        demostrarErroresValidacion(persona);
        
        // Crear instancia de PersonaExtranjera para demostrar restricciones
        PersonaExtranjera extranjera = new PersonaExtranjera();
        extranjera.intentarAcceso(persona);
    }
    
    private static void demostrarAccesoPublico(Humano persona) {
        System.out.println("\n=== Demostrando Acceso Público ===");
        System.out.println("Género: " + persona.genero);  // ✓ Acceso público permitido
        persona.esDonante = true;  // ✓ Acceso público permitido
        System.out.println("¿Es donante? " + persona.esDonante);
    }
    
    private static void demostrarAccesoPrivado(Humano persona) {
        System.out.println("\n=== Demostrando Acceso Privado ===");
        // Acceso correcto a través de getters/setters
        System.out.println("Nombre: " + persona.getNombre());  // ✓ Acceso correcto
        persona.setNombre("María José");  // ✓ Acceso correcto
        System.out.println("Nuevo nombre: " + persona.getNombre());
        
        // Intentos de acceso directo (comentados porque causarían error de compilación)
        System.out.println("Intentos de acceso directo a miembros privados (comentados):");
        System.out.println("// persona.nombre = \"Juan\";  // ✗ Error: nombre has private access");
        System.out.println("// persona.edad = 25;        // ✗ Error: edad has private access");
        System.out.println("// persona.dni = \"87654321\"; // ✗ Error: dni has private access");
    }
    
    private static void demostrarAccesoProtegido(Humano persona) {
        System.out.println("\n=== Demostrando Acceso Protegido ===");
        System.out.println("Nacionalidad: " + persona.nacionalidad);  // ✓ Acceso protegido permitido en el mismo paquete
        System.out.println("Grupo Sanguíneo: " + persona.grupoSanguineo);
    }
    
    private static void demostrarMetodosPublicos(Humano persona) {
        System.out.println("\n=== Demostrando Métodos Públicos ===");
        System.out.println("IMC: " + persona.calcularIMC());
        System.out.println("Categoría IMC: " + persona.obtenerCategoriaIMC());
        System.out.println("¿Es mayor de edad? " + persona.esMayorDeEdad());
        System.out.println("\nInformación completa:");
        System.out.println(persona.toString());
    }
    
    private static void demostrarErroresValidacion(Humano persona) {
        System.out.println("\n=== Demostrando Errores de Validación ===");
        try {
            System.out.println("Intentando crear persona con DNI inválido...");
            new Humano("Juan", 25, "123", 70.0, 1.75, 
                                              "Española", "A+", "Masculino");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear persona: " + e.getMessage());
        }
        
        try {
            System.out.println("\nIntentando establecer edad inválida...");
            persona.setEdad(-5);
            System.out.println("La edad no se modificó debido a la validación");
        } catch (Exception e) {
            System.out.println("Error al establecer edad: " + e.getMessage());
        }
    }
}

// Clase en otro paquete para demostrar restricciones de acceso
class PersonaExtranjera {
    public void intentarAcceso(Humano humano) {
        System.out.println("\n=== Demostrando Acceso desde PersonaExtranjera ===");
        
        // 1. Acceso a miembros públicos (permitido)
        try {
            System.out.println("Acceso a miembros públicos:");
            humano.genero = "Femenino";
            humano.esDonante = true;
            System.out.println("Género modificado: " + humano.genero);
            System.out.println("Estado donante: " + humano.esDonante);
        } catch (Exception e) {
            System.out.println("Error en acceso público: " + e.getMessage());
        }
        
        // 2. Acceso a miembros protegidos (no permitido desde otro paquete)
        try {
            System.out.println("\nIntentando acceso a miembros protegidos:");
            // humano.nacionalidad = "Francesa";  // ✗ Error: nacionalidad has protected access
            // humano.grupoSanguineo = "O+";      // ✗ Error: grupoSanguineo has protected access
            System.out.println("Estos accesos están comentados porque causarían error de compilación");
        } catch (Exception e) {
            System.out.println("Error en acceso protegido: " + e.getMessage());
        }
        
        // 3. Acceso a miembros privados (no permitido)
        try {
            System.out.println("\nIntentando acceso a miembros privados:");
            // humano.nombre = "Ana";             // ✗ Error: nombre has private access
            // humano.edad = 25;                  // ✗ Error: edad has private access
            System.out.println("Estos accesos están comentados porque causarían error de compilación");
        } catch (Exception e) {
            System.out.println("Error en acceso privado: " + e.getMessage());
        }
        
        // 4. Acceso correcto a través de métodos públicos
        try {
            System.out.println("\nAcceso correcto a través de métodos públicos:");
            humano.setNombre("Ana");
            humano.setEdad(25);
            System.out.println("Nombre modificado: " + humano.getNombre());
        } catch (Exception e) {
            System.out.println("Error en acceso a través de métodos públicos: " + e.getMessage());
        }
        
        // 5. Intentar establecer valores inválidos
        try {
            System.out.println("\nIntentando establecer valores inválidos:");
            humano.setEdad(-1);  // Esto no lanzará excepción pero tampoco cambiará el valor
            humano.setPeso(600); // Esto no lanzará excepción pero tampoco cambiará el valor            
        } catch (Exception e) {
            System.out.println("Error al establecer valores inválidos: " + e.getMessage());
            System.out.println("Los valores no se modificaron debido a las validaciones");
        } 

    }
}