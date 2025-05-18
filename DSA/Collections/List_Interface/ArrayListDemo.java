package Java_Bootcamp.DSA.Collections.List_Interface;

import java.util.ArrayList;
import java.util.List;

// Class to demonstrate ArrayList
class ArrayListDemo {
    // ArrayList: Uses a dynamic array as the underlying data structure.
    // Key Features:
    // - Fast random access (O(1) for get/set operations).
    // - Slow for insertions/deletions in the middle (O(n) due to array shifting).
    // - Non-synchronized, not thread-safe by default.
    // - Initial capacity can be specified; grows by 50% when full.
    // - Use Case: Ideal for frequent read operations and when random access is needed (e.g., storing a list of items for display).

    public static void demonstrate() {
        System.out.println("=== ArrayList Demonstration ===");

        // Create an ArrayList with default initial capacity (10)
        List<String> arrayList = new ArrayList<>();

        // Add elements
        arrayList.add("Apple"); // Adds at the end
        arrayList.add("Banana");
        arrayList.add("Orange");
        arrayList.add(1, "Mango"); // Adds at index 1, shifts elements
        arrayList.add("Apple"); // Duplicates allowed

        // Print the list
        System.out.println("ArrayList: " + arrayList); // Output: [Apple, Mango, Banana, Orange, Apple]

        // Access element by index (fast due to array structure)
        System.out.println("Element at index 2: " + arrayList.get(2)); // Output: Banana

        // Replace element
        arrayList.set(2, "Grape");
        System.out.println("After set(2, Grape): " + arrayList); // Output: [Apple, Mango, Grape, Orange, Apple]

        // Remove element
        arrayList.remove("Orange");
        System.out.println("After removing Orange: " + arrayList); // Output: [Apple, Mango, Grape, Apple]

        // Size and check for element
        System.out.println("Size: " + arrayList.size()); // Output: 4
        System.out.println("Contains Mango? " + arrayList.contains("Mango")); // Output: true

        // Iterate over the list
        System.out.println("Iterating over ArrayList:");
        for (String item : arrayList) {
            System.out.println(item);
        }
    }
}