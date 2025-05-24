package Java_Bootcamp.Collections.Iteration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Class to demonstrate iteration over a Map
class MapIterationDemo {
    // Demonstrates iteration methods on a Map (using HashMap).
    // Map stores key-value pairs; iteration is over keys, values, or entries.

    public static void demonstrate() {
        System.out.println("\n=== Map Iteration Demonstration ===");

        // Create a Map
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 85);
        map.put("Bob", 92);
        map.put("Charlie", 88);
        System.out.println("Map: " + map);

        // 1. Iterator (over entrySet, keySet, or values)
        // - Iterates over Map.Entry objects, keys, or values; supports remove().
        // - Use Case: When you need to modify the map during iteration.
        System.out.println("\nUsing Iterator over entrySet:");
        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
            // Example: Remove "Bob" during iteration
            if ("Bob".equals(entry.getKey())) {
                entryIterator.remove();
            }
        }
        System.out.println("Map after removing Bob: " + map); // Output: {Alice=85, Charlie=88}

        // Restore map
        map = new HashMap<>();
        map.put("Alice", 85);
        map.put("Bob", 92);
        map.put("Charlie", 88);

        // 2. Enhanced for loop (over entrySet, keySet, or values)
        // - Simple for read-only access to entries, keys, or values.
        System.out.println("\nUsing Enhanced for loop over entrySet:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 3. forEach() with lambda expression
        // - Functional-style iteration for Map; uses BiConsumer for key-value pairs.
        System.out.println("\nUsing forEach with lambda:");
        map.forEach((key, value) -> System.out.println(key + ": " + value));

        // 4. Stream API (over entrySet, keySet, or values)
        // - Powerful for processing Map elements with filtering and transformation.
        System.out.println("\nUsing Stream API over entrySet:");
        map.entrySet().stream()
                .filter(entry -> entry.getValue() > 90)
                .map(entry -> entry.getKey().toUpperCase() + ": " + entry.getValue())
                .forEach(System.out::println); // Output: BOB: 92
    }
}
