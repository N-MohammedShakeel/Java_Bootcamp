package Java_Bootcamp.OOPs.Interfaces;// Java Fundamentals: Interfaces
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Interfaces Overview
------------------
- An interface is a contract that defines a set of methods a class must implement, promoting abstraction and loose coupling.
- Declared with the 'interface' keyword; all methods are implicitly public and abstract (unless specified otherwise).
- Syntax:
  interface InterfaceName {
      // Abstract methods, default methods, static methods, constants
  }
- Key Features:
  - Classes implement interfaces using the 'implements' keyword.
  - Supports multiple inheritance (a class can implement multiple interfaces).
  - Used for defining behaviors that can be shared across unrelated classes.
- Example: interface Movable { void move(); }

1. Declaring and Implementing Interfaces
---------------------------------------
- Declaration:
  - Methods are abstract by default (no body, end with semicolon).
  - Can include constants (public static final fields).
  - Example: interface Drivable { void drive(); int MAX_SPEED = 100; }
- Implementation:
  - A class implements an interface using 'implements'.
  - Must provide implementations for all abstract methods.
  - Syntax: class ClassName implements InterfaceName { ... }
  - Example: class Car implements Drivable { public void drive() { ... } }
- Notes:
  - Interfaces are implicitly abstract; cannot be instantiated.
  - All interface methods are public by default (prior to Java 8, all were abstract).

2. Default and Static Methods
-----------------------------
- Default Methods (Java 8+):
  - Provide a default implementation in the interface, declared with 'default' keyword.
  - Syntax: default Type methodName() { ... }
  - Purpose: Allows adding new methods to interfaces without breaking existing implementations.
  - Example: default void stop() { System.out.println("Stopping"); }
- Static Methods (Java 8+):
  - Belong to the interface, called using InterfaceName.methodName().
  - Syntax: static Type methodName() { ... }
  - Purpose: Provide utility methods related to the interface.
  - Example: static void info() { System.out.println("Interface info"); }
- Notes:
  - Default methods can be overridden by implementing classes.
  - Static methods cannot be overridden; they are tied to the interface.

3. Functional Interfaces
------------------------
- An interface with exactly one abstract method (Single Abstract Method, SAM).
- Used with lambda expressions and method references for functional programming.
- Annotated with '@FunctionalInterface' for compiler validation.
- Syntax: @FunctionalInterface interface InterfaceName { void singleMethod(); }
- Example: @FunctionalInterface interface Processor { void process(); }
- Notes:
  - Default and static methods do not count toward the SAM requirement.
  - Common in Java API (e.g., Runnable, Comparator).

4. Implementing Multiple Interfaces
-----------------------------------
- A class can implement multiple interfaces to provide multiple behaviors.
- Syntax: class ClassName implements Interface1, Interface2 { ... }
- Rules:
  - Must implement all abstract methods from all interfaces.
  - If default methods conflict (same signature), the class must override them.
- Example: class Robot implements Movable, Speakable { ... }
- Notes:
  - Enables multiple inheritance-like behavior in Java (since multiple class inheritance is not supported).
  - Use 'InterfaceName.super.methodName()' to call a specific default method if needed.
*/

public class Interfaces {
    public static void main(String[] args) {
        // Example 1: Implementing an Interface
        System.out.println("Implementing an Interface:");
        Robot robot = new Robot("R2D2");
        robot.move(); // R2D2 robot is moving at speed up to 100
        robot.describeMovement(); // This object is moving / R2D2 robot moves with precision

        // Example 2: Default and Static Methods
        System.out.println("\nDefault and Static Methods:");
        robot.describeSpeech(); // This object can speak
        Movable.movementInfo(); // Movable interface defines movement behavior

        // Example 3: Functional Interface with Lambda
        System.out.println("\nFunctional Interface with Lambda:");
        Processor customProcessor = () -> System.out.println("Custom processing task");
        customProcessor.process(); // Custom processing task
        customProcessor.reset(); // Processor reset

        // Example 4: Implementing Multiple Interfaces
        System.out.println("\nImplementing Multiple Interfaces:");
        robot.speak(); // R2D2 robot says: Beep Boop!
        robot.process(); // R2D2 robot is processing data
    }
}