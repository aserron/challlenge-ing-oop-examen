package com.zoo;

// Clase en otro paquete para demostrar restricciones de acceso
class Extranjera {

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
        System.out.println("\nIntentando acceso a miembros protegidos:");

        humano.nacionalidad = "Francesa";  // ✗ Error: nacionalidad has protected access
        humano.grupoSanguineo = "O+";      // ✗ Error: grupoSanguineo has protected access

//        System.out.println("Error de acceso ilegal a miembros protegidos: " + e.getMessage());

//        System.out.println("Error en acceso protegido: " + e.getMessage());

        System.out.println("Estos accesos están comentados porque causarían error de compilación");

        // 3. Acceso a miembros privados (no permitido)
//        try {
            System.out.println("\nIntentando acceso a miembros privados:");
            // humano.nombre = "Ana";             // ✗ Error: nombre has private access
            // humano.edad = 25;                  // ✗ Error: edad has private access
            System.out.println("Estos accesos están comentados porque causarían error de compilación");
//        } catch (IllegalAccessException e) {
//            System.out.println("Error de acceso ilegal a miembros privados: " + e.getMessage());
//        } catch (Exception e) {
//            System.out.println("Error en acceso privado: " + e.getMessage());
//        }

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
            System.out.println("Los valores no se modificaron debido a las validaciones");
        } catch (Exception e) {
            System.out.println("Error al establecer valores inválidos: " + e.getMessage());
        }
    }
} 