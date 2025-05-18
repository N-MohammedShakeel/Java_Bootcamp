package Java_Bootcamp.ExceptionHandling;// Java Fundamentals: Exception Hierarchy
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Exception Hierarchy Overview
---------------------------
- Exceptions are events that disrupt the normal flow of a program, typically caused by errors or unexpected conditions.
- Java organizes exceptions in a hierarchy rooted at java.lang.Throwable.
- Two main subclasses of Throwable:
  1. Error
  2. Exception
- Key Classes:
  - Throwable: Base class for all errors and exceptions; provides methods like getMessage(), getCause(), printStackTrace().
  - Error: Represents serious problems that applications should not catch (e.g., system-level issues).
  - Exception: Represents conditions that applications can catch and handle (e.g., runtime or logic errors).

1. Checked vs. Unchecked Exceptions
----------------------------------
- Checked Exceptions:
  - Subclasses of Exception (but not RuntimeException or its subclasses).
  - Must be declared in a method's throws clause or handled with try-catch.
  - Checked at compile time to ensure proper handling.
  - Examples: IOException, SQLException, ClassNotFoundException.
  - Use Case: Recoverable conditions (e.g., file not found, database errors).
- Unchecked Exceptions:
  - Subclasses of RuntimeException (which extends Exception) and Error.
  - Not required to be declared or caught; compiler does not enforce handling.
  - Typically indicate programming errors or unrecoverable system issues.
  - Examples: NullPointerException, ArrayIndexOutOfBoundsException (RuntimeException); OutOfMemoryError (Error).
  - Use Case: Logic errors or critical failures (e.g., accessing null reference, invalid array index).
- Notes:
  - Checked exceptions encourage robust error handling; unchecked exceptions simplify code but require careful programming.
  - Error instances (e.g., StackOverflowError) are generally not caught, as they indicate unrecoverable conditions.

2. Common Exceptions
--------------------
- RuntimeException Subclasses (Unchecked):
  - NullPointerException: Thrown when accessing a method or field of a null object reference.
  - ArrayIndexOutOfBoundsException: Thrown when accessing an array with an invalid index.
  - ArithmeticException: Thrown for invalid arithmetic operations (e.g., division by zero).
  - IllegalArgumentException: Thrown when a method receives an invalid argument.
  - ClassCastException: Thrown when an invalid type cast is attempted.
- Other Common Exceptions:
  - IOException (Checked): Thrown for I/O failures (e.g., file reading/writing errors).
  - NumberFormatException (Unchecked): Thrown when parsing an invalid numeric string.
- Notes:
  - Understanding the exception type helps determine whether to catch, throw, or avoid the issue through defensive programming.
  - Use specific exception types in catch blocks for precise handling.
*/

public class ExceptionHierarchy {
    public static void main(String[] args) {
        // Example 1: NullPointerException (Unchecked)
        System.out.println("Example 1: NullPointerException");
        try {
            String str = null;
            System.out.println(str.length()); // Throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Example 2: ArrayIndexOutOfBoundsException (Unchecked)
        System.out.println("\nExample 2: ArrayIndexOutOfBoundsException");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // Throws ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Example 3: ArithmeticException (Unchecked)
        System.out.println("\nExample 3: ArithmeticException");
        try {
            int result = 10 / 0; // Throws ArithmeticException
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Example 4: IllegalArgumentException (Unchecked)
        System.out.println("\nExample 4: IllegalArgumentException");
        try {
            setAge(-5); // Throws IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Example 5: ClassCastException (Unchecked)
        System.out.println("\nExample 5: ClassCastException");
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj; // Throws ClassCastException
            System.out.println(num);
        } catch (ClassCastException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Example 6: NumberFormatException (Unchecked)
        System.out.println("\nExample 6: NumberFormatException");
        try {
            int num = Integer.parseInt("abc"); // Throws NumberFormatException
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Example 7: IOException (Checked, simulated)
        System.out.println("\nExample 7: IOException (Simulated)");
        try {
            throw new java.io.IOException("Simulated I/O error");
        } catch (java.io.IOException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    // Method to demonstrate IllegalArgumentException
    private static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        System.out.println("Age set to: " + age);
    }
}