package Java_Bootcamp.DSA.Collections.Java8plusFeaturesInCollections;

import java.util.*;

// Class to demonstrate lambda expressions
class LambdaExpressionsDemo {
    // Demonstrates forEach() and removeIf() with lambda expressions.

    public static void demonstrate() {
        System.out.println("\n=== Lambda Expressions Demonstration ===");

        // Create a List for demonstration
        List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Mango"));
        System.out.println("Original List: " + fruits);

        // 1. forEach()
        // - Performs an action for each element using a lambda expression.
        // - Use Case: Iterating over elements to perform operations (e.g., printing).
        System.out.println("\nUsing forEach() to print fruits:");
        fruits.forEach(fruit -> System.out.println("Fruit: " + fruit));

        // forEach() with Map
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Charlie", 88);
        System.out.println("\nUsing forEach() with Map:");
        scores.forEach((name, score) -> System.out.println(name + ": " + score));

        // 2. removeIf()
        // - Removes elements that match a predicate.
        // - Use Case: Conditionally removing elements (e.g., removing short strings).
        System.out.println("\nUsing removeIf() to remove fruits with length < 6:");
        fruits.removeIf(fruit -> fruit.length() < 6);
        System.out.println("List after removeIf(): " + fruits); // Output: [Banana, Orange]
    }
}
