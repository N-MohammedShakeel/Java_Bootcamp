package Java_Bootcamp.JavaBasics.StringHandling;// Java Fundamentals: String Handling
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. String Class Methods
----------------------
- The String class (java.lang.String) is immutable and represents a sequence of characters.
- Common Methods:
  - length(): Returns the number of characters (int).
  - substring(int beginIndex, int endIndex): Returns a substring (beginIndex inclusive, endIndex exclusive).
  - indexOf(String str): Returns the index of the first occurrence of str (-1 if not found).
  - charAt(int index): Returns the character at the specified index.
  - toUpperCase()/toLowerCase(): Converts the string to upper/lowercase.
  - trim(): Removes leading and trailing whitespace.
  - replace(CharSequence target, CharSequence replacement): Replaces all occurrences of target with replacement.
  - split(String regex): Splits the string into an array based on the regex delimiter.
  - equals(Object obj): Compares string content for equality.
  - startsWith(String prefix)/endsWith(String suffix): Checks if the string starts/ends with the specified prefix/suffix.
- Notes:
  - String methods do not modify the original string due to immutability; they return a new String.
  - Indexes are 0-based; invalid indexes throw StringIndexOutOfBoundsException.
  - Example: String s = "Hello"; s.length(); // Returns 5
*/

/*
2. String Immutability
---------------------
- Strings are immutable: Once created, their content cannot be changed.
- Reasons:
  - Thread-safety: Immutable objects are inherently thread-safe.
  - Security: Prevents unintended changes in critical data (e.g., file paths).
  - Memory efficiency: Strings are cached in the String pool for reuse.
- Implications:
  - Operations like concatenation create new String objects.
  - Example: String s = "Hello"; s = s + " World"; // Creates new String "Hello World"
- Notes:
  - Use StringBuilder/StringBuffer for frequent modifications to avoid performance overhead.
  - String literals (e.g., "Hello") are stored in the String pool; new String("Hello") creates a new object on the heap.
*/

/*
3. StringBuilder and StringBuffer for Mutable Strings
---------------------------------------------------
- StringBuilder:
  - Mutable sequence of characters, non-thread-safe, introduced in Java 5.
  - Methods: append(), insert(), delete(), replace(), reverse(), toString().
  - Example: StringBuilder sb = new StringBuilder("Hello"); sb.append(" World");
  - Use Case: Single-threaded applications requiring string manipulation.
- StringBuffer:
  - Mutable sequence of characters, thread-safe (synchronized methods).
  - Same methods as StringBuilder but slower due to synchronization.
  - Example: StringBuffer sbf = new StringBuffer("Hello"); sbf.append(" World");
  - Use Case: Multithreaded applications requiring thread safety.
- Notes:
  - StringBuilder is preferred over StringBuffer for performance unless thread safety is needed.
  - Both are more efficient than String for repeated modifications.
  - Capacity can be specified (default 16) to optimize memory usage.
*/

/*
4. String Formatting (String.format, printf)
------------------------------------------
- String.format:
  - Creates formatted strings using format specifiers.
  - Syntax: String.format(String format, Object... args)
  - Common specifiers:
    - %s: String
    - %d: Integer
    - %f: Floating-point (%.2f for 2 decimal places)
    - %n: Platform-specific newline
  - Example: String.format("Name: %s, Age: %d", "John", 25);
- printf:
  - Prints formatted output to the console, similar to String.format but directly outputs.
  - Syntax: System.out.printf(String format, Object... args);
  - Example: System.out.printf("Price: %.2f%n", 19.99);
- Notes:
  - Both methods support locale-specific formatting (e.g., Locale.US).
  - Format specifiers allow precise control over output (e.g., padding, alignment).
  - Use %n for newlines in formatted strings to ensure platform independence.
*/

public class StringHandling {
    public static void main(String[] args) {
        // Example 1: String Class Methods
        System.out.println("String Class Methods:");
        String text = "  Hello, Java!  ";
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

        // Example 2: String Immutability
        System.out.println("\nString Immutability:");
        String s1 = "Hello";
        String s2 = s1 + " World"; // Creates new String
        System.out.println("s1: " + s1); // Hello (unchanged)
        System.out.println("s2: " + s2); // Hello World
        System.out.println("s1 == s2: " + (s1 == s2)); // false (different objects)
        String s3 = "Hello";
        System.out.println("s1 == s3: " + (s1 == s3)); // true (same String pool object)

        // Example 3: StringBuilder
        System.out.println("\nStringBuilder:");
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // Modifies existing object
        sb.insert(5, ","); // Hello, World
        sb.replace(0, 5, "Hi"); // Hi, World
        sb.delete(0, 3); // , World
        sb.reverse(); // dlroW ,
        System.out.println("StringBuilder result: " + sb.toString()); // dlroW ,
        System.out.println("Capacity: " + sb.capacity()); // Typically 16 + length

        // Example 4: StringBuffer
        System.out.println("\nStringBuffer:");
        StringBuffer sbf = new StringBuffer("Java");
        sbf.append(" is fun!"); // Java is fun!
        sbf.insert(4, ","); // Java, is fun!
        System.out.println("StringBuffer result: " + sbf.toString()); // Java, is fun!

        // Example 5: String Formatting
        System.out.println("\nString Formatting:");
        String name = "Alice";
        int age = 25;
        double price = 19.999;
        // Using String.format
        String formatted = String.format("Name: %s, Age: %d, Price: %.2f%n", name, age, price);
        System.out.print("String.format: " + formatted); // Name: Alice, Age: 25, Price: 20.00
        // Using printf
        System.out.printf("printf: Name: %s, Age: %d, Price: %.2f%n", name, age, price);
        // printf: Name: Alice, Age: 25, Price: 20.00
    }
}