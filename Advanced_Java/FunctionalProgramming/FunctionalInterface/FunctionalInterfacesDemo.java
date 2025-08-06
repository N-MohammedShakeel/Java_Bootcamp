package Java_Bootcamp.Advanced_Java.FunctionalProgramming.FunctionalInterface;// Java Fundamentals: Functional Interfaces
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Functional Interfaces Overview
-----------------------------
- A functional interface is an interface with exactly one abstract method (Single Abstract Method, SAM).
- Introduced in Java 8 to support functional programming and lambda expressions.
- Annotated with @FunctionalInterface to ensure compliance and improve readability.
- Key Features:
  - Can have default, static, and private methods (Java 8+) without affecting SAM status.
  - Used with lambda expressions and method references for concise code.
  - Common in Java APIs (e.g., java.util.function package: Predicate, Function, Consumer, Supplier).
- Syntax:
  @FunctionalInterface
  interface MyInterface {
      void myMethod(String param);
  }
- Examples:
  - Built-in: Predicate<T>, Function<T,R>, Consumer<T>, Supplier<T>.
  - Custom: Define an interface with one abstract method.
- Use Cases:
  - Stream operations (filter, map, etc.).
  - Event handling, concurrency, and custom functional logic.
- Notes:
  - Default/static methods provide utility or reusable behavior.
  - Lambda expressions automatically implement the SAM.
*/

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        // Example 1: Using Built-in Functional Interface (Predicate)
        System.out.println("Example 1: Predicate");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // true
        System.out.println("Is 7 even? " + isEven.test(7)); // false

        // Example 2: Using Built-in Functional Interface (Function)
        System.out.println("\nExample 2: Function");
        Function<String, Integer> lengthFunction = s -> s.length();
        System.out.println("Length of 'Java': " + lengthFunction.apply("Java")); // 4

        // Example 3: Using Built-in Functional Interface (Consumer)
        System.out.println("\nExample 3: Consumer");
        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        printUpper.accept("hello"); // HELLO

        // Example 4: Using Built-in Functional Interface (Supplier)
        System.out.println("\nExample 4: Supplier");
        Supplier<String> defaultName = () -> "Anonymous";
        System.out.println("Default name: " + defaultName.get()); // Anonymous

        // Example 5: Custom Functional Interface (StringProcessor)
        System.out.println("\nExample 5: Custom StringProcessor");
        StringProcessor prefixer = s -> "Prefix_" + s;
        System.out.println("Processed: " + prefixer.process("Test")); // Prefix_Test
        System.out.println("Uppercase: " + prefixer.toUpperCase("Test")); // TEST
        System.out.println("Reversed: " + StringProcessor.reverse("Test")); // tseT

        // Example 6: Custom Functional Interface with Streams
        System.out.println("\nExample 6: Custom Validator with Streams");
        Validator positiveValidator = n -> n > 0;
        List<Integer> numbers = Arrays.asList(-1, 0, 1, 2, -3, 4);
        System.out.print("Positive numbers: ");
        numbers.stream()
               .filter(n -> positiveValidator.isValid(n))
               .forEach(n -> System.out.print(n + " ")); // 1 2 4
    }
}