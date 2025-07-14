package Java_Bootcamp.JavaBasics.others; /**
 * RandomDemo.java
 * Demonstrates the use of java.util.Random for generating random numbers and related miscellaneous utilities.
 * This file provides simple explanations, syntax, and examples for Random class methods, along with brief notes
 * on other java.util utilities (e.g., Math.random, UUID) relevant to randomization.
 * Designed for Data Structures and Algorithms (DSA) preparation, focusing on clarity and practical use cases.
 */
import java.util.Random;
import java.util.UUID;

public class RandomDemo {
    public static void main(String[] args) {
        // === 1. Introduction to Random ===
        // java.util.Random is a utility class for generating pseudo-random numbers.
        // It uses a seed-based algorithm (default seed is system time) to produce repeatable sequences.
        // Common Use Cases:
        // - Generating random integers, doubles, or booleans for simulations, testing, or games.
        // - Shuffling collections (e.g., arrays or lists) in DSA algorithms.
        // - Random selection in algorithms (e.g., QuickSort pivot, load balancing).

        // Create a Random instance (unseeded, uses system time)
        Random random = new Random();

        // === 2. Basic Random Number Generation ===
        // 2.1 nextInt() - Generates a random integer (all int values possible)
        System.out.println("=== nextInt() ===");
        int randomInt = random.nextInt();
        System.out.println("Random integer: " + randomInt);
        // Special Case: Output varies each run (e.g., 123456789 or -987654321).

        // 2.2 nextInt(bound) - Generates a random integer from 0 (inclusive) to bound (exclusive)
        System.out.println("\n=== nextInt(bound) ===");
        int randomBounded = random.nextInt(10); // 0 to 9
        System.out.println("Random integer (0-9): " + randomBounded);
        // Special Case: bound must be positive, else throws IllegalArgumentException.

        // 2.3 nextDouble() - Generates a random double between 0.0 (inclusive) and 1.0 (exclusive)
        System.out.println("\n=== nextDouble() ===");
        double randomDouble = random.nextDouble();
        System.out.println("Random double (0.0-1.0): " + randomDouble);
        // Special Case: Useful for probabilities or fractional values.

        // 2.4 nextBoolean() - Generates a random true or false
        System.out.println("\n=== nextBoolean() ===");
        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random boolean: " + randomBoolean);
        // Special Case: Useful for random decision-making (e.g., flip a coin).

        // === 3. Using a Seed for Reproducible Results ===
        // Setting a seed makes the random sequence predictable, useful for testing.
        System.out.println("\n=== Seeded Random ===");
        Random seededRandom = new Random(12345); // Fixed seed
        System.out.println("Seeded random int: " + seededRandom.nextInt());
        System.out.println("Seeded random int: " + seededRandom.nextInt());
        // Output: Same sequence every run with seed 12345 (e.g., -1183527736, 1557234732).
        // Special Case: Same seed produces identical sequences, useful for debugging.

        // === 4. Shuffling a List ===
        // Random can shuffle collections using Collections.shuffle
        System.out.println("\n=== Shuffling a List ===");
        java.util.List<Integer> numbers = new java.util.ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original list: " + numbers);
        java.util.Collections.shuffle(numbers, random);
        System.out.println("Shuffled list: " + numbers);
        // Output: Varies (e.g., [3, 1, 5, 2, 4]).
        // Special Case: Use a seeded Random for reproducible shuffles.

        // === 5. Miscellaneous Random Utilities ===
        // 5.1 Math.random()
        // Generates a random double between 0.0 (inclusive) and 1.0 (exclusive).
        // Internally uses Random but is simpler for basic use.
        System.out.println("\n=== Math.random() ===");
        double mathRandom = Math.random();
        System.out.println("Math.random double: " + mathRandom);
        // Special Case: No seed control, less flexible than Random.

        // 5.2 UUID.randomUUID()
        // Generates a universally unique identifier (random string).
        // Use Case: Unique IDs for objects, database keys, or sessions.
        System.out.println("\n=== UUID.randomUUID() ===");
        String uuid = UUID.randomUUID().toString();
        System.out.println("Random UUID: " + uuid);
        // Output: Varies (e.g., "550e8400-e29b-41d4-a716-446655440000").
        // Special Case: Suitable for unique identifiers, not for general random numbers.

        // === 6. Real-World DSA Example ===
        // Example: Randomly select an element from an array (e.g., for QuickSort pivot)
        System.out.println("\n=== DSA Example: Random Array Element ===");
        int[] array = {10, 20, 30, 40, 50};
        int randomIndex = random.nextInt(array.length);
        System.out.println("Array: " + java.util.Arrays.toString(array));
        System.out.println("Random element at index " + randomIndex + ": " + array[randomIndex]);
        // Output: Varies (e.g., Random element at index 2: 30).
        // Special Case: Random selection is critical in randomized algorithms like QuickSort.
    }
}