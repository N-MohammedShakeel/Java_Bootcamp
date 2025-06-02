package Java_Bootcamp.OOPs.Abstraction;// Java Fundamentals: Abstraction
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. Abstract Classes and Methods
-------------------------------
- Abstract Class:
  - A class declared with the 'abstract' keyword that cannot be instantiated.
  - Can contain abstract methods (without implementation) and concrete methods (with implementation).
  - Syntax: abstract class ClassName { ... }
  - Example: abstract class Animal { abstract void makeSound(); }
- Abstract Method:
  - Declared with 'abstract' keyword, no body, must be implemented by subclasses.
  - Syntax: abstract Type methodName();
  - Notes:
    - Subclasses must implement all abstract methods unless they are also abstract.
    - Abstract classes can have fields, constructors, and non-abstract methods.
  - Usage:
    - Provides a common structure for subclasses while enforcing certain behaviors.
  - Example: abstract class Vehicle { abstract void start(); void stop() { ... } }
*/

/*
2. Interfaces (Default and Static Methods, Functional Interfaces)
----------------------------------------------------------------
- Interface:
  - A contract specifying methods that implementing classes must provide.
  - Declared with 'interface' keyword; all methods were implicitly abstract (pre-Java 8).
  - Syntax: interface InterfaceName { void methodName(); }
- Default Methods (Java 8+):
  - Methods with implementation in an interface, declared with 'default' keyword.
  - Syntax: default Type methodName() { ... }
  - Allows adding new methods to interfaces without breaking existing implementations.
  - Example: default void description() { System.out.println("Default description"); }
- Static Methods (Java 8+):
  - Belong to the interface, not instances, called using InterfaceName.method().
  - Syntax: static Type methodName() { ... }
  - Example: static void info() { System.out.println("Interface info"); }
- Functional Interfaces:
  - An interface with exactly one abstract method (SAM: Single Abstract Method).
  - Can be used with lambda expressions and method references.
  - Example: @FunctionalInterface interface Processor { void process(); }
  - Notes:
    - Annotated with @FunctionalInterface for compiler checks.
    - Default and static methods do not count toward the SAM requirement.
- Notes:
  - Interfaces are implicitly abstract; methods are public and abstract unless specified otherwise.
  - Classes implement interfaces using 'implements' keyword.
  - Interfaces support multiple inheritance-like behavior (a class can implement multiple interfaces).
*/

/*
3. Implementing Multiple Interfaces
-----------------------------------
- A class can implement multiple interfaces to provide multiple behaviors.
- Syntax: class ClassName implements Interface1, Interface2 { ... }
- Rules:
  - Must implement all abstract methods from all interfaces.
  - If interfaces have conflicting default methods, the class must override them.
  - Example: class Bird implements Flyable, Singable { ... }
- Notes:
  - Solves Java's lack of multiple inheritance for classes.
  - Common in real-world designs (e.g., a class implementing Comparable and Serializable).
  - Use 'super' to call specific interface default methods if needed.
*/

public class Abstraction {
    public static void main(String[] args) {

        // Example 1: Abstract Class and Methods
        System.out.println("Abstract Class and Methods:");
        Bird sparrow = new Bird("Avian", "Sparrow");
        sparrow.makeSound(); // Sparrow bird chirps
        sparrow.eat(); // Avian is eating

        // Example 2: Interfaces with Default and Static Methods
        System.out.println("\nInterfaces with Default and Static Methods:");
        sparrow.describeFlight(); // This object can fly / Sparrow bird flies gracefully
        sparrow.describeSong(); // This object can sing
        Flyable.flightInfo(); // Flight capability defined by Flyable interface

        // Example 3: Implementing Multiple Interfaces
        System.out.println("\nImplementing Multiple Interfaces:");
        sparrow.fly(); // Sparrow bird is flying
        sparrow.sing(); // Sparrow bird is singing a song
        sparrow.process(); // Sparrow bird is processing data
        sparrow.reset(); // Processor reset

        // Example 4: Functional Interface with Lambda
        System.out.println("\nFunctional Interface with Lambda:");
        Processor customProcessor = () -> System.out.println("Custom processing");
        customProcessor.process(); // Custom processing
    }
}