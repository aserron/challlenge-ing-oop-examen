/**
 * @description: Clase de prueba para demostrar la jerarquía de Animales
 * @author: Andres Serron
 * @version: 1.0
 * @since: 2025-03-21
 */
package  com.pruebas.animales;

class AnimalesCheck {
    public static void main(String[] args) {
        // Crear instancias de Perro y Gato
        Animal perro = new Perro();
        Animal gato  = new Gato();
        
        // Probar el método hacerSonido
        System.out.println("=== Prueba de Sonidos de Animales ===");

        AnimalSoundEnum sonido1 = perro.hacerSonido();
        System.out.println("El perro hace: " + sonido1.getSound());
        assert AnimalSoundEnum.DOG.equals(sonido1) : "Sonido del perro es un animal";

        AnimalSoundEnum sonido2 = gato.hacerSonido();
        System.out.println("El gato hace: " + sonido2.getSound());
        assert AnimalSoundEnum.CAT.equals(sonido2) : "Sonido del perro es un animal";

        // Demostrar polimorfismo con un array de Animales
        System.out.println("\n=== Prueba de Polimorfismo ===");
        Animal[] animales = {new Perro(), new Gato(), new Perro()};
        for (Animal animal : animales) {
            System.out.println("Un animal hace: " + animal.hacerSonido().getSound());
        }
    }
} 