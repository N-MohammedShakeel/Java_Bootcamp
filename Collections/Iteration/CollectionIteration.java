package Java_Bootcamp.Collections.Iteration;

// Iterating Over Collections
// Objective: Learn different ways to traverse collections.

// Iteration is the process of accessing each element in a collection.
// Java provides multiple methods to iterate over collections, each with specific features and use cases.

// Overview of Iteration Methods:
// 1. Iterator: General-purpose iterator for all Collection types; supports removal during iteration.
// 2. ListIterator: Specialized iterator for List; supports bidirectional traversal and modification.
// 3. Enhanced for loop (for-each): Simple, readable syntax for sequential access; no modification support.
// 4. forEach() method (Java 8+): Uses lambda expressions for functional-style iteration; concise but limited to read operations.
// 5. Stream API (Java 8+): Functional-style iteration with powerful operations like filter, map, and reduce.

// This code demonstrates each iteration method on List, Set, and Map collections.

// Main class to run all iteration demonstrations
public class CollectionIteration {
    public static void main(String[] args) {
        // Run List iteration demonstration
        ListIterationDemo.demonstrate();
        
        // Run Set iteration demonstration
        SetIterationDemo.demonstrate();
        
        // Run Map iteration demonstration
        MapIterationDemo.demonstrate();
    }
}