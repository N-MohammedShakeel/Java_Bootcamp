package Java_Bootcamp.FunctionalProgramming.Lambda;// Java Fundamentals: Lambda Expressions
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Lambda Expressions Overview
--------------------------
- Lambda expressions, introduced in Java 8, provide a concise way to implement functional interfaces (interfaces with a single abstract method, SAM).
- Enable functional programming by treating functionality as a first-class citizen (pass behavior as data).
- Syntax: (parameters) -> expression  or  (parameters) -> { statements; }
- Examples:
  - () -> System.out.println("Hello"); // No parameters
  - (x) -> x * 2; // Single parameter, expression
  - (x, y) -> { return x + y; }; // Multiple parameters, block
- Key Features:
  - Eliminates boilerplate code for anonymous classes.
  - Used extensively with Java Streams API and functional interfaces.
  - Improves readability and maintainability for small, single-purpose functions.

1. Syntax and Use Cases
----------------------
- Syntax Variations:
  - No parameters: () -> expression
  - Single parameter: x -> expression  or  (x) -> expression
  - Multiple parameters: (x, y) -> expression
  - Block body: (x) -> { statements; return value; }
- Use Cases:
  - Implementing functional interfaces (e.g., Runnable, Comparator).
  - Stream operations (e.g., map, filter, forEach).
  - Event handling (e.g., button clicks in GUI).
  - Simplifying code for short, functional operations.
- Example:
  - Comparator<Integer> comp = (a, b) -> a - b; // Compare integers
  - list.stream().filter(n -> n % 2 == 0).forEach(System.out::println); // Stream filter and print
- Notes:
  - Lambda expressions can access final or effectively final variables from the enclosing scope.
  - Type inference reduces verbosity (parameter types often optional).
  - Method references (e.g., Class::method) can sometimes replace lambdas for brevity.

2. Functional Interfaces (Predicate, Function, Consumer, Supplier)
----------------------------------------------------------------
- Functional Interface:
  - An interface with exactly one abstract method (SAM), annotated with @FunctionalInterface for validation.
  - Examples in java.util.function package:
    a. Predicate<T>: Tests a condition, returns boolean.
      - Abstract method: boolean test(T t)
      - Example: Predicate<Integer> isEven = n -> n % 2 == 0;
    b. Function<T, R>: Transforms input to output.
      - Abstract method: R apply(T t)
      - Example: Function<String, Integer> length = s -> s.length();
    c. Consumer<T>: Performs an action on input, no return.
      - Abstract method: void accept(T t)
      - Example: Consumer<String> print = s -> System.out.println(s);
    d. Supplier<T>: Produces a value, takes no input.
      - Abstract method: T get()
      - Example: Supplier<Double> random = () -> Math.random();
- Notes:
  - Functional interfaces can have default and static methods without affecting SAM status.
  - Used with lambdas and method references in functional programming patterns.
  - Common in Streams, collections, and concurrency APIs.
*/

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        // Example 1: Basic Lambda Syntax
        System.out.println("Example 1: Basic Lambda Syntax");
        // Lambda with no parameters
        Runnable noParams = () -> System.out.println("Hello from lambda!");
        noParams.run();
        // Lambda with single parameter
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5)); // 25
        // Lambda with multiple parameters
        java.util.Comparator<Integer> compare = (a, b) -> a - b;
        System.out.println("Compare 10, 5: " + compare.compare(10, 5)); // 1

        // Example 2: Predicate Functional Interface
        System.out.println("\nExample 2: Predicate");
        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println("Is 10 positive? " + isPositive.test(10)); // true
        System.out.println("Is -5 positive? " + isPositive.test(-5)); // false
        List<Integer> numbers = Arrays.asList(-2, -1, 0, 1, 2);
        System.out.print("Positive numbers: ");
        numbers.stream().filter(isPositive).forEach(n -> System.out.print(n + " ")); // 1 2

        // Example 3: Function Functional Interface
        System.out.println("\n\nExample 3: Function");
        Function<String, Integer> strLength = s -> s.length();
        System.out.println("Length of 'Java': " + strLength.apply("Java")); // 4
        Function<Integer, String> toBinary = n -> Integer.toBinaryString(n);
        System.out.println("Binary of 10: " + toBinary.apply(10)); // 1010

        // Example 4: Consumer Functional Interface
        System.out.println("\nExample 4: Consumer");
        Consumer<String> printer = s -> System.out.println("Message: " + s);
        printer.accept("Hello, Lambda!"); // Message: Hello, Lambda!
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        System.out.print("Names: ");
        names.forEach(printer); // Message: Alice Message: Bob Message: Charlie

        // Example 5: Supplier Functional Interface
        System.out.println("\nExample 5: Supplier");
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Random value: " + randomValue.get());
        Supplier<String> defaultName = () -> "Unknown";
        System.out.println("Default name: " + defaultName.get()); // Unknown

        // Example 6: Lambda with Streams
        System.out.println("\nExample 6: Lambda with Streams");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.print("Doubled even numbers: ");
        nums.stream()
            .filter(n -> n % 2 == 0) // Predicate
            .map(n -> n * 2) // Function
            .forEach(n -> System.out.print(n + " ")); // Consumer
    }
}