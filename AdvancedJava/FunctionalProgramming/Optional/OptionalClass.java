package Java_Bootcamp.AdvancedJava.FunctionalProgramming.Optional;// Java Fundamentals: Optional Class
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Optional Class Overview
---------------------
- Introduced in Java 8, the Optional class (java.util.Optional) is a container object that may or may not contain a non-null value.
- Purpose: To explicitly handle the possibility of null values, reducing NullPointerException risks and improving code clarity.
- Key Features:
  - Encourages explicit null handling instead of implicit null checks.
  - Used in functional programming, Streams API, and modern Java APIs.
  - Not meant for fields or method parameters; primarily for return types.
- Example: Optional<String> name = Optional.of("John"); // Contains "John"

1. Handling Null Values
----------------------
- Creating Optionals:
  - Optional.of(T value): Creates an Optional with a non-null value (throws NullPointerException if value is null).
  - Optional.ofNullable(T value): Creates an Optional that may be empty if value is null.
  - Optional.empty(): Creates an empty Optional.
- Usage:
  - Check for presence: isPresent() or isEmpty() (Java 11+).
  - Retrieve value safely: get() (use cautiously, only if isPresent() is true).
  - Provide defaults or alternatives: orElse(), orElseGet(), orElseThrow().
- Example:
  Optional<String> opt = Optional.ofNullable(null);
  String value = opt.orElse("Default"); // Returns "Default" if empty
- Notes:
  - Optional forces developers to consider the null case explicitly.
  - Avoid using get() without isPresent() to prevent exceptions.
  - Use Optional in method return types to indicate potential absence of a value.

2. Methods like orElse, ifPresent
--------------------------------
- Common Methods:
  - orElse(T other): Returns the value if present, otherwise returns the specified default.
    - Example: opt.orElse("Default") returns "Default" if empty.
  - orElseGet(Supplier<? extends T>): Returns the value if present, otherwise invokes the Supplier.
    - Example: opt.orElseGet(() -> computeDefault()) for lazy evaluation.
  - orElseThrow(Supplier<? extends X extends Throwable>): Throws an exception if empty.
    - Example: opt.orElseThrow(() -> new IllegalStateException("No value"));
  - ifPresent(Consumer<? super T>): Performs an action if a value is present.
    - Example: opt.ifPresent(value -> System.out.println(value));
  - ifPresentOrElse(Consumer, Runnable): Performs an action if present, otherwise runs the Runnable (Java 9+).
  - filter(Predicate): Returns an Optional with the value if it matches the predicate, else empty.
  - map(Function): Transforms the value if present, returns Optional of result.
  - or(Supplier): Returns the Optional if present, else returns the Supplier's Optional (Java 9+).
- Notes:
  - orElseGet is preferred over orElse for expensive default computations (lazy evaluation).
  - Chain methods (e.g., filter, map) for functional-style processing.
  - Avoid overusing Optional; use only when null is a valid outcome.
*/

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        // Example 1: Creating Optionals and Handling Null
        System.out.println("Example 1: Creating Optionals and Handling Null");
        String name = null;
        Optional<String> opt1 = Optional.ofNullable(name); // Empty Optional
        Optional<String> opt2 = Optional.of("Alice"); // Non-empty Optional
        System.out.println("opt1 isPresent: " + opt1.isPresent()); // false
        System.out.println("opt2 isPresent: " + opt2.isPresent()); // true
        System.out.println("opt1 isEmpty: " + opt1.isEmpty()); // true (Java 11+)

        // Example 2: orElse and orElseGet
        System.out.println("\nExample 2: orElse and orElseGet");
        String result1 = opt1.orElse("Default Name");
        String result2 = opt1.orElseGet(() -> "Computed Default");
        System.out.println("orElse: " + result1); // Default Name
        System.out.println("orElseGet: " + result2); // Computed Default
        System.out.println("opt2 orElse: " + opt2.orElse("Default")); // Alice (value present)

        // Example 3: ifPresent and ifPresentOrElse
        System.out.println("\nExample 3: ifPresent and ifPresentOrElse");
        opt2.ifPresent(value -> System.out.println("Value found: " + value)); // Value found: Alice
        opt1.ifPresentOrElse(
            value -> System.out.println("Value: " + value),
            () -> System.out.println("No value present") // No value present
        );

        // Example 4: orElseThrow
        System.out.println("\nExample 4: orElseThrow");
        try {
            String value = opt1.orElseThrow(() -> new IllegalStateException("Value is missing"));
            System.out.println(value);
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage()); // Value is missing
        }

        // Example 5: filter and map
        System.out.println("\nExample 5: filter and map");
        Optional<String> filtered = opt2.filter(s -> s.length() > 3);
        System.out.println("Filtered (length > 3): " + filtered.orElse("None")); // Alice
        Optional<Integer> mapped = opt2.map(String::length);
        System.out.println("Mapped to length: " + mapped.orElse(0)); // 5

        // Example 6: or (Java 9+)
        System.out.println("\nExample 6: or");
        Optional<String> fallback = Optional.of("Bob");
        String result3 = opt1.or(() -> fallback).orElse("None");
        System.out.println("or with fallback: " + result3); // Bob
    }
}