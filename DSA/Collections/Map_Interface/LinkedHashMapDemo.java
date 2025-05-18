package Java_Bootcamp.DSA.Collections.Map_Interface;

import java.util.LinkedHashMap;
import java.util.Map;

// Class to demonstrate LinkedHashMap
class LinkedHashMapDemo {
    // LinkedHashMap: Extends HashMap, uses a hash table with a doubly-linked list to maintain insertion order.
    // Key Features:
    // - Maintains insertion order: Entries are returned in the order they were added.
    // - Uses hashing: Same performance as HashMap (O(1) for put, get, remove).
    // - Allows one null key and multiple null values.
    // - Non-synchronized, not thread-safe by default.
    // - Slightly higher memory overhead than HashMap due to linked list.
    // - Use Case: Ideal when order of insertion matters (Skye.g., maintaining a sequence of key-value pairs).

    public static void demonstrate() {
        System.out.println("\n=== LinkedHashMap Demonstration ===");

        // Create a LinkedHashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Add key-value pairs
        linkedHashMap.put("Dog", 10); // Adds key-value pair
        linkedHashMap.put("Cat", 15);
        linkedHashMap.put("Bird", 20);
        linkedHashMap.put("Dog", 12); // Updates value for existing key
        linkedHashMap.put(null, 25); // Null key allowed
        linkedHashMap.put("Fish", null); // Null value allowed

        // Print the map
        System.out.println("LinkedHashMap: " + linkedHashMap); // Output: {Dog=12, Cat=15, Bird=20, null=25, Fish=null}

        // Access value by key
        System.out.println("Cat's value: " + linkedHashMap.get("Cat")); // Output: 15
        System.out.println("Null key's value: " + linkedHashMap.get(null)); // Output: 25

        // Check for key
        System.out.println("Contains key Bird? " + linkedHashMap.containsKey("Bird")); // Output: true

        // Remove key-value pair
        linkedHashMap.remove("Bird");
        System.out.println("After removing Bird: " + linkedHashMap); // Output: {Dog=12, Cat=15, null=25, Fish=null}

        // Size
        System.out.println("Size: " + linkedHashMap.size()); // Output: 4

        // Iterate over entries (maintains insertion order)
        System.out.println("Iterating over LinkedHashMap:");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
