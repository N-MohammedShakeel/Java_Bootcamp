package Java_Bootcamp.Collections.Map_Interface;

import java.util.HashMap;
import java.util.Map;

// Class to demonstrate HashMap
class HashMapDemo {
    // HashMap: Uses a hash table as the underlying data structure.
    // Key Features:
    // - Unordered: Key-value pairs are not stored in any specific order.
    // - Uses hashing: Fast average-case performance (O(1) for put, get, remove).
    // - Allows one null key and multiple null values.
    // - Non-synchronized, not thread-safe by default.
    // - Initial capacity and load factor can be specified (default: 16, 0.75).
    // - Use Case: Ideal for fast key-value lookups (e.g., caching user data).

    public static void demonstrate() {
        System.out.println("=== HashMap Demonstration ===");

        // Create a HashMap
        Map<String, Integer> hashMap = new HashMap<>();

        // Add key-value pairs
        hashMap.put("Alice", 85); // Adds key-value pair
        hashMap.put("Bob", 92);
        hashMap.put("Charlie", 88);
        hashMap.put("Alice", 90); // Updates value for existing key
        hashMap.put(null, 100); // Null key allowed
        hashMap.put("David", null); // Null value allowed

        // Print the map
        System.out.println("HashMap: " + hashMap); // Output: {null=100, Alice=90, Bob=92, Charlie=88, David=null} (order may vary)

        // Access value by key
        System.out.println("Bob's score: " + hashMap.get("Bob")); // Output: 92
        System.out.println("Null key's value: " + hashMap.get(null)); // Output: 100

        // Check for key
        System.out.println("Contains key Charlie? " + hashMap.containsKey("Charlie")); // Output: true

        // Remove key-value pair
        hashMap.remove("Charlie");
        System.out.println("After removing Charlie: " + hashMap); // Output: {null=100, Alice=90, Bob=92, David=null} (order may vary)

        // Size
        System.out.println("Size: " + hashMap.size()); // Output: 4

        // Iterate over entries
        System.out.println("Iterating over HashMap:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
