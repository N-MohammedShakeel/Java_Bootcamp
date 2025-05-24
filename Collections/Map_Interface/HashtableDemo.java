package Java_Bootcamp.Collections.Map_Interface;

import java.util.Hashtable;
import java.util.Map;

// Class to demonstrate Hashtable
class HashtableDemo {
    // Hashtable: Uses a hash table, similar to HashMap, but synchronized.
    // Key Features:
    // - Synchronized, thread-safe by default (methods are synchronized).
    // - Legacy class (introduced in JDK 1.0), less efficient than HashMap due to synchronization overhead.
    // - Does not allow null keys or null values (throws NullPointerException).
    // - Initial capacity and load factor can be specified (default: 11, 0.75).
    // - Use Case: Suitable for legacy code or when thread-safety is needed without using ConcurrentHashMap (e.g., multi-threaded legacy systems).

    public static void demonstrate() {
        System.out.println("\n=== Hashtable Demonstration ===");

        // Create a Hashtable
        Map<String, Integer> hashtable = new Hashtable<>();

        // Add key-value pairs
        hashtable.put("Car", 100); // Adds key-value pair
        hashtable.put("Bus", 200);
        hashtable.put("Train", 300);
        hashtable.put("Car", 150); // Updates value for existing key
        // hashtable.put(null, 400); // Would throw NullPointerException
        // hashtable.put("Bike", null); // Would throw NullPointerException

        // Print the map
        System.out.println("Hashtable: " + hashtable); // Output: {Car=150, Bus=200, Train=300} (order may vary)

        // Access value by key
        System.out.println("Bus's value: " + hashtable.get("Bus")); // Output: 200

        // Check for key
        System.out.println("Contains key Train? " + hashtable.containsKey("Train")); // Output: true

        // Remove key-value pair
        hashtable.remove("Train");
        System.out.println("After removing Train: " + hashtable); // Output: {Car=150, Bus=200} (order may vary)

        // Size
        System.out.println("Size: " + hashtable.size()); // Output: 2

        // Iterate over entries
        System.out.println("Iterating over Hashtable:");
        for (Map.Entry<String, Integer> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
