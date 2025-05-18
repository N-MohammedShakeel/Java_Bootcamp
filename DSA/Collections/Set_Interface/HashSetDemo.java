package Java_Bootcamp.DSA.Collections.Set_Interface;

import java.util.HashSet;
import java.util.Set;

// Class to demonstrate HashSet
class HashSetDemo {
    // HashSet: Uses a hash table (based on HashMap) as the underlying data structure.
    // Key Features:
    // - Unordered: Elements are not stored in any specific order.
    // - Uses hashing: Fast average-case performance (O(1) for add, remove, contains).
    // - Allows one null element.
    // - Non-synchronized, not thread-safe by default.
    // - Initial capacity and load factor can be specified (default: 16, 0.75).
    // - Use Case: Ideal for scenarios requiring fast lookups and no duplicates (e.g., storing unique user IDs).

    public static void demonstrate() {
        System.out.println("=== HashSet Demonstration ===");

        // Create a HashSet
        Set<String> hashSet = new HashSet<>();

        // Add elements
        hashSet.add("Apple"); // Adds to the set
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Apple"); // Duplicate, ignored
        hashSet.add(null); // Null allowed
        hashSet.add("Mango");

        // Print the set
        System.out.println("HashSet: " + hashSet); // Output: [null, Apple, Mango, Banana, Orange] (order may vary)

        // Check for element
        System.out.println("Contains Banana? " + hashSet.contains("Banana")); // Output: true
        System.out.println("Contains null? " + hashSet.contains(null)); // Output: true

        // Remove element
        hashSet.remove("Orange");
        System.out.println("After removing Orange: " + hashSet); // Output: [null, Apple, Mango, Banana] (order may vary)

        // Size
        System.out.println("Size: " + hashSet.size()); // Output: 4

        // Iterate over the set
        System.out.println("Iterating over HashSet:");
        for (String item : hashSet) {
            System.out.println(item);
        }
    }
}
