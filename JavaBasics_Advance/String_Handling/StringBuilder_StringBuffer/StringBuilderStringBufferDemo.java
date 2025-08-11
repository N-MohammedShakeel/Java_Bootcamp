package Java_Bootcamp.JavaBasics_Advance.String_Handling.StringBuilder_StringBuffer;

/**
 * StringBuilderStringBufferDemo.java
 * Demonstrates StringBuilder and StringBuffer for mutable string operations.
 * Scenario: Build a large string and compare performance, using key methods.
 * Features: Uses append(), insert(), reverse(), and performance timing.
 * DSA Relevance: Dynamic array resizing, string manipulation.
 */
public class StringBuilderStringBufferDemo {
    public static void main(String[] args) {
        // Example from provided code
        System.out.println("=== StringBuilder Demo ===");
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // Hello World
        sb.insert(5, ","); // Hello, World
        sb.replace(0, 5, "Hi"); // Hi, World
        sb.delete(0, 3); // , World
        sb.reverse(); // dlroW ,
        System.out.println("StringBuilder result: " + sb.toString()); // dlroW ,
        System.out.println("Capacity: " + sb.capacity());

        System.out.println("\n=== StringBuffer Demo ===");
        StringBuffer sbf = new StringBuffer("Java");
        sbf.append(" is fun!"); // Java is fun!
        sbf.insert(4, ","); // Java, is fun!
        System.out.println("StringBuffer result: " + sbf.toString()); // Java, is fun!

        // Practice Task: Compare performance
        System.out.println("\n=== Performance Comparison ===");
        int iterations = 1000;

        // StringBuilder performance
        long startTime = System.nanoTime();
        StringBuilder builder = new StringBuilder(1000); // Set initial capacity
        for (int i = 0; i < iterations; i++) {
            builder.append(i).append(",");
        }
        String result = builder.toString();
        long builderTime = System.nanoTime() - startTime;
        System.out.println("StringBuilder time: " + builderTime / 1_000_000.0 + " ms");

        // StringBuffer performance
        startTime = System.nanoTime();
        StringBuffer buffer = new StringBuffer(1000);
        for (int i = 0; i < iterations; i++) {
            buffer.append(i).append(",");
        }
        result = buffer.toString();
        long bufferTime = System.nanoTime() - startTime;
        System.out.println("StringBuffer time: " + bufferTime / 1_000_000.0 + " ms");
    }
}