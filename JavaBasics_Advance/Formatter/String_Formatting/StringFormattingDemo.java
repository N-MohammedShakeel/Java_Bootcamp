package Java_Bootcamp.JavaBasics_Advance.Formatter.String_Formatting;

/**
 * StringFormattingDemo.java
 * Demonstrates String.format() and printf() for formatting output.
 * Scenario: Format a string with name, age, and price.
 * Features: Uses %s, %d, %.2f specifiers and input validation.
 * DSA Relevance: String template processing.
 */
public class StringFormattingDemo {
    public static void main(String[] args) {
        // Example from provided code
        System.out.println("=== String Formatting Demo ===");
        String name = "Alice";
        int age = 25;
        double price = 19.999;
        String formatted = String.format("Name: %s, Age: %d, Price: %.2f%n", name, age, price);
        System.out.print("String.format: " + formatted); // Name: Alice, Age: 25, Price: 20.00
        System.out.printf("printf: Name: %s, Age: %d, Price: %.2f%n", name, age, price);
        // printf: Name: Alice, Age: 25, Price: 20.00

        // Practice Task: Format with validation
        System.out.println("\n=== Practice Task ===");
        try {
            if (name == null) {
                throw new IllegalArgumentException("Name cannot be null");
            }
            String result = String.format("Customer: %s, Age: %d, Total: $%.2f%n", name, age, price);
            System.out.print("String.format: " + result);
            System.out.printf("printf: Customer: %s, Age: %d, Total: $%.2f%n", name, age, price);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}