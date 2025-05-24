package Java_Bootcamp.Collections.Java8plusFeaturesInCollections;

import java.util.*;

// Class to demonstrate default methods in collection interfaces
class DefaultMethodsDemo {
    // Demonstrates Map.compute() and List.replaceAll().

    public static void demonstrate() {
        System.out.println("\n=== Default Methods Demonstration ===");

        // 1. Map.compute()
        // - Computes a new value for a key using a BiFunction, updating or removing the entry.
        // - Use Case: Updating map values dynamically (e.g., incrementing counters).
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Apple", 10);
        inventory.put("Banana", 5);
        System.out.println("Original Inventory: " + inventory);

        // Increment Apple's quantity
        inventory.compute("Apple", (key, value) -> value == null ? 1 : value + 1);
        System.out.println("After compute(Apple, +1): " + inventory); // Output: {Apple=11, Banana=5}

        // Remove Banana if quantity becomes 0
        inventory.compute("Banana", (key, value) -> value == null ? null : value - 5);
        System.out.println("After compute(Banana, -5): " + inventory); // Output: {Apple=11}

        // 2. List.replaceAll()
        // - Replaces each element with the result of a UnaryOperator.
        // - Use Case: Transforming all elements (e.g., converting to uppercase).
        List<String> names = new ArrayList<>(Arrays.asList("alice", "bob", "charlie"));
        System.out.println("\nOriginal Names: " + names);
        names.replaceAll(String::toUpperCase);
        System.out.println("After replaceAll(toUpperCase): " + names); // Output: [ALICE, BOB, CHARLIE]
    }
}
