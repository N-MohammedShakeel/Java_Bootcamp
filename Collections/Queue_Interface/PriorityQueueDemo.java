package Java_Bootcamp.Collections.Queue_Interface;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// Class to demonstrate PriorityQueue
class PriorityQueueDemo {
    // PriorityQueue: Uses a binary heap (min-heap by default) as the underlying data structure.
    // Key Features:
    // - Orders elements based on natural ordering (e.g., smallest first for numbers) or a custom Comparator.
    // - O(log n) for offer, poll, and remove operations; O(1) for peek.
    // - Allows duplicates but does not allow null elements (throws NullPointerException).
    // - Non-synchronized, not thread-safe by default.
    // - Initial capacity can be specified (default: 11); grows dynamically.
    // - Use Case: Ideal for priority-based processing (e.g., task scheduling, Dijkstra's algorithm).

    public static void demonstrate() {
        System.out.println("=== PriorityQueue Demonstration ===");

        // Create a PriorityQueue (min-heap, smallest element first)
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        // Add elements
        priorityQueue.offer(30); // Adds to the heap, maintains heap property
        priorityQueue.offer(10);
        priorityQueue.offer(20);
        priorityQueue.offer(10); // Duplicates allowed
        // priorityQueue.offer(null); // Would throw NullPointerException

        // Print the queue
        System.out.println("PriorityQueue: " + priorityQueue); // Output: [10, 10, 20, 30] (heap order, not strictly sorted)

        // Peek at the head (smallest element)
        System.out.println("Peek: " + priorityQueue.peek()); // Output: 10

        // Remove and return the head
        System.out.println("Poll: " + priorityQueue.poll()); // Output: 10 (removes smallest)
        System.out.println("PriorityQueue after poll: " + priorityQueue); // Output: [10, 30, 20]

        // Size
        System.out.println("Size: " + priorityQueue.size()); // Output: 3

        // Iterate over the queue (order not guaranteed)
        System.out.println("Iterating over PriorityQueue:");
        for (Integer item : priorityQueue) {
            System.out.println(item);
        }

        // Demonstrate PriorityQueue with custom Comparator (max-heap, largest first)
        Queue<Integer> maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        maxPriorityQueue.offer(30);
        maxPriorityQueue.offer(10);
        maxPriorityQueue.offer(20);
        System.out.println("Max PriorityQueue: " + maxPriorityQueue); // Output: [30, 10, 20] (heap order)
        System.out.println("Peek (max): " + maxPriorityQueue.peek()); // Output: 30
    }

    public static void main(String[] args) {
        PriorityQueueDemo.demonstrate();
    }
}
