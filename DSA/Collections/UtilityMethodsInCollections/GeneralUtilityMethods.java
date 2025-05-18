package Java_Bootcamp.DSA.Collections.UtilityMethodsInCollections;

import java.util.*;

// Class to demonstrate general utility methods
class GeneralUtilityMethods {
    // Demonstrates reverse(), shuffle(), swap(), fill(), copy(), min(), max().

    public static void demonstrate() {
        System.out.println("=== General Utility Methods Demonstration ===");

        // Create a List for demonstration
        List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Mango"));
        System.out.println("Original List: " + list);

        // 1. reverse()
        // - Reverses the order of elements in a List (in-place).
        // - Use Case: Reordering a list for display (e.g., reverse chronological order).
        Collections.reverse(list);
        System.out.println("After reverse(): " + list); // Output: [Mango, Orange, Banana, Apple]

        // 2. shuffle()
        // - Randomly permutes elements in a List (in-place).
        // - Use Case: Randomizing items (e.g., shuffling a deck of cards).
        Collections.shuffle(list);
        System.out.println("After shuffle(): " + list); // Output: Random order, e.g., [Banana, Mango, Apple, Orange]

        // Restore list
        list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Mango"));

        // 3. swap()
        // - Swaps elements at specified indices in a List (in-place).
        // - Use Case: Reordering specific elements (e.g., swapping items in a playlist).
        Collections.swap(list, 1, 3);
        System.out.println("After swap(1, 3): " + list); // Output: [Apple, Mango, Orange, Banana]

        // 4. fill()
        // - Replaces all elements in a List with a specified value (in-place).
        // - Use Case: Initializing a list with a default value.
        Collections.fill(list, "Lemon");
        System.out.println("After fill(Lemon): " + list); // Output: [Lemon, Lemon, Lemon, Lemon]

        // Restore list
        list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange", "Mango"));

        // 5. copy()
        // - Copies elements from a source List to a destination List (overwrites destination).
        // - Destination List must be at least as large as source List.
        // - Use Case: Creating a backup or duplicate of a List.
        List<String> destList = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        Collections.copy(destList, list);
        System.out.println("Destination List after copy(): " + destList); // Output: [Apple, Banana, Orange, Mango, E]

        // 6. min()/max()
        // - Returns the minimum/maximum element in a Collection based on natural ordering or Comparator.
        // - Use Case: Finding extrema in a collection (e.g., highest score).
        System.out.println("Min element: " + Collections.min(list)); // Output: Apple
        System.out.println("Max element: " + Collections.max(list)); // Output: Orange

        // min()/max() with custom Comparator
        Comparator<String> lengthComparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        System.out.println("Min by length: " + Collections.min(list, lengthComparator)); // Output: Apple
        System.out.println("Max by length: " + Collections.max(list, lengthComparator)); // Output: Banana
    }
}
