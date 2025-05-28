package Java_Bootcamp.OOPs;// Java Fundamentals: Type Casting
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Type Casting Overview
--------------------
- Type casting is the process of converting a value from one data type to another.
- Java supports two main categories of type casting:
  1. Primitive Type Casting
  2. Reference Type Casting
- Casting is necessary when assigning a value of one type to a variable of another type, ensuring type compatibility.

1. Primitive Type Casting
------------------------
- Involves converting between primitive data types (e.g., int, double, byte).
- Types:
  a. Implicit Casting (Widening Conversion):
    - Automatic conversion from a smaller/less precise type to a larger/more precise type.
    - No data loss, as the target type can accommodate the value.
    - Order (smallest to largest): byte → short → int → long → float → double
    - Example: int num = 100; double result = num; // Implicitly converts int to double
  b. Explicit Casting (Narrowing Conversion):
    - Manual conversion from a larger/more precise type to a smaller/less precise type.
    - Requires a cast operator: (TargetType) value
    - May result in data loss if the value is too large for the target type.
    - Example: double num = 10.99; int result = (int) num; // Explicitly converts double to int (truncates to 10)
- Notes:
  - Implicit casting is safe; explicit casting requires caution due to potential data loss.
  - Casting between char and numeric types (e.g., int to char) is possible but depends on Unicode values.

2. Reference Type Casting
-------------------------
- Involves converting between reference types (e.g., objects, interfaces) within an inheritance hierarchy.
- Types:
  a. Upcasting:
    - Casting a subclass object to a superclass type (implicit, safe).
    - Syntax: Superclass ref = subclassObject;
    - Example: Animal animal = new Dog(); // Implicit upcasting
    - Notes:
      - Always safe as a subclass is a type of superclass.
      - Only superclass members are accessible via the reference.
  b. Downcasting:
    - Casting a superclass reference to a subclass type (explicit, potentially unsafe).
    - Syntax: Subclass ref = (Subclass) superclassRef;
    - Example: Dog dog = (Dog) animal; // Explicit downcasting
    - Notes:
      - Requires the object to be an instance of the subclass (checked at runtime).
      - Use instanceof operator to avoid ClassCastException.
      - Example: if (animal instanceof Dog) { Dog dog = (Dog) animal; }
- Notes:
  - Reference casting is used in polymorphism to treat objects generically or access subclass-specific members.
  - Interfaces can also be used in upcasting/downcasting when a class implements them.
*/

// Superclass for reference type casting examples
class Animal {
    protected String species;

    public Animal(String species) {
        this.species = species;
    }

    public void makeSound() {
        System.out.println(species + " makes a generic sound");
    }
}

// Subclass for reference type casting
class Dog extends Animal {
    private String breed;

    public Dog(String species, String breed) {
        super(species);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(breed + " dog says Woof!");
    }

    public void fetch() {
        System.out.println(breed + " dog is fetching a ball");
    }
}

public class TypeCasting {
    public static void main(String[] args) {
        // Example 1: Primitive Type Casting - Implicit (Widening)
        System.out.println("Primitive Type Casting - Implicit (Widening):");
        int intNum = 100;
        double doubleNum = intNum; // Implicit cast: int to double
        System.out.println("int: " + intNum + ", double: " + doubleNum); // int: 100, double: 100.0

        // Example 2: Primitive Type casting - Explicit (Narrowing)
        System.out.println("\nPrimitive Type Casting - Explicit (Narrowing):");
        double largeNum = 10.99;
        int smallNum = (int) largeNum; // Explicit cast: double to int (truncates decimal)
        System.out.println("double: " + largeNum + ", int: " + smallNum); // double: 10.99, int: 10

        // Example 3: Primitive Type Casting - char and int
        System.out.println("\nPrimitive Type Casting - char and int:");
        char letter = 'A';
        int asciiValue = letter; // Implicit cast: char to int (Unicode value)
        System.out.println("char: " + letter + ", int (ASCII): " + asciiValue); // char: A, int (ASCII): 65
        int num = 66;
        char converted = (char) num; // Explicit cast: int to char
        System.out.println("int: " + num + ", char: " + converted); // int: 66, char: B

        // Example 4: Reference Type Casting - Upcasting
        System.out.println("\nReference Type Casting - Upcasting:");
        Dog dog = new Dog("Canine", "Golden Retriever");
        Animal animal = dog; // Implicit upcasting: Dog to Animal
        animal.makeSound(); // Golden Retriever dog says Woof! (polymorphism)
        // animal.fetch(); // Compilation error: fetch() not available in Animal

        // Example 5: Reference Type Casting - Downcasting
        System.out.println("\nReference Type Casting - Downcasting:");
        if (animal instanceof Dog) { // To work correctly first we need to upcast then we need to downcast
            Dog downcastedDog = (Dog) animal; // Explicit downcasting: Animal to Dog
            downcastedDog.fetch(); // Golden Retriever dog is fetching a ball
        }

        // Example 6: Reference Type Casting - Avoiding ClassCastException
        System.out.println("\nReference Type Casting - Avoiding ClassCastException:");
        Animal genericAnimal = new Animal("Unknown");
        if (genericAnimal instanceof Dog) {
            Dog invalidDog = (Dog) genericAnimal; // Would throw ClassCastException
            invalidDog.fetch();
        } else {
            System.out.println("Cannot downcast Animal to Dog"); // This will print
        }
    }
}