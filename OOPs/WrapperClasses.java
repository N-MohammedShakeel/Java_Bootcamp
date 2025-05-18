package Java_Bootcamp.OOPs;// Java Fundamentals: Wrapper Classes
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Wrapper Classes Overview
-----------------------
- Wrapper classes provide object representations of primitive data types, enabling their use in contexts requiring objects (e.g., collections).
- Located in the java.lang package, automatically imported.
- Each primitive type has a corresponding wrapper class:
  - byte → Byte
  - short → Short
  - int → Integer
  - long → Long
  - float → Float
  - double → Double
  - char → Character
  - boolean → Boolean
- Key Features:
  - Immutable objects that wrap a single primitive value.
  - Provide utility methods (e.g., parsing strings, converting types).
  - Example: Integer num = 100; // Wraps int value 100

1. Autoboxing and Unboxing
--------------------------
- Autoboxing:
  - Automatic conversion of a primitive type to its corresponding wrapper class.
  - Performed by the compiler when a primitive is used where an object is expected.
  - Example: Integer num = 10; // Autoboxes int to Integer
- Unboxing:
  - Automatic conversion of a wrapper class object to its corresponding primitive type.
  - Performed when a wrapper object is used where a primitive is expected.
  - Example: int value = num; // Unboxes Integer to int
- Contexts:
  - Method arguments, collections (e.g., ArrayList<Integer>), assignments, arithmetic operations.
- Notes:
  - Introduced in Java 5 for convenience and cleaner code.
  - Can cause NullPointerException if a null wrapper is unboxed (e.g., Integer num = null; int value = num;).
  - Example: List<Integer> list = new ArrayList<>(); list.add(5); // Autoboxes 5 to Integer

2. Converting Between Primitives and Wrappers
--------------------------------------------
- Manual Conversion (Pre-Java 5 or explicit control):
  - To Wrapper: Use constructor or static valueOf() method.
    - Example: Integer num = Integer.valueOf(10); // Preferred over new Integer(10)
  - To Primitive: Use xxxValue() methods (e.g., intValue(), doubleValue()).
    - Example: int value = num.intValue();
- Parsing Strings to Primitives/Wrappers:
  - Static parseXxx() methods convert strings to primitives.
    - Example: int num = Integer.parseInt("123");
  - Static valueOf() methods convert strings to wrappers.
    - Example: Integer numObj = Integer.valueOf("123");
- Converting Wrappers to Strings:
  - Use toString() or String.valueOf().
    - Example: String str = num.toString(); // "123"
- Notes:
  - valueOf() is preferred over constructors for better performance (caches common values).
  - Parsing methods throw NumberFormatException for invalid strings.
  - Wrapper classes provide constants (e.g., Integer.MAX_VALUE) and utility methods (e.g., Integer.compare()).
*/

import java.util.ArrayList;
import java.util.List;

public class WrapperClasses {
    public static void main(String[] args) {
        // Example 1: Autoboxing
        System.out.println("Autoboxing:");
        int primitiveInt = 42;
        Integer wrappedInt = primitiveInt; // Autoboxing: int to Integer
        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Wrapped Integer: " + wrappedInt);

        // Example 2: Unboxing
        System.out.println("\nUnboxing:");
        Integer integerObj = 100;
        int unwrappedInt = integerObj; // Unboxing: Integer to int
        System.out.println("Wrapped Integer: " + integerObj);
        System.out.println("Unwrapped int: " + unwrappedInt);

        // Example 3: Autoboxing/Unboxing with Collections
        System.out.println("\nAutoboxing/Unboxing with Collections:");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5); // Autoboxing: int to Integer
        numbers.add(10);
        int sum = numbers.get(0) + numbers.get(1); // Unboxing: Integer to int
        System.out.println("List: " + numbers);
        System.out.println("Sum: " + sum);

        // Example 4: Manual Conversion (Primitive to Wrapper and Vice Versa)
        System.out.println("\nManual Conversion:");
        // Primitive to Wrapper
        double primitiveDouble = 3.14;
        Double wrappedDouble = Double.valueOf(primitiveDouble);
        System.out.println("Primitive double: " + primitiveDouble);
        System.out.println("Wrapped Double: " + wrappedDouble);
        // Wrapper to Primitive
        Double doubleObj = 2.718;
        double unwrappedDouble = doubleObj.doubleValue();
        System.out.println("Wrapped Double: " + doubleObj);
        System.out.println("Unwrapped double: " + unwrappedDouble);

        // Example 5: Parsing Strings and Converting to Strings
        System.out.println("\nParsing Strings and Converting to Strings:");
        // String to Primitive
        String numStr = "123";
        int parsedInt = Integer.parseInt(numStr);
        System.out.println("String: " + numStr + ", Parsed int: " + parsedInt);
        // String to Wrapper
        Integer parsedInteger = Integer.valueOf("456");
        System.out.println("String: 456, Parsed Integer: " + parsedInteger);
        // Wrapper to String
        Integer num = 789;
        String numToString = num.toString();
        System.out.println("Integer: " + num + ", String: " + numToString);

        // Example 6: Handling NullPointerException in Unboxing
        System.out.println("\nHandling NullPointerException in Unboxing:");
        Integer nullInteger = null;
        try {
            int invalidUnbox = nullInteger; // Unboxing null causes NullPointerException
            System.out.println("Unboxed: " + invalidUnbox);
        } catch (NullPointerException e) {
            System.out.println("Error: Cannot unbox null Integer");
        }
    }
}