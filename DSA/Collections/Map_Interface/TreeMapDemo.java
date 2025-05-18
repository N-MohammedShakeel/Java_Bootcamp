package Java_Bootcamp.DSA.Collections.Map_Interface;

import java.util.Map;
import java.util.TreeMap;

// Class to demonstrate TreeMap
class TreeMapDemo {
    // TreeMap: Uses a red-black tree (balanced binary search tree) as the underlying data structure.
    // Key Features:
    // - Sorted: Keys are stored in natural order or by a custom Comparator.
    // - O(log n) for put, get, remove due to tree operations.
    // - Does not allow null keys (throws NullPointerException), but allows null values.
    // - Non-synchronized, not thread-safe by default.
    // - Keys must implement Comparable or be provided with a Comparator.
    // - Use Case: Ideal for maintaining a sorted map (e.g., a dictionary sorted by keys).

    public static void demonstrate() {
        System.out.println("\n=== TreeMap Demonstration ===");

        // Create a TreeMap
        Map<String, Integer> treeMap = new TreeMap<>();

        // Add key-value pairs
        treeMap.put("Zebra", 50); // Adds key-value pair
        treeMap.put("Apple", 30);
        treeMap.put("Mango", 40);
        treeMap.put("Apple", 35); // Updates value for existing key
        treeMap.put("Banana", null); // Null value allowed
        // treeMap.put(null, 60); // Would throw NullPointerException

        // Print the map
        System.out.println("TreeMap: " + treeMap); // Output: {Apple=35, Banana=null, Mango=40, Zebra=50} (sorted by keys)

        // Access value by key
        System.out.println("Mango's value: " + treeMap.get("Mango")); // Output: 40

        // Check for key
        System.out.println("Contains key Apple? " + treeMap.containsKey("Apple")); // Output: true

        // Remove key-value pair
        treeMap.remove("Zebra");
        System.out.println("After removing Zebra: " + treeMap); // Output: {Apple=35, Banana=null, Mango=40}

        // Size
        System.out.println("Size: " + treeMap.size()); // Output: 3

        // Iterate over entries (sorted by keys)
        System.out.println("Iterating over TreeMap:");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Demonstrate TreeMap-specific methods
        System.out.println("First key: " + ((TreeMap<String, Integer>) treeMap).firstKey()); // Output: Apple
        System.out.println("Last key: " + ((TreeMap<String, Integer>) treeMap).lastKey()); // Output: Mango
    }
}
