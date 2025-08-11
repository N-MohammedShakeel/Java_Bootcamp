package Java_Bootcamp.JavaBasics_Advance.Formatter.Formatter_class; /**
 * FormatterClassDemo.java
 * Demonstrates Formatter class for advanced string formatting.
 * Scenario: Format name, age, and price into a StringBuilder.
 * Features: Uses Formatter, StringBuilder, and error handling.
 * DSA Relevance: String templating, output formatting.
 */
import java.util.Formatter;
import java.util.IllegalFormatException;

public class FormatterClassDemo {
    public static void main(String[] args) {
        System.out.println("=== Formatter Class Demo ===");
        StringBuilder sb = new StringBuilder();
        try (Formatter formatter = new Formatter(sb)) {
            String name = "Alice";
            int age = 25;
            double price = 19.99;
            formatter.format("Customer: %s, Age: %d, Price: %.2f%n", name, age, price);
            System.out.println("Formatted Output: " + sb.toString());
        } catch (IllegalFormatException e) {
            System.err.println("Formatting error: " + e.getMessage());
        }
    }
}