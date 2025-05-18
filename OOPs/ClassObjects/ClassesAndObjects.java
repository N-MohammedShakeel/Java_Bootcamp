package Java_Bootcamp.OOPs.ClassObjects;

// Java Fundamentals: Classes and Objects
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. Defining Classes, Creating Objects
------------------------------------
- Class:
  - Blueprint for objects, defining properties (fields) and behaviors (methods).
  - Syntax:
    class ClassName {
        // Fields, constructors, methods
    }
  - Declared using the 'class' keyword; class name typically uses PascalCase.
  - Example: class Car { String model; void drive() {...} }
- Object:
  - Instance of a class, created using the 'new' keyword.
  - Syntax: ClassName objectName = new ClassName();
  - Objects are stored in heap memory; variables hold references to them.
  - Example: Car myCar = new Car(); // Creates a Car object
- Notes:
  - A class can have multiple objects, each with its own state.
  - Objects are accessed using the dot operator (e.g., myCar.model).
*/

/*
2. Constructors (Default, Parameterized)
---------------------------------------
- Constructor:
  - Special method used to initialize objects, called when an object is created.
  - Same name as the class, no return type (not even void).
- Default Constructor:
  - Automatically provided if no constructors are defined.
  - Initializes fields to default values (0, null, false, etc.).
  - Syntax: ClassName() { }
  - Example: Car() { } // Default constructor
- Parameterized Constructor:
  - Takes parameters to initialize fields with specific values.
  - Syntax: ClassName(Type param1, Type param2) { Initialize fields }
  - Example: Car(String model, int year) { this.model = model; this.year = year; }
- Notes:
        - If any constructor is defined, the default constructor is not provided.
        - Use 'this' to distinguish instance fields from parameters.
        - Constructors can be overloaded (multiple constructors with different parameters).
*/

/*
3. Instance and Static Fields/Methods
-------------------------------------
- Instance Fields:
  - Belong to an object, unique to each instance.
  - Declared without 'static' keyword.
  - Example: String model; // Each Car object has its own model
- Instance Methods:
  - Operate on instance fields, called on an object.
  - Example: void drive() { System.out.println(model + " is driving"); }
- Static Fields:
  - Belong to the class, shared by all objects.
  - Declared with 'static' keyword.
  - Example: static int carCount; // Tracks total number of Car objects
- Static Methods:
  - Belong to the class, called on the class itself, not an object.
  - Cannot directly access instance fields/methods unless an object is provided.
  - Example: static int getCarCount() { return carCount; }
- Notes:
  - Access static members using ClassName.field or ClassName.method().
  - Instance members require an object (objectName.field or objectName.method()).
  - Static fields are initialized when the class is loaded.
*/

public class ClassesAndObjects {
    // Instance fields
    private String model;
    private int year;

    // Static field
    private static int carCount = 0;

    // Default constructor
    public ClassesAndObjects() {
        this.model = "Unknown";
        this.year = 0;
        carCount++; // Increment car count when object is created
    }

    // Parameterized constructor
    public ClassesAndObjects(String model, int year) {
        this.model = model;
        this.year = year;
        carCount++; // Increment car count when object is created
    }

    // Instance method
    public void drive() {
        System.out.println(model + " (Year: " + year + ") is driving.");
    }

    // Static method
    public static int getCarCount() {
        return carCount;
    }

    // Instance method to get model (for demonstration)
    public String getModel() {
        return model;
    }

    public static void main(String[] args) {
        // Example 1: Creating objects using default constructor
        System.out.println("Creating object with default constructor:");
        ClassesAndObjects car1 = new ClassesAndObjects(); // Calls default constructor
        System.out.println("Car1 Model: " + car1.getModel()); // Unknown
        car1.drive(); // Unknown (Year: 0) is driving.

        // Example 2: Creating object using parameterized constructor
        System.out.println("\nCreating object with parameterized constructor:");
        ClassesAndObjects car2 = new ClassesAndObjects("Toyota Camry", 2023); // Calls parameterized constructor
        System.out.println("Car2 Model: " + car2.getModel()); // Toyota Camry
        car2.drive(); // Toyota Camry (Year: 2023) is driving.

        // Example 3: Accessing static field and method
        System.out.println("\nAccessing static field and method:");
        System.out.println("Total cars created: " + ClassesAndObjects.getCarCount()); // 2
    }
}