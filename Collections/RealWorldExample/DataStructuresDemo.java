package Java_Bootcamp.Collections.RealWorldExample;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// Class to demonstrate implementing data structures
class DataStructuresDemo {
    // Real-World Use Case: Implementing stacks and queues using collections.
    // - Stack: LIFO (Last-In-First-Out) for undo functionality.
    // - Queue: FIFO (First-In-First-Out) for task scheduling.

    public static void demonstrate() {
        System.out.println("\n=== Data Structures Demonstration ===");

        // Stack (using ArrayDeque)
        Deque<String> stack = new ArrayDeque<>();
        // Simulate undo functionality (e.g., text editor actions)
        stack.push("Typed 'Hello'");
        stack.push("Typed 'World'");
        stack.push("Bolded text");

        System.out.println("Stack (Undo History):");
        stack.forEach(System.out::println);

        // Undo last action
        String lastAction = stack.pop();
        System.out.println("\nUndo: " + lastAction);
        System.out.println("Stack after undo: " + stack);

        // Queue (using ArrayDeque)
        Queue<String> queue = new ArrayDeque<>();
        // Simulate task scheduling (e.g., print jobs)
        queue.offer("Print Document1.pdf");
        queue.offer("Print Document2.pdf");
        queue.offer("Print Document3.pdf");

        System.out.println("\nQueue (Print Jobs):");
        queue.forEach(System.out::println);

        // Process next task
        String nextTask = queue.poll();
        System.out.println("\nProcessing: " + nextTask);
        System.out.println("Queue after processing: " + queue);
    }
}
