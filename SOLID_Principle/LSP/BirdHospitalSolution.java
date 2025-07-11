package Java_Bootcamp.SOLID_Principle.LSP;// BirdHospitalSolution.java
// Demonstrates adherence to the Liskov Substitution Principle (LSP)
// Subclasses can substitute base class without altering behavior

// Interface for flying behavior
interface Flyable {
    void fly();
}

// Base class for birds
abstract class Bird {
    // Common bird behaviors (e.g., eat, sleep) can go here
    public void eat() {
        System.out.println("Bird is eating");
    }
}

// Sparrow implements flying
class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

// Penguin does not implement Flyable
class Penguin extends Bird {
    // No fly method, as penguins don't fly
}

// Hospital treating birds
public class BirdHospitalSolution {
    // Treat flying birds
    public static void treatFlyingBird(Flyable bird) {
        bird.fly();
    }

    // Treat any bird (general behavior)
    public static void treatBird(Bird bird) {
        bird.eat();
    }

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();
        treatBird(sparrow); // Works fine
        treatBird(penguin); // Works fine
        treatFlyingBird((Flyable) sparrow); // Works fine
        // treatFlyingBird(penguin); // Compile-time error, Penguin is not Flyable
    }
}