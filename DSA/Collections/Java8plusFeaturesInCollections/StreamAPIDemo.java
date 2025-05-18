package Java_Bootcamp.DSA.Collections.Java8plusFeaturesInCollections;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Class to demonstrate Stream API
class StreamAPIDemo {
    // Demonstrates filter(), map(), reduce(), collect(), and parallel streams.

    public static void demonstrate() {
        System.out.println("=== Stream API Demonstration ===");

        // Create a List for demonstration
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original List: " + numbers);

        // 1. filter()
        // - Selects elements that match a predicate.
        // - Use Case: Extracting a subset of elements (e.g., even numbers).
        System.out.println("\nUsing filter() to get even numbers:");
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers); // Output: [2, 4, 6, 8, 10]

        // 2. map()
        // - Transforms each element using a function.
        // - Use Case: Converting data types or applying operations (e.g., squaring numbers).
        System.out.println("\nUsing map() to square numbers:");
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared numbers: " + squaredNumbers); // Output: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]

        // 3. reduce()
        // - Aggregates elements into a single result (e.g., sum, product).
        // - Use Case: Computing aggregates (e.g., sum of numbers).
        System.out.println("\nUsing reduce() to compute sum:");
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of numbers: " + sum); // Output: 55

        // 4. collect()
        // - Collects stream results into a collection or other structure.
        // - Use Case: Converting stream results to a List, Set, or Map.
        System.out.println("\nUsing collect() to create a Set:");
        Set<Integer> numberSet = numbers.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toSet());
        System.out.println("Numbers > 5: " + numberSet); // Output: [6, 7, 8, 9, 10]

        // 5. Parallel streams
        // - Processes elements in parallel using multiple threads for performance.
        // - Use Case: Speeding up computationally intensive tasks on large datasets.
        System.out.println("\nUsing parallel stream to process numbers:");
        long startTime = System.currentTimeMillis();
        List<Integer> parallelResult = numbers.parallelStream()
                .map(n -> {
                    try {
                        Thread.sleep(100); // Simulate intensive task
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return n * 2;
                })
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel stream result: " + parallelResult); // Output: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
        System.out.println("Parallel stream time: " + (endTime - startTime) + " ms");
    }
}
