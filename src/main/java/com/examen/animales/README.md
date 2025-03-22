# Animals Feature Documentation

## Overview
This feature implements a polymorphic animal sound system using Java's object-oriented principles. The system allows different types of animals to make their characteristic sounds through a common interface.

## Architecture

### Core Components

1. **Abstract Base Class: `Animal`**
   - Defines the common interface for all animals
   - Contains an abstract method `hacerSonido()` that must be implemented by subclasses

2. **Enum: `AnimalSoundEnum`**
   - Defines all possible animal sounds
   - Each enum value contains the actual sound string
   - Supported sounds: DOG, CAT, COW, SHEEP, CHICKEN, PIG, DUCK, HORSE, LION, SNAKE

3. **Concrete Implementations:**
   - `Perro` (Dog): Implements `hacerSonido()` to return `AnimalSoundEnum.DOG`
   - `Gato` (Cat): Implements `hacerSonido()` to return `AnimalSoundEnum.CAT`

## Usage Examples

### Basic Usage
```java
   Animal perro = new Perro();
   Animal gato = new Gato();
   
   AnimalSoundEnum sonidoPerro = perro.hacerSonido();
   AnimalSoundEnum sonidoGato = gato.hacerSonido();
```

### Polymorphic Usage
```java

   package com.examen.animales;
   Animal[] animales = {new Perro(), new Gato(), new Perro()};   
   for (Animal animal : animales) {
       System.out.println("Un animal hace: " + animal.hacerSonido().getSound());
   }
```

## Testing
The feature includes comprehensive unit tests in `AnimalTest.java` that verify:
- Correct sound implementation for dogs
- Correct sound implementation for cats
- Polymorphic behavior with arrays of animals

## Author
- **Author:** Andres Serron
- **Version:** 1.0
- **Since:** 2025-03-21

## Design Patterns Used
- Template Method Pattern (through abstract class)
- Strategy Pattern (through polymorphic sound implementation)
