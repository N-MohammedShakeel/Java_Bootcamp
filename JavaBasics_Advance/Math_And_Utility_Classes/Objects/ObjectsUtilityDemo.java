package Java_Bootcamp.JavaBasics_Advance.Math_And_Utility_Classes.Objects; /**
 * ObjectsUtilityDemo.java
 * Demonstrates Objects class for null-safe operations.
 * Scenario: Compare two strings and validate inputs.
 * Features: Uses Objects.equals(), requireNonNull(), and error handling.
 * DSA Relevance: Null handling, equality checks.
 */
import java.util.Objects;

public class ObjectsUtilityDemo {
    public static boolean compareStrings(String s1, String s2) {
        Objects.requireNonNull(s1, "First string cannot be null");
        Objects.requireNonNull(s2, "Second string cannot be null");
        return Objects.equals(s1, s2);
    }

    public static void main(String[] args) {
        System.out.println("=== Objects Utility Demo ===");
        // Example usage of Objects methods
        String s1 = "Hello";
        String s2 = null;
        System.out.println("Objects.equals('Hello', null): " + Objects.equals(s1, s2)); // false
        System.out.println("Objects.hashCode(null): " + Objects.hashCode(s2)); // 0
        System.out.println("Objects.toString(null): " + Objects.toString(s2)); // "null"

        // Practice Task: Compare strings
        System.out.println("\n=== Practice Task: Compare Strings ===");
        try {
            System.out.println("Comparing 'Hello' and 'Hello': " + compareStrings("Hello", "Hello")); // true
            System.out.println("Comparing 'Hello' and null: " + compareStrings("Hello", null)); // Throws exception
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}