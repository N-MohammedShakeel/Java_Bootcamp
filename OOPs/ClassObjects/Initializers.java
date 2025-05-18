package Java_Bootcamp.OOPs.ClassObjects;

// Java Fundamentals: Initializers
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Initializers Overview
--------------------
- Initializers are blocks of code used to initialize fields or perform setup tasks in a class.
- Java supports three main types of initializers:
  1. Instance Initializers
  2. Static Initializers
  3. Constructor Initialization
- Initializers ensure that objects or classes are properly set up before use, often initializing fields or performing complex setup logic.

1. Instance Initializers
-----------------------
- Non-static blocks of code defined directly within a class, executed during object creation.
- Syntax: { Initialization code }
        - Execution:
        - Runs after the superclass constructor but before the class's constructor body.
        - Executed for each object creation, in the order they appear in the class.
        - Use Cases:
        - Initialize instance fields with complex logic.
        - Share initialization code across multiple constructors.
        - Example: { count = 1; System.out.println("Instance initializer"); }
        - Notes:
        - Can access instance fields and methods.
        - Multiple instance initializers are allowed; executed in order of appearance.
  - Less common than constructors but useful for shared setup.

        2. Static Initializers
---------------------
        - Static blocks of code defined with the 'static' keyword, executed once when the class is loaded.
        - Syntax: static { Initialization code  }
- Execution:
        - Runs when the class is first loaded into memory (e.g., first object creation, static method call, or class reference).
        - Executed only once, before any static fields are accessed or objects are created.
- Use Cases:
        - Initialize static fields with complex logic.
        - Perform one-time setup for the class (e.g., loading resources).
        - Example: static { totalInstances = 0; System.out.println("Static initializer"); }
- Notes:
  - Can only access static fields and methods.
  - Multiple static initializers are allowed; executed in order of appearance.
  - Cannot throw checked exceptions unless handled within the block.

3. Constructor Initialization
----------------------------
        - Initialization performed within constructors, which are special methods called during object creation.
- Syntax: ClassName([parameters]) { Initialization code }
- Execution:
        - Runs after instance initializers and superclass constructor.
        - Allows parameterized initialization of fields.
- Use Cases:
        - Primary method for initializing instance fields.
        - Supports overloading for different initialization scenarios.
        - Example: public MyClass(String name) { this.name = name; }
- Notes:
        - Constructors implicitly call super() unless another constructor is invoked.
        - Preferred over instance initializers for most initialization tasks.
        - Can call other methods or instance initializers indirectly.
        */

// Example class demonstrating initializers
class Vehicle {
    private String model;
    private int instanceCount;
    private static int totalVehicles;

    // Static initializer
    static {
        totalVehicles = 0;
        System.out.println("Static Initializer: Setting totalVehicles to 0");
    }

    // Instance initializer
    {
        instanceCount = 1;
        System.out.println("Instance Initializer: Setting instanceCount to 1");
    }

    // Constructor
    public Vehicle(String model) {
        this.model = model;
        totalVehicles++;
        System.out.println("Constructor: Initialized model to " + model);
    }

    // Second constructor (overloaded)
    public Vehicle(String model, int initialCount) {
        this.model = model;
        this.instanceCount = initialCount;
        totalVehicles++;
        System.out.println("Constructor: Initialized model to " + model + ", instanceCount to " + initialCount);
    }

    // Instance method to display state
    public void display() {
        System.out.println("Vehicle: model=" + model + ", instanceCount=" + instanceCount);
    }

    // Static method to access static field
    public static int getTotalVehicles() {
        return totalVehicles;
    }
}

public class Initializers {
    public static void main(String[] args) {
        // Example 1: Static Initializer (runs once when class is loaded)
        System.out.println("Accessing static field to trigger static initializer:");
        System.out.println("Total Vehicles (before objects): " + Vehicle.getTotalVehicles());
        // Output: Static Initializer runs here

        // Example 2: Instance Initializer and Constructor (first object)
        System.out.println("\nCreating first Vehicle object:");
        Vehicle car = new Vehicle("Toyota Camry");
        car.display();
        // Output: Instance Initializer, Constructor, then display

        // Example 3: Instance Initializer and Overloaded Constructor (second object)
        System.out.println("\nCreating second Vehicle object with overloaded constructor:");
        Vehicle truck = new Vehicle("Ford F150", 5);
        truck.display();
        // Output: Instance Initializer, Constructor, then display

        // Example 4: Verify static field update
        System.out.println("\nTotal Vehicles (after creating objects): " + Vehicle.getTotalVehicles());
        // Output: 2 (two objects created)
    }
}
