package Java_Bootcamp.JavaBasics_Advance.String_Handling;

/**
 * StringMethodsDemo.java
 * Demonstrates common String methods for text processing.
 * Scenario: Process user input to trim, convert to lowercase, split into words, and print word lengths.
 * Features: Uses trim(), toLowerCase(), split(), length(), and input validation.
 * DSA Relevance: String manipulation, array iteration.
 */
public class StringMethodsDemo {
    public static void main(String[] args) {
        // Example from provided code
        String text = "  Hello, Java!  ";
        System.out.println("=== String Methods Demo ===");
        System.out.println("Original: '" + text + "'");
        System.out.println("Length: " + text.length()); // 15
        System.out.println("Substring (2, 7): " + text.substring(2, 7)); // Hel
        System.out.println("Index of 'Java': " + text.indexOf("Java")); // 8
        System.out.println("Char at index 3: " + text.charAt(3)); // l
        System.out.println("Uppercase: " + text.toUpperCase()); //   HELLO, JAVA!  
        System.out.println("Trimmed: '" + text.trim() + "'"); // 'Hello, Java!'
        System.out.println("Replace 'Java' with 'World': " + text.replace("Java", "World")); //   Hello, World!  
        String[] words = text.trim().split(",\\s*"); // Split on comma and optional spaces
        System.out.print("Split result: ");
        for (String word : words) {
            System.out.print(word + " "); // Hello Java!
        }
        System.out.println();
        System.out.println("Equals 'Hello, Java!': " + text.trim().equals("Hello, Java!")); // true
        System.out.println("Starts with '  Hel': " + text.startsWith("  Hel")); // true
        System.out.println("Ends with 'va!  ': " + text.endsWith("va!  ")); // true

        // Practice Task: Process input string
        System.out.println("\n=== Practice Task ===");
        String input = "  This is a TEST string  ";
        try {
            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("Input cannot be null or empty");
            }
            String processed = input.trim().toLowerCase();
            String[] wordArray = processed.split("\\s+");
            System.out.println("Processed words:");
            for (String word : wordArray) {
                System.out.printf("Word: %s, Length: %d%n", word, word.length());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}