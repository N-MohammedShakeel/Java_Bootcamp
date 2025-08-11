package Java_Bootcamp.JavaBasics_Advance.String_Handling.Escape_Characters;

/**
 * EscapeCharactersDemo.java
 * Demonstrates all Java escape characters with formatted output.
 * Scenario: Create a table-like string with file path and quoted text.
 * Features: Uses \n, \t, \\, \", and input validation.
 * DSA Relevance: String formatting, character manipulation.
 */
public class EscapeCharactersDemo {
    public static void main(String[] args) {
        // Examples from provided code
        System.out.println("=== Escape Characters Demo ===");
        System.out.println("=== \\n (Newline) ===");
        System.out.println("Hello\nWorld");
        System.out.println("\n=== \\r (Carriage Return) ===");
        System.out.print("Hello\rWorld");
        System.out.println("\n=== \\t (Tab) ===");
        System.out.println("Name\tAge\tCity");
        System.out.println("Alice\t30\tNew York");
        System.out.println("\n=== \\\" (Double Quote) ===");
        System.out.println("She said, \"Hello!\"");
        System.out.println("\n=== \\' (Single Quote) ===");
        char singleQuote = '\'';
        System.out.println("Single quote character: " + singleQuote);
        System.out.println("\n=== \\\\ (Backslash) ===");
        System.out.println("File path: C:\\Users\\Alice");
        System.out.println("\n=== \\b (Backspace) ===");
        System.out.print("Hello\bWorld");
        System.out.println("\n=== \\f (Form Feed) ===");
        System.out.println("Page 1\fPage 2");

        // Practice Task: Formatted string with multiple escape characters
        System.out.println("\n=== Practice Task ===");
        try {
            String formatted = "Table:\n" +
                              "Name\tAge\tPath\n" +
                              "John\t25\tC:\\data\\file.txt\n" +
                              "Quote\t\"Hi\"\tC:\\quotes.txt";
            System.out.println(formatted);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}