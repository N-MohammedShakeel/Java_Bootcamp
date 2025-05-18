package Java_Bootcamp.JavaBasics;// Java Fundamentals: Data Types and Variables
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. Primitive Types
-----------------
- Java has 8 primitive data types, which are not objects and store values directly.
- Types and their sizes:
  - byte: 8-bit integer (-128 to 127)
  - short: 16-bit integer (-32,768 to 32,767)
  - int: 32-bit integer (-2^31 to 2^31-1)
  - long: 64-bit integer (-2^63 to 2^63-1)
  - float: 32-bit floating-point (IEEE 754, ~6-7 decimal digits precision)
  - double: 64-bit floating-point (IEEE 754, ~15-16 decimal digits precision)
  - char: 16-bit Unicode character (0 to 65,535)
  - boolean: Represents true or false (not explicitly sized)
- Usage: Store simple values like numbers, characters, or logical states.
- Example: int age = 25; double salary = 50000.50;
*/

/*
2. Reference Types
-----------------
- Reference types store references (memory addresses) to objects, not the actual data.
- Common reference types:
  - String: Immutable sequence of characters (e.g., String name = "John";)
  - Arrays: Fixed-size collections of elements (e.g., int[] numbers = new int[5];)
  - Objects: Instances of classes (e.g., Object obj = new Object();)
- Characteristics:
  - Can be null (no object referenced).
  - Created using 'new' keyword (except String literals).
  - Stored in heap memory, managed by garbage collector.
- Example: String greeting = "Hello"; int[] scores = {90, 85, 88};
*/

/*
3. Variable Scope and Lifetime
----------------------------
- Scope: Region of code where a variable is accessible.
- Lifetime: Duration a variable retains its value.
- Types of variables:
  - Local Variables:
    - Declared inside methods, constructors, or blocks.
    - Scope: Within the block/method.
    - Lifetime: Exists until method/block execution completes.
    - Must be initialized before use (no default value).
    - Example: int x = 10; inside a method.
  - Instance Variables:
    - Declared inside a class but outside methods.
    - Scope: Accessible to all instance methods of the class.
    - Lifetime: Exists as long as the object exists.
    - Example: private String name; in a class.
  - Static Variables:
    - Declared with 'static' keyword inside a class.
    - Scope: Accessible to all instances of the class (class-level).
    - Lifetime: Exists for the entire duration of the program.
    - Example: static int counter = 0; in a class.
*/

/*
4. Default Values for Primitives and References
---------------------------------------------
- Instance and static variables are automatically initialized if not explicitly set.
- Default values for primitives:
  - byte, short, int: 0
  - long: 0L
  - float: 0.0f
  - double: 0.0
  - char: '\u0000' (null character)
  - boolean: false
- Default value for reference types:
  - All reference types (String, arrays, objects): null
- Local variables have no default value and must be initialized before use.
- Example: An uninitialized instance variable 'int count' will be 0, but a local 'int x' will cause a compilation error if used uninitialized.
*/

public class DataTypesAndVariables {
    // Instance variables (default values apply)
    private int instanceInt; // Default: 0
    private double instanceDouble; // Default: 0.0
    private String instanceString; // Default: null
    private int[] instanceArray; // Default: null

    // Static variable
    private static boolean staticFlag; // Default: false

    public static void main(String[] args) {
        // Local variables (must be initialized)
        byte myByte = 100;
        short myShort = 1000;
        int myInt = 50000;
        long myLong = 100000L; // 'L' suffix for long
        float myFloat = 3.14f; // 'f' suffix for float
        double myDouble = 2.71828;
        char myChar = 'A';
        boolean myBoolean = true;

        // Reference type examples
        String myString = "Hello, Java!";
        int[] myArray = new int[]{1, 2, 3, 4, 5};
        Object myObject = new Object();

        // Local variable scope example
        int localVar = 42;
        if (true) {
            int blockVar = 99; // Scope limited to this block
            System.out.println("blockVar: " + blockVar);
            System.out.println("localVar: " + localVar); // Accessible
        }
        // System.out.println(blockVar); // Error: blockVar out of scope

        // Demonstrate default values
        DataTypesAndVariables demo = new DataTypesAndVariables();
        System.out.println("Default instanceInt: " + demo.instanceInt); // 0
        System.out.println("Default instanceDouble: " + demo.instanceDouble); // 0.0
        System.out.println("Default instanceString: " + demo.instanceString); // null
        System.out.println("Default instanceArray: " + demo.instanceArray); // null
        System.out.println("Default staticFlag: " + staticFlag); // false

        // Demonstrate primitive and reference type usage
        System.out.println("byte: " + myByte);
        System.out.println("short: " + myShort);
        System.out.println("int: " + myInt);
        System.out.println("long: " + myLong);
        System.out.println("float: " + myFloat);
        System.out.println("double: " + myDouble);
        System.out.println("char: " + myChar);
        System.out.println("boolean: " + myBoolean);
        System.out.println("String: " + myString);
        System.out.println("Array first element: " + myArray[0]);
        System.out.println("Object: " + myObject);
    }
}