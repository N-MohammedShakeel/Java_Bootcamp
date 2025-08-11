package Java_Bootcamp.JavaBasics_Advance.Math_And_Utility_Classes.Random; /**
 * RandomClassDemo.java
 * Demonstrates Random class for generating random numbers.
 * Scenario: Generate an array of 10 random integers (0-99).
 * Features: Uses Random, setSeed(), and input validation.
 * DSA Relevance: Random number generation, array manipulation.
 */
import java.util.Random;

public class RandomClassDemo {
    public static void main(String[] args) {
        System.out.println("=== Random Class Demo ===");
        Random random = new Random(123L); // Fixed seed for reproducibility

        // Example usage of Random methods
        System.out.println("Random int: " + random.nextInt());
        System.out.println("Random int (0-9): " + random.nextInt(10));
        System.out.println("Random double [0,1): " + random.nextDouble());
        System.out.println("Random boolean: " + random.nextBoolean());

        // Practice Task: Generate array of 10 random integers
        System.out.println("\n=== Practice Task: Random Array ===");
        try {
            int[] numbers = new int[10];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = random.nextInt(100); // 0-99
            }
            System.out.print("Random numbers: ");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}