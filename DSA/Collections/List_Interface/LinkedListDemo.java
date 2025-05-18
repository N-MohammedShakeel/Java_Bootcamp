package Java_Bootcamp.DSA.Collections.List_Interface;

import java.util.LinkedList;
import java.util.List;

// Class to demonstrate LinkedList
class LinkedListDemo {
    // LinkedList: Uses a doubly-linked list as the underlying data structure.
    // Key Features:
    // - Efficient for insertions/deletions (O(1) at known positions, but finding position is O(n)).
    // - Slow for random access (O(n) to traverse to the index).
    // - Non-synchronized, not thread-safe by default.
    // - Implements both List and Deque interfaces, supporting queue/deque operations.
    // - Use Case: Ideal for frequent insertions/deletions or when queue/deque functionality is needed (e.g., task scheduling).

    public static void demonstrate() {
        System.out.println("\n=== LinkedList Demonstration ===");

        // Create a LinkedList
        List<String> linkedList = new LinkedList<>();

        // Add elements
        linkedList.add("Dog"); // Adds at the end
        linkedList.add("Cat");
        linkedList.add("Bird");
        linkedList.add(1, "Fish"); // Adds at index 1, adjusts links
        linkedList.add("Dog"); // Duplicates allowed

        // Print the list
        System.out.println("LinkedList: " + linkedList); // Output: [Dog, Fish, Cat, Bird, Dog]

        // Access element by index (slower due to traversal)
        System.out.println("Element at index 2: " + linkedList.get(2)); // Output: Cat

        // Replace element
        linkedList.set(2, "Mouse");
        System.out.println("After set(2, Mouse): " + linkedList); // Output: [Dog, Fish, Mouse, Bird, Dog]

        // Remove element
        linkedList.remove("Bird");
        System.out.println("After removing Bird: " + linkedList); // Output: [Dog, Fish, Mouse, Dog]

        // Size and check for element
        System.out.println("Size: " + linkedList.size()); // Output: 4
        System.out.println("Contains Fish? " + linkedList.contains("Fish")); // Output: true

        // Demonstrate Deque functionality (LinkedList implements Deque)
        LinkedList<String> deque = (LinkedList<String>) linkedList;
        deque.addFirst("Wolf");
        System.out.println("After addFirst(Wolf): " + linkedList); // Output: [Wolf, Dog, Fish, Mouse, Dog]
    }
}