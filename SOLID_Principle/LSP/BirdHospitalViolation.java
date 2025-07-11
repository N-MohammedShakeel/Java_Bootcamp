package Java_Bootcamp.SOLID_Principle.LSP;

// BirdHospitalViolation.java
// Demonstrates a violation of the Liskov Substitution Principle (LSP)
// Subclass (Penguin) cannot substitute base class (Bird) without breaking behavior

// Base class for birds
class Bird1 {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

// Derived class for penguins
// Violation: Penguin cannot fly, breaking the expected behavior of Bird
class Penguin1 extends Bird1 {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}

// Hospital treating birds
public class BirdHospitalViolation {
    public static void treatBird(Bird1 bird) {
        // Assumes all birds can fly, but Penguin throws an exception
        bird.fly();
    }

    public static void main(String[] args) {
        Bird1 sparrow = new Bird1();
        Bird1 penguin = new Penguin1();
        treatBird(sparrow); // Works fine
        treatBird(penguin); // Throws exception, violating LSP
    }
}