package Java_Bootcamp.OOPs.Relationship.Is_A;

import java.util.ArrayList;
import java.util.List;

// Interface for Is-A relationship
interface Animal {
    void sound();
}

// Class-based Is-A: Inheritance
abstract class Mammal {
    protected String name;

    public Mammal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating");
    }
}

// Subclass: Class-based Is-A
class Dog extends Mammal implements Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + " barks");
    }

    public void fetch() {
        System.out.println(name + " fetches a ball");
    }
}

// Subclass: Interface-based Is-A
class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void sound() {
        System.out.println(name + " meows");
    }
}

// Interface for multiple inheritance
interface Pet {
    void play();
}

// Multiple Is-A: Class + Interface
class HouseDog extends Dog implements Pet {
    public HouseDog(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(name + " plays with a toy");
    }
}

public class IsARelationship {
    public static void main(String[] args) {
        // Test Class-based Is-A
        System.out.println("Testing Class-based Is-A (Dog is Mammal):");
        Dog dog = new Dog("Rex");
        dog.eat(); // Inherited from Mammal
        dog.sound(); // From Animal interface
        dog.fetch(); // Dog-specific
        // Output:
        // Rex is eating
        // Rex barks
        // Rex fetches a ball

        // Test Interface-based Is-A
        System.out.println("\nTesting Interface-based Is-A (Cat is Animal):");
        Cat cat = new Cat("Whiskers");
        cat.sound(); // From Animal
        // Output:
        // Whiskers meows

        // Test Multiple Is-A
        System.out.println("\nTesting Multiple Is-A (HouseDog is Dog and Pet):");
        HouseDog houseDog = new HouseDog("Max");
        houseDog.eat(); // From Mammal
        houseDog.sound(); // From Animal
        houseDog.play(); // From Pet
        // Output:
        // Max is eating
        // Max barks
        // Max plays with a toy

        // Test Polymorphism
        System.out.println("\nTesting Polymorphism:");
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Buddy"));
        animals.add(new Cat("Luna"));
        animals.add(new HouseDog("Tiny"));
        for (Animal animal : animals) {
            animal.sound(); // Dynamic binding
        }
        // Output:
        // Buddy barks
        // Luna meows
        // Tiny barks
    }
}