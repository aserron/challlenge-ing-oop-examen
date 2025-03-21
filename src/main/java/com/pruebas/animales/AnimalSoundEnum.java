package  com.pruebas.animales;

public enum AnimalSoundEnum {
    DOG("woof"),
    CAT("meow"),
    COW("moo"),
    SHEEP("baa"),
    CHICKEN("cluck"),
    PIG("oink"),
    DUCK("quack"),
    HORSE("neigh"),
    LION("roar"),
    SNAKE("hiss");

    private final String sound;

    AnimalSoundEnum(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}