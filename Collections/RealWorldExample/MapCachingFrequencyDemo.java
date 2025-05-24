package Java_Bootcamp.Collections.RealWorldExample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Class to demonstrate using Map for caching or frequency counting
class MapCachingFrequencyDemo {
    // Real-World Use Case: Caching results and counting frequencies.
    // - Caching: Store computed results to avoid redundant calculations.
    // - Frequency Counting: Count occurrences of elements (e.g., word frequency).

    public static void demonstrate() {
        System.out.println("\n=== Map for Caching and Frequency Counting Demonstration ===");

        // Caching (using Map)
        Map<Integer, Long> factorialCache = new HashMap<>();
        // Function to compute factorial with caching
        class FactorialCalculator {
            long compute(int n) {
                return factorialCache.computeIfAbsent(n, k -> {
                    if (k <= 1) return 1L;
                    return k * compute(k - 1);
                });
            }
        }

        FactorialCalculator calculator = new FactorialCalculator();
        System.out.println("Factorial of 5: " + calculator.compute(5)); // Computes and caches
        System.out.println("Factorial of 5 (cached): " + calculator.compute(5)); // Uses cache
        System.out.println("Cache contents: " + factorialCache);

        // Frequency Counting (using Map)
        List<String> words = Arrays.asList(
                "apple", "banana", "apple", "orange", "banana", "apple"
        );
        Map<String, Long> wordFrequency = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));

        System.out.println("\nWord List: " + words);
        System.out.println("Word Frequency: " + wordFrequency);
    }
}
