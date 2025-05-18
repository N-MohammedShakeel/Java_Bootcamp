package Java_Bootcamp.DSA.Collections.Queue_Interface;

// Common Collection Classes: Queue/Deque Implementations
// Objective: Understand the implementation classes for the Queue and Deque interfaces and their use cases.

// The Queue interface (java.util.Queue) represents a collection designed for holding elements prior to processing,
// typically following FIFO (First-In-First-Out) or priority-based ordering.
// The Deque interface (java.util.Deque) extends Queue, supporting operations at both ends (double-ended queue).

// Overview of Queue/Deque Implementations:
// 1. PriorityQueue: Based on a priority heap, orders elements by natural ordering or a Comparator.
// 2. ArrayDeque: Resizable double-ended queue, uses a circular array for efficient operations at both ends.

// This code demonstrates each implementation in separate classes for clarity.

// Main class to run all Queue/Deque implementation demonstrations
public class QueueDequeImplementations {
    public static void main(String[] args) {
        // Run PriorityQueue demonstration
        PriorityQueueDemo.demonstrate();
        
        // Run ArrayDeque demonstration
        ArrayDequeDemo.demonstrate();
    }
}