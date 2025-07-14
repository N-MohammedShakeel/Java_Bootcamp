package Java_Bootcamp.JavaBasics.StringHandling;

/**
 * EscapeCharactersDemo.java
 * Demonstrates all Java escape characters with detailed explanations and examples.
 * Escape characters are special characters preceded by a backslash (\) used to represent
 * characters that cannot be easily typed or have special meanings in strings or character literals.
 * This file covers all standard Java escape sequences, their purposes, and real-world use cases.
 * Suitable for understanding string handling in Data Structures and Algorithms (DSA) contexts.
 */
public class EscapeCharactersDemo {
    public static void main(String[] args) {
        // 1. \n - Newline (Line Feed)
        // Purpose: Inserts a new line in the text.
        // ASCII: 10 (LF)
        // Use Case: Formatting multi-line output, such as in reports or logs.
        // Example: Printing a multi-line message.
        System.out.println("=== \\n (Newline) ===");
        System.out.println("Hello\nWorld");
        // Output:
        // Hello
        // World
        // Special Case: Behavior may vary slightly on different platforms (e.g., Windows uses \r\n).

        // 2. \r - Carriage Return
        // Purpose: Moves the cursor to the beginning of the line without advancing to the next line.
        // ASCII: 13 (CR)
        // Use Case: Overwriting text in console applications or handling legacy text formats.
        // Example: Overwriting part of a line.
        System.out.println("\n=== \\r (Carriage Return) ===");
        System.out.print("Hello\rWorld");
        // Output: World (overwrites "Hello" in some environments)
        // Special Case: Often used with \n (\r\n) for Windows line endings; standalone \r may have inconsistent behavior.

        // 3. \t - Tab
        // Purpose: Inserts a horizontal tab space.
        // ASCII: 9 (HT)
        // Use Case: Aligning text output in tables or formatted logs.
        // Example: Creating a simple tabulated output.
        System.out.println("\n=== \\t (Tab) ===");
        System.out.println("Name\tAge\tCity");
        System.out.println("Alice\t30\tNew York");
        // Output:
        // Name    Age    City
        // Alice   30     New York
        // Special Case: Tab width may vary depending on the output environment (e.g., IDE vs. terminal).

        // 4. \" - Double Quote
        // Purpose: Includes a double quote (") in a string literal.
        // ASCII: 34
        // Use Case: Generating JSON strings or including quotes in text output.
        // Example: Printing a string with embedded quotes.
        System.out.println("\n=== \\ \" (Double Quote) ===");
        System.out.println("She said, \"Hello!\"");
        // Output: She said, "Hello!"
        // Special Case: Essential in strings to avoid syntax errors; e.g., "He said, "Hello"" would fail without \".
        
        // 5. \' - Single Quote
        // Purpose: Includes a single quote (') in a character literal or string.
        // ASCII: 39
        // Use Case: Rarely needed in strings (since Java uses double quotes for strings), but used in character literals.
        // Example: Defining a character literal with a single quote.
        System.out.println("\n=== \\' (Single Quote) ===");
        char singleQuote = '\'';
        System.out.println("Single quote character: " + singleQuote);
        // Output: Single quote character: '
        // Special Case: Mainly used in character literals (e.g., char c = '\''); less common in strings.

        // 6. \\ - Backslash
        // Purpose: Includes a backslash (\) in a string.
        // ASCII: 92
        // Use Case: Specifying file paths (e.g., Windows paths) or regex patterns.
        // Example: Printing a file path.
        System.out.println("\n=== \\\\ (Backslash) ===");
        System.out.println("File path: C:\\Users\\Alice");
        // Output: File path: C:\Users\Alice
        // Special Case: Multiple backslashes may be needed in regex (e.g., "\\d" for digits).

        // 7. \b - Backspace
        // Purpose: Moves the cursor one position back, potentially overwriting a character.
        // ASCII: 8 (BS)
        // Use Case: Rarely used in modern applications; may be used in console-based text manipulation.
        // Example: Attempting to erase a character (effect varies by environment).
        System.out.println("\n=== \\b (Backspace) ===");
        System.out.print("Hello\bWorld");
        // Output: HellWorld (in some environments, 'o' is overwritten by 'W')
        // Special Case: Behavior is environment-dependent; often has no visible effect in modern consoles.

        // 8. \f - Form Feed
        // Purpose: Advances to the next "page" in text output (legacy printer control).
        // ASCII: 12 (FF)
        // Use Case: Rarely used today; historically used for printer formatting.
        // Example: Simulating page break (effect varies by environment).
        System.out.println("\n=== \\f (Form Feed) ===");
        System.out.println("Page 1\fPage 2");
        // Output: Page 1 (form feed may not be visible in some terminals)
        // Special Case: Mostly obsolete; effect depends on the output device or terminal.

        // Combined Example: Using multiple escape characters in a single string
        System.out.println("\n=== Combined Example ===");
        String message = "Error:\t\"Invalid input\" at line 5\nPath:\tC:\\data\\file.txt\nFix:\tRemove trailing \\b or \\r\\n";
        System.out.println(message);
        // Output:
        // Error:  "Invalid input" at line 5
        // Path:   C:\data\file.txt
        // Fix:    Remove trailing  or \r\n
    }
}