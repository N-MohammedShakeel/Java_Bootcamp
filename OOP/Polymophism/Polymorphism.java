package Java_Bootcamp.OOP.Polymophism;// Java Fundamentals: Polymorphism
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. Method Overloading and Overriding
-----------------------------------
- Method Overloading:
  - Multiple methods in the same class with the same name but different parameters (number, type, or order).
  - Compile-time polymorphism (static binding).
  - Rules:
    - Method name must be the same.
    - Parameters must differ (signature).
    - Return type and access modifiers can differ but are not sufficient alone.
  - Example: void display(int a) { ... } and void display(String s) { ... }
- Method Overriding:
  - Subclass provides a specific implementation of a method defined in its superclass.
  - Runtime polymorphism (dynamic binding).
  - Rules:
    - Method name, return type, and parameters must match exactly.
    - Access modifier cannot be more restrictive.
    - Cannot throw new or broader checked exceptions.
    - Use @Override annotation for clarity and compiler checks.
  - Example: @Override public void makeSound() { System.out.println("Woof"); }
- Notes:
  - Overloading occurs within a class; overriding occurs between superclass and subclass.
  - Overloading is resolved at compile time; overriding at runtime.
*/

/*
2. Dynamic Method Dispatch
-------------------------
- Mechanism by which a call to an overridden method is resolved at runtime based on the actual object type, not the reference type.
- Key Concept:
  - A superclass reference can hold a subclass object (polymorphism).
  - When an overridden method is called via the superclass reference, the subclass's version is executed.
- Syntax: Superclass ref = new Subclass();
- Example: Animal animal = new Dog(); animal.makeSound(); // Calls Dog's makeSound()
- Notes:
  - Enables runtime polymorphism.
  - Only overridden methods are dynamically dispatched; non-overridden methods use the reference type's version.
  - Requires inheritance and method overriding.
*/

/*
3. Casting (Upcasting, Downcasting)
----------------------------------
- Casting:
  - Converting an object reference from one type to another within an inheritance hierarchy.
- Upcasting:
  - Casting a subclass object to a superclass type (implicit, safe).
  - Syntax: Superclass ref = subclassObject;
  - Example: Animal animal = new Dog(); // Implicit upcasting
  - Notes:
    - Always safe as subclass is a type of superclass.
    - Only superclass members are accessible via the reference.
- Downcasting:
  - Casting a superclass reference to a subclass type (explicit, potentially unsafe).
  - Syntax: Subclass ref = (Subclass) superclassRef;
  - Example: Dog dog = (Dog) animal; // Explicit downcasting
  - Notes:
    - Requires the object to actually be an instance of the subclass (checked at runtime).
    - Use instanceof operator to avoid ClassCastException.
    - Example: if (animal instanceof Dog) { Dog dog = (Dog) animal; }
*/

public class Polymorphism {
    public static void main(String[] args) {
        // Example 1: Method Overloading
        System.out.println("Method Overloading:");
        Animal animal = new Animal("Generic");
        animal.displayInfo(); // Generic
        animal.getDetails("Basic"); // Generic Detail: Basic

        // Example 2: Method Overriding and Dynamic Method Dispatch
        System.out.println("\nMethod Overriding and Dynamic Method Dispatch:");
        Animal dog = new Dog("Canine", "Golden Retriever"); // Upcasting
        Animal cat = new Cat("Feline", "Black"); // Upcasting
        dog.makeSound(); // Golden Retriever dog says Woof!
        cat.makeSound(); // Black cat says Meow!

        // Example 3: Casting (Upcasting and Downcasting)
        System.out.println("\nCasting:");
        // Upcasting (implicit)
        Animal animalRef = new Dog("Canine", "Labrador");
        animalRef.makeSound(); // Labrador dog says Woof!

        // Downcasting (explicit)
        if (animalRef instanceof Dog) {
            Dog dogRef = (Dog) animalRef; // Safe downcasting
            dogRef.fetch(); // Labrador dog is fetching a ball
        }

        // Attempting unsafe downcasting
        Animal genericAnimal = new Animal("Unknown");
        if (genericAnimal instanceof Dog) {
            Dog invalidDog = (Dog) genericAnimal; // Would throw ClassCastException
        } else {
            System.out.println("Cannot downcast Animal to Dog");
        }
    }
}