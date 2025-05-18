package Java_Bootcamp.OOPs.Inheritance;// Java Fundamentals: Inheritance and Types of Inheritance
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. Inheritance Overview
----------------------
- Inheritance allows a class (subclass) to inherit fields and methods from another class (superclass), promoting code reuse.
- Syntax: class Subclass extends Superclass { ... }
- Benefits: Code reusability, hierarchical organization, polymorphism support.
- Notes:
  - Java supports single inheritance for classes (one superclass per subclass).
  - Private members are not inherited but can be accessed indirectly via public/protected methods.
*/

/*
2. Extending Classes, super Keyword
----------------------------------
- Extending Classes:
  - Subclass inherits non-private members of the superclass using 'extends'.
  - Example: class Dog extends Animal { ... } // Dog inherits from Animal
- super Keyword:
  - Refers to the immediate superclass.
  - Uses:
    - Call superclass constructor: super(arguments);
    - Access superclass methods/fields: super.methodName();
  - Notes:
    - super() must be the first statement in a subclass constructor if used.
    - Java implicitly calls super() if no constructor call is specified, assuming a no-arg superclass constructor exists.
  - Example: super("Animal"); // Calls Animal's constructor
*/

/*
3. Method Overriding, @Override Annotation
-----------------------------------------
- Method Overriding:
  - Subclass provides a specific implementation of a method already defined in its superclass.
  - Rules:
    - Method name, return type, and parameters must match exactly.
    - Access modifier cannot be more restrictive than the superclass method.
    - Overridden method cannot throw new or broader checked exceptions.
  - Example: @Override public void makeSound() { System.out.println("Woof"); }
- @Override Annotation:
  - Indicates that a method is intended to override a superclass method.
  - Benefits:
    - Compiler checks for correct overriding (e.g., matching signature).
    - Improves code readability.
  - Notes:
    - Optional but recommended for clarity and error prevention.
    - Example: @Override public String toString() { ... }
*/

/*
4. final Keyword (Classes, Methods, Variables)
---------------------------------------------
- final Classes:
  - Cannot be extended (no subclasses allowed).
  - Syntax: final class ClassName { ... }
  - Example: final class ImmutableClass { ... }
- final Methods:
  - Cannot be overridden by subclasses.
  - Syntax: final Type methodName() { ... }
  - Example: final void criticalMethod() { ... }
- final Variables:
  - Cannot be reassigned after initialization (constant).
  - Syntax: final Type variableName = value;
  - Notes:
    - Must be initialized at declaration or in constructor (for instance fields).
    - Example: final int MAX_SPEED = 120;
  - Usage:
    - Ensures immutability and prevents unintended changes.
    - Common in constants and secure designs.
*/

/*
5. Types of Inheritance
----------------------
- Java supports the following types of inheritance:
  a. Single Inheritance
  b. Multilevel Inheritance
  c. Hierarchical Inheritance
- Not Supported:
  - Multiple Inheritance: A class cannot inherit from multiple classes due to the "diamond problem." Use interfaces instead.
  - Hybrid Inheritance: Combination of multiple and other inheritance types, not supported due to multiple inheritance restriction.

a. Single Inheritance:
  - A class inherits from one superclass.
  - Example: class Dog extends Animal { ... }
  - Benefits: Simple, clear hierarchy.

b. Multilevel Inheritance:
  - A class inherits from a superclass, which itself inherits from another superclass.
  - Example: class Animal { ... } class Mammal extends Animal { ... } class Dog extends Mammal { ... }
  - Benefits: Progressive specialization.

c. Hierarchical Inheritance:
  - Multiple classes inherit from the same superclass.
  - Example: class Animal { ... } class Dog extends Animal { ... } class Cat extends Animal { ... }
  - Benefits: Common functionality defined once in superclass.

d. Multiple Inheritance (via Interfaces):
  - Java uses interfaces to achieve multiple inheritance-like functionality.
  - Example: interface Flyable { ... } interface Swimmable { ... } class Duck implements Flyable, Swimmable { ... }
  - Notes: Interfaces provide method declarations; classes implement them.

e. Hybrid Inheritance:
  - Not supported directly due to multiple inheritance restriction.
  - Achieved indirectly using interfaces and class hierarchies.
*/

public class InheritanceAndTypes {
    public static void main(String[] args) {
        // Example 1: Single Inheritance
        System.out.println("Single Inheritance:");
        Dog dog = new Dog("Canine", "Golden Retriever");
        dog.makeSound(); // Golden Retriever dog says Woof!
        dog.eat(); // Canine is eating
        dog.fetch(); // Golden Retriever dog is fetching a ball

        // Example 2: Multilevel Inheritance
        System.out.println("\nMultilevel Inheritance:");
        Labrador labrador = new Labrador("Canine", true, "Buddy");
        labrador.makeSound(); // Buddy Labrador says Bark!
        labrador.displayFurStatus(); // Canine has fur: true
        labrador.eat(); // Canine is eating

        // Example 3: Hierarchical Inheritance
        System.out.println("\nHierarchical Inheritance:");
        Cat cat = new Cat("Feline", "Black");
        cat.makeSound(); // Black cat says Meow!
        dog.makeSound(); // Golden Retriever dog says Woof! (same superclass)

        // Example 4: Multiple Inheritance via Interfaces
        System.out.println("\nMultiple Inheritance (via Interfaces):");
        Duck duck = new Duck("Duck");
        duck.makeSound(); // Duck says Quack!
        duck.fly(); // Duck is flying
        duck.swim(); // Duck is swimming

        // Example 5: final Keyword
        System.out.println("\nfinal Keyword Example:");
        System.out.println("Base Lifespan: " + dog.BASE_LIFESPAN); // 10
        // dog.BASE_LIFESPAN = 15; // Compilation error: cannot assign to final variable
        // Cannot override final method 'eat' or extend final class Duck
    }
}