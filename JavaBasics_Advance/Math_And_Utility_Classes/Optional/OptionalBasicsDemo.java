package Java_Bootcamp.JavaBasics_Advance.Math_And_Utility_Classes.Optional; /**
 * OptionalBasicsDemo.java
 * Demonstrates Optional class for null-safe string processing.
 * Scenario: Process a potentially null string to uppercase or return a default.
 * Features: Uses Optional.ofNullable(), map(), orElse(), and error handling.
 * DSA Relevance: Null handling, functional programming.
 */
import java.util.Optional;

public class OptionalBasicsDemo {
    public static String processString(String input) {
        return Optional.ofNullable(input)
                      .map(String::toUpperCase)
                      .orElse("DEFAULT");
    }

    public static void main(String[] args) {
        System.out.println("=== Optional Basics Demo ===");
        // Example usage of Optional
        String str = "Hello";
        Optional<String> opt1 = Optional.of(str);
        Optional<String> opt2 = Optional.ofNullable(null);
        System.out.println("opt1 isPresent: " + opt1.isPresent()); // true
        System.out.println("opt2 isPresent: " + opt2.isPresent()); // false
        opt1.ifPresent(s -> System.out.println("opt1 value: " + s)); // Hello
        System.out.println("opt2 orElse: " + opt2.orElse("Empty")); // Empty

        // Practice Task: Process strings
        System.out.println("\n=== Practice Task: Process Strings ===");
        String[] inputs = {"Hello", null, "Java"};
        for (String input : inputs) {
            System.out.println("Input: " + input + ", Output: " + processString(input));
        }
    }
}