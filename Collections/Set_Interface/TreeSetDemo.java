package Java_Bootcamp.Collections.Set_Interface;

import java.util.Set;
import java.util.TreeSet;

// Class to demonstrate TreeSet
class TreeSetDemo {
    // TreeSet: Uses a red-black tree (balanced binary search tree) as the underlying data structure.
    // Key Features:
    // - Sorted: Elements are stored in natural order or by a custom Comparator.
    // - O(log n) for add, remove, contains due to tree operations.
    // - Does not allow null elements (throws NullPointerException).
    // - Non-synchronized, not thread-safe by default.
    // - Elements must implement Comparable or be provided with a Comparator.
    // - Use Case: Ideal for maintaining a sorted set of elements (e.g., a leaderboard of scores).

    public static void demonstrate() {
        System.out.println("\n=== TreeSet Demonstration ===");

        // Create a TreeSet
        Set<Integer> treeSet = new TreeSet<>();

        // Add elements
        treeSet.add(30); // Adds to the set
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(10); // Duplicate, ignored
        treeSet.add(40);
        // treeSet.add(null); // Would throw NullPointerException

        // Print the set
        System.out.println("TreeSet: " + treeSet); // Output: [10, 20, 30, 40] (sorted order)

        // Check for element
        System.out.println("Contains 20? " + treeSet.contains(20)); // Output: true

        // Remove element
        treeSet.remove(30);
        System.out.println("After removing 30: " + treeSet); // Output: [10, 20, 40]

        // Size
        System.out.println("Size: " + treeSet.size()); // Output: 3

        // Iterate over the set (sorted order)
        System.out.println("Iterating over TreeSet:");
        for (Integer item : treeSet) {
            System.out.println(item);
        }

        // Demonstrate TreeSet-specific methods
        System.out.println("First element: " + ((TreeSet<Integer>) treeSet).first()); // Output: 10
        System.out.println("Last element: " + ((TreeSet<Integer>) treeSet).last()); // Output: 40
    }
}
