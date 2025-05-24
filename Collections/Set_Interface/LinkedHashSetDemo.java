package Java_Bootcamp.Collections.Set_Interface;

import java.util.LinkedHashSet;
import java.util.Set;

// Class to demonstrate LinkedHashSet
class LinkedHashSetDemo {
    // LinkedHashSet: Extends HashSet, uses a hash table with a doubly-linked list to maintain insertion order.
    // Key Features:
    // - Maintains insertion order: Elements are returned in the order they were added.
    // - Uses hashing: Same performance as HashSet (O(1) for add, remove, contains).
    // - Allows one null element.
    // - Non-synchronized, not thread-safe by default.
    // - Slightly higher memory overhead than HashSet due to linked list.
    // - Use Case: Ideal when order of insertion matters (e.g., maintaining a log of unique events).

    public static void demonstrate() {
        System.out.println("\n=== LinkedHashSet Demonstration ===");

        // Create a LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // Add elements
        linkedHashSet.add("Dog"); // Adds to the set
        linkedHashSet.add("Cat");
        linkedHashSet.add("Bird");
        linkedHashSet.add("Dog"); // Duplicate, ignored
        linkedHashSet.add(null); // Null allowed
        linkedHashSet.add("Fish");

        // Print the set
        System.out.println("LinkedHashSet: " + linkedHashSet); // Output: [Dog, Cat, Bird, null, Fish]

        // Check for element
        System.out.println("Contains Cat? " + linkedHashSet.contains("Cat")); // Output: true
        System.out.println("Contains null? " + linkedHashSet.contains(null)); // Output: true

        // Remove element
        linkedHashSet.remove("Bird");
        System.out.println("After removing Bird: " + linkedHashSet); // Output: [Dog, Cat, null, Fish]

        // Size
        System.out.println("Size: " + linkedHashSet.size()); // Output: 4

        // Iterate over the set (maintains insertion order)
        System.out.println("Iterating over LinkedHashSet:");
        for (String item : linkedHashSet) {
            System.out.println(item);
        }
    }
}
