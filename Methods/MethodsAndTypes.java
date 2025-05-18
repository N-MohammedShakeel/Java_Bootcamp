package Java_Bootcamp.Methods;// Java Fundamentals: Methods and Their Types
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Methods Overview
---------------
- A method is a block of code that performs a specific task and is executed when called.
- Declared within a class, methods define the behavior of objects or the class itself.
- Syntax:
  [modifiers] ReturnType methodName([parameters]) [throws Exception] {
      // Code block
      [return statement;]
  }
- Components:
  - Modifiers: e.g., public, static, final
  - ReturnType: Data type of value returned (or void if none)
  - methodName: Identifier (follows camelCase convention)
  - Parameters: Optional input values
  - Throws: Optional exception declarations
- Example: public int add(int a, int b) { return a + b; }

Types of Methods in Java
-----------------------
1. Instance Methods
2. Static Methods
3. Abstract Methods
4. Final Methods
5. Synchronized Methods
6. Native Methods

1. Instance Methods
------------------
- Belong to an instance of a class (object-specific).
- Can access instance fields and other instance methods directly.
- Called using an object: objectName.methodName().
- Example: public void display() { System.out.println(name); }
- Notes:
  - Require an object to be instantiated.
  - Used for object-specific operations.

2. Static Methods
-----------------
- Belong to the class, not an instance (class-level).
- Declared with 'static' keyword.
- Cannot directly access instance fields/methods unless an object is provided.
- Called using class name: ClassName.methodName().
- Example: public static int getCount() { return count; }
- Notes:
  - Useful for utility functions or operations not tied to a specific object.
  - Common in helper or factory methods.

3. Abstract Methods
-------------------
- Declared in abstract classes or interfaces without implementation.
- Use 'abstract' keyword; no body (ends with semicolon).
- Subclasses must provide implementation unless they are also abstract.
- Example: abstract void performAction();
- Notes:
  - Enforce a contract for subclasses to implement.
  - Cannot be instantiated directly (requires subclass).

4. Final Methods
----------------
- Declared with 'final' keyword; cannot be overridden by subclasses.
- Example: final void criticalOperation() { ... }
- Notes:
  - Used to prevent modification of critical functionality.
  - Ensures consistent behavior across inheritance hierarchy.

5. Synchronized Methods
-----------------------
- Declared with 'synchronized' keyword to control access in multithreaded environments.
- Ensures only one thread can execute the method at a time (thread-safe).
- Example: synchronized void updateResource() { ... }
- Notes:
  - Locks the object's monitor (instance method) or class monitor (static method).
  - Useful for shared resources but may impact performance.

6. Native Methods
-----------------
- Declared with 'native' keyword; implemented in a non-Java language (e.g., C/C++).
- No body in Java; implementation provided by native libraries (JNI: Java Native Interface).
- Example: public native void nativeOperation();
- Notes:
  - Used for performance-critical tasks or accessing platform-specific features.
  - Rarely used in standard Java development; requires external libraries.
*/

// Example class demonstrating method types
abstract class Vehicle {
    protected String model;
    private static int vehicleCount = 0;

    public Vehicle(String model) {
        this.model = model;
        vehicleCount++;
    }

    // Instance method
    public void displayModel() {
        System.out.println("Model: " + model);
    }

    // Static method
    public static int getVehicleCount() {
        return vehicleCount;
    }

    // Abstract method
    abstract void startEngine();

    // Final method
    public final void stopEngine() {
        System.out.println(model + " engine stopped");
    }

    // Synchronized method
    public synchronized void updateStatus(String status) {
        System.out.println(model + " status updated to: " + status);
    }
}

class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }

    @Override
    public void startEngine() {
        System.out.println(model + " car engine started");
    }

    // Cannot override final method stopEngine
    // public void stopEngine() { ... } // Compilation error
}

// Example interface with native method declaration
interface SystemOperations {
    // Native method (no implementation in Java)
//    native void accessHardware();
    void accessHardware();
}

public class MethodsAndTypes {
    public static void main(String[] args) {
        // Example 1: Instance Method
        System.out.println("Instance Method:");
        Car car = new Car("Toyota Camry");
        car.displayModel(); // Model: Toyota Camry

        // Example 2: Static Method
        System.out.println("\nStatic Method:");
        System.out.println("Total vehicles: " + Vehicle.getVehicleCount()); // Total vehicles: 1

        // Example 3: Abstract Method
        System.out.println("\nAbstract Method:");
        car.startEngine(); // Toyota Camry car engine started

        // Example 4: Final Method
        System.out.println("\nFinal Method:");
        car.stopEngine(); // Toyota Camry engine stopped

        // Example 5: Synchronized Method
        System.out.println("\nSynchronized Method:");
        car.updateStatus("Running"); // Toyota Camry status updated to: Running

        // Example 6: Native Method (conceptual)
        System.out.println("\nNative Method (Conceptual):");
        // Native methods require external implementation (e.g., via JNI)
        System.out.println("Native method 'accessHardware' would be implemented in C/C++");
    }
}