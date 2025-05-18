package Java_Bootcamp.ExceptionHandling;

// Java Fundamentals: Handling Exceptions
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Exception Handling Overview
--------------------------
- Exception handling allows programs to manage errors gracefully, ensuring robustness and reliability.
- Java provides mechanisms to catch, handle, and throw exceptions to control program flow during errors.
- Key components: try, catch, finally, throw, throws, try-with-resources.

1. try, catch, finally Blocks
----------------------------
- try Block:
  - Encloses code that might throw an exception.
  - Syntax: try {  Code that may throw exceptions  }
        - catch Block:
        - Handles specific exceptions thrown in the try block.
  - Syntax: catch (ExceptionType e) {  Handle exception  }
        - Multiple catch blocks can handle different exception types.
        - finally Block:
        - Executes regardless of whether an exception is thrown or caught, used for cleanup.
  - Syntax: finally {  Cleanup code  }
        - Optional, but ensures resources (e.g., streams) are closed.
        - Example:
        try {
int result = 10 / 0; // Throws ArithmeticException
  } catch (ArithmeticException e) {
        System.out.println("Error: " + e.getMessage());
        } finally {
        System.out.println("Cleanup done");
  }
          - Notes:
        - Catch blocks should be ordered from specific to general (e.g., ArithmeticException before Exception).
        - Finally is executed even if a return statement is encountered, unless the JVM exits.

        2. Multi-catch and try-with-resources
------------------------------------
        - Multi-catch (Java 7+):
        - Allows a single catch block to handle multiple exception types using the | operator.
  - Syntax: catch (ExceptionType1 | ExceptionType2 e) {  Handle exceptions  }
        - Example: catch (IOException | SQLException e) { ... }
        - Notes:
        - Reduces code duplication.
    - Exceptions in multi-catch must not be related by inheritance (e.g., IOException | Exception is invalid).
        - try-with-resources (Java 7+):
        - Automatically closes resources (e.g., files, database connections) that implement AutoCloseable.
        - Syntax: try (ResourceType resource = new ResourceType()) {  Use resource  }
        - Example: try (FileInputStream fis = new FileInputStream("file.txt")) { ... }
        - Notes:
        - Eliminates the need for explicit finally blocks to close resources.
        - Resources are closed in reverse order of declaration.
        - Can include catch and finally blocks if needed.

3. Throwing Exceptions (throw, throws)
-------------------------------------
        - throw:
        - Used to explicitly throw an exception.
        - Syntax: throw new ExceptionType("Message");
  - Example: throw new IllegalArgumentException("Invalid input");
  - Notes:
        - Can throw any Throwable (Error or Exception).
        - Typically used to signal errors or invalid conditions.
        - throws:
        - Declares that a method may throw one or more checked exceptions.
  - Syntax: ReturnType methodName() throws ExceptionType1, ExceptionType2 { ... }
  - Example: public void readFile() throws IOException { ... }
  - Notes:
        - Required for checked exceptions (not RuntimeException or Error).
        - Callers must handle or declare these exceptions.
    - Unchecked exceptions do not require throws declaration.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HandlingExceptions {
    public static void main(String[] args) {
        // Example 1: try, catch, finally
        System.out.println("Example 1: try, catch, finally");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // Throws ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }

        // Example 2: Multi-catch
        System.out.println("\nExample 2: Multi-catch");
        try {
            String str = null;
            if (Math.random() > 0.5) {
                str.length(); // Throws NullPointerException
            } else {
                int num = Integer.parseInt("abc"); // Throws NumberFormatException
            }
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Example 3: try-with-resources
        System.out.println("\nExample 3: try-with-resources");
        try (BufferedReader reader = new BufferedReader(new FileReader("nonexistent.txt"))) {
            String line = reader.readLine();
            System.out.println("Read line: " + line);
        } catch (IOException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Example 4: Throwing Exceptions with throw
        System.out.println("\nExample 4: Throwing Exceptions with throw");
        try {
            validateAge(-5); // Throws IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Example 5: Method with throws
        System.out.println("\nExample 5: Method with throws");
        try {
            readFile("invalid.txt"); // Throws IOException
        } catch (IOException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    // Method demonstrating throw
    private static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        System.out.println("Valid age: " + age);
    }

    // Method demonstrating throws
    private static void readFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            System.out.println("Read line: " + line);
        }
    }
}