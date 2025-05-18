package Java_Bootcamp.DSA.Collections.Queue_Interface;

import java.util.ArrayDeque;
import java.util.Deque;

// Class to demonstrate ArrayDeque
class ArrayDequeDemo {
    // ArrayDeque: Uses a resizable circular array as the underlying data structure.
    // Key Features:
    // - Double-ended queue: Efficient operations at both ends (O(1) for addFirst, addLast, pollFirst, pollLast).
    // - Faster than LinkedList for most operations due to array-based implementation.
    // - Allows duplicates but does not allow null elements (throws NullPointerException).
    // - Non-synchronized, not thread-safe by default.
    // - Initial capacity can be specified (default: 16); grows dynamically.
    // - Can be used as a queue (FIFO) or stack (LIFO).
    // - Use Case: Ideal for queue or stack operations (e.g., undo functionality, breadth-first search).

    public static void demonstrate() {
        System.out.println("\n=== ArrayDeque Demonstration ===");

        // Create an ArrayDeque
        Deque<String> arrayDeque = new ArrayDeque<>();

        // Add elements at both ends
        arrayDeque.offerFirst("First"); // Adds at front
        arrayDeque.offerLast("Last"); // Adds at back
        arrayDeque.addFirst("NewFirst"); // Adds at front
        arrayDeque.addLast("NewLast"); // Adds at back
        arrayDeque.offer("Middle"); // Adds at back (like offerLast)
        // arrayDeque.add(null); // Would throw NullPointerException

        // Print the deque
        System.out.println("ArrayDeque: " + arrayDeque); // Output: [NewFirst, First, Last, NewLast, Middle]

        // Peek at both ends
        System.out.println("Peek first: " + arrayDeque.peekFirst()); // Output: NewFirst
        System.out.println("Peek last: " + arrayDeque.peekLast()); // Output: Middle

        // Remove from both ends
        System.out.println("Poll first: " + arrayDeque.pollFirst()); // Output: NewFirst (removes front)
        System.out.println("Poll last: " + arrayDeque.pollLast()); // Output: Middle (removes back)
        System.out.println("ArrayDeque after polls: " + arrayDeque); // Output: [First, Last, NewLast]

        // Size
        System.out.println("Size: " + arrayDeque.size()); // Output: 3

        // Iterate over the deque
        System.out.println("Iterating over ArrayDeque:");
        for (String item : arrayDeque) {
            System.out.println(item);
        }

        // Demonstrate stack behavior (LIFO)
        arrayDeque.push("StackTop"); // Adds at front (like addFirst)
        System.out.println("After push(StackTop): " + arrayDeque); // Output: [StackTop, First, Last, NewLast]
        System.out.println("Pop: " + arrayDeque.pop()); // Output: StackTop (removes front)
    }
}
