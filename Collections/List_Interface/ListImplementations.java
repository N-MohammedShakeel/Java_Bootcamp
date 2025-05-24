package Java_Bootcamp.Collections.List_Interface;

// Common Collection Classes: List Implementations
// Objective: Understand the implementation classes for the List interface and their use cases.

// The List interface (java.util.List) represents an ordered collection that allows duplicates.
// Implementations provide different performance characteristics and features based on their underlying data structures.

// Overview of List Implementations:
// 1. ArrayList: Dynamic array, fast random access, non-synchronized.
// 2. LinkedList: Doubly-linked list, efficient for insertions/deletions, non-synchronized.
// 3. Vector: Synchronized, legacy class, similar to ArrayList but thread-safe.

// This code demonstrates each List implementation in separate classes for clarity.

// Main class to run all List implementation demonstrations
public class ListImplementations {
    public static void main(String[] args) {
        // Run ArrayList demonstration
        ArrayListDemo.demonstrate();

        // Run LinkedList demonstration
        LinkedListDemo.demonstrate();

        // Run Vector demonstration
        VectorDemo.demonstrate();
    }
}