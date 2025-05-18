package Java_Bootcamp.OOPs.Static_Dynamic_Binding;// Java Fundamentals: Static and Dynamic Binding
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Binding Overview
---------------
- Binding refers to the process of connecting a method call to its method definition during program execution.
- Java supports two types of binding:
  1. Static Binding (Early Binding)
  2. Dynamic Binding (Late Binding)
- Binding determines which method implementation is invoked when a method is called, especially in the context of polymorphism.

1. Static Binding (Early Binding)
--------------------------------
- Definition:
  - The method to be called is resolved at compile time based on the reference type.
  - Occurs for methods that are not subject to runtime polymorphism.
- Characteristics:
  - Applies to:
    - Static methods
    - Final methods (cannot be overridden)
    - Private methods (not accessible for overriding)
    - Overloaded methods (resolved by parameter types)
    - Instance variable references (fields, not methods)
  - Resolved based on the declared type of the reference, not the actual object type.
  - Faster because resolution happens at compile time.
- Example:
  - Static method call: ClassName.staticMethod();
  - Overloaded method: obj.display(int) vs. obj.display(String)
- Notes:
  - Does not involve runtime polymorphism.
  - Compiler knows exactly which method to call based on the code structure.

2. Dynamic Binding (Late Binding)
--------------------------------
- Definition:
  - The method to be called is resolved at runtime based on the actual object type, not the reference type.
  - Occurs for overridden methods in a polymorphic context.
- Characteristics:
  - Applies to:
    - Instance methods that are overridden in subclasses.
    - Methods called through a superclass reference pointing to a subclass object.
  - Enables runtime polymorphism, a key feature of object-oriented programming.
  - Resolved using the object's actual type via dynamic method dispatch.
- Example:
  - Superclass ref = new Subclass(); ref.overriddenMethod(); // Calls Subclass's method
- Notes:
  - Slower than static binding due to runtime lookup.
  - Essential for achieving polymorphic behavior in inheritance hierarchies.
  - Uses the virtual method table (vtable) to determine the method to invoke.

Key Differences
---------------
- Static Binding:
  - Compile-time resolution
  - Based on reference type
  - Applies to static, final, private methods, and overloading
  - Example: Math.abs(10) (static method)
- Dynamic Binding:
  - Runtime resolution
  - Based on object type
  - Applies to overridden instance methods
  - Example: Animal animal = new Dog(); animal.makeSound(); (calls Dog's makeSound)

Use Cases
---------
- Static Binding: Utility methods, method overloading, and fields where polymorphism is not needed.
- Dynamic Binding: Polymorphic designs where subclass-specific behavior is required (e.g., method overriding).
*/

// Superclass for binding examples
class Animal {
    // Instance field (resolved by static binding)
    String description = "Generic Animal";

    // Static method (static binding)
    public static void staticInfo() {
        System.out.println("Static method in Animal");
    }

    // Instance method (subject to dynamic binding)
    public void makeSound() {
        System.out.println("Animal makes a generic sound");
    }

    // Overloaded method (static binding)
    public void display(String message) {
        System.out.println("Animal display: " + message);
    }

    // Overloaded method (static binding)
    public void display(int value) {
        System.out.println("Animal display value: " + value);
    }

    // Final method (static binding, cannot be overridden)
    public final void eat() {
        System.out.println("Animal is eating");
    }
}

// Subclass for binding examples
class Dog extends Animal {
    // Instance field (shadows superclass field, resolved by static binding)
    String description = "Dog";

    // Static method (hides superclass static method, static binding)
    public static void staticInfo() {
        System.out.println("Static method in Dog");
    }

    // Override instance method (dynamic binding)
    @Override
    public void makeSound() {
        System.out.println("Dog says Woof!");
    }

    // Overloaded method (static binding)
    public void display(String message) {
        System.out.println("Dog display: " + message);
    }
}

public class StaticAndDynamicBinding {
    public static void main(String[] args) {
        // Example 1: Static Binding - Static Method
        System.out.println("Static Binding - Static Method:");
        Animal.staticInfo(); // Static method in Animal
        Dog.staticInfo(); // Static method in Dog

        // Example 2: Static Binding - Overloaded Method
        System.out.println("\nStatic Binding - Overloaded Method:");
        Animal animalObj = new Animal();
        animalObj.display("Hello"); // Animal display: Hello
        animalObj.display(42); // Animal display value: 42

        // Example 3: Static Binding - Final Method
        System.out.println("\nStatic Binding - Final Method:");
        Dog dogObj = new Dog();
        dogObj.eat(); // Animal is eating (final method from Animal)

        // Example 4: Static Binding - Instance Field
        System.out.println("\nStatic Binding - Instance Field:");
        Animal animalRef = new Dog();
        System.out.println("Description: " + animalRef.description); // Generic Animal (reference type)

        // Example 5: Dynamic Binding - Overridden Method
        System.out.println("\nDynamic Binding - Overridden Method:");
        Animal polyRef = new Dog(); // Polymorphic reference
        polyRef.makeSound(); // Dog says Woof! (actual object type)
        polyRef = new Animal();
        polyRef.makeSound(); // Animal makes a generic sound (actual object type)
    }
}