package Java_Bootcamp.DSA.Collections;

import java.util.*;

// Introduction to Java Collections Framework (JCF)
// Objective: Understand the basics and purpose of the Collections Framework.

// The Java Collections Framework (JCF) is a set of classes and interfaces in the java.util package
// that provides a standardized way to manage groups of objects (collections).
// It offers data structures like lists, sets, maps, queues, and deques for efficient data management.

// Why use collections?
// 1. Dynamic size: Unlike arrays, collections can grow or shrink dynamically.
// 2. Built-in methods: Provides utility methods for searching, sorting, and manipulation.
// 3. Type safety: Generics ensure compile-time type checking.
// 4. Flexibility: Supports various data structures for different use cases.

// Collections Framework Hierarchy:
// - Collection (interface): Root interface for most collections (except Map).
//   - List: Ordered, allows duplicates (e.g., ArrayList, LinkedList).
//   - Set: No duplicates, may be unordered or sorted (e.g., HashSet, TreeSet).
//   - Queue: Ordered for processing, FIFO or priority-based (e.g., PriorityQueue).
//   - Deque: Double-ended queue, supports adding/removing from both ends (e.g., ArrayDeque).
// - Map (interface): Key-value pairs, no duplicate keys (e.g., HashMap, TreeMap).

// Key Interfaces:
// - Collection: Defines basic methods like add(), remove(), size(), isEmpty().
// - List: Extends Collection, adds positional access (get(), set(), indexOf()).
// - Set: Extends Collection, ensures no duplicates.
// - Map: Key-value storage, methods like put(), get(), keySet(), entrySet().
// - Queue: For holding elements prior to processing, methods like offer(), poll(), peek().
// - Deque: Extends Queue, supports operations at both ends (addFirst(), addLast()).

// Common Classes:
// - ArrayList: Dynamic array, fast random access, non-synchronized.
// - LinkedList: Doubly-linked list, efficient for insertions/deletions.
// - HashSet: Unordered set, uses hashing, allows one null.
// - TreeSet: Sorted set, based on red-black tree, no nulls.
// - HashMap: Unordered key-value pairs, allows one null key.
// - TreeMap: Sorted key-value pairs, no null keys.
// - PriorityQueue: Queue based on priority heap, orders elements by natural ordering or comparator.
// - ArrayDeque: Resizable double-ended queue, efficient for adding/removing at both ends.

// Difference between Collections and Collection:
// - Collection: An interface in java.util, the root for most collection types.
// - Collections: A utility class in java.util with static methods (e.g., sort(), reverse()).


public class IntroToCollections {
    public static void main(String[] args) {
        // Example 1: Using ArrayList (List implementation)
        // ArrayList is a resizable array, ideal for dynamic lists with fast random access.
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");  // Adds at the end
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");  // List allows duplicates

        // Print the list and demonstrate basic operations
        System.out.println("Fruits List: " + fruits); // Output: [Apple, Banana, Orange, Apple]
        System.out.println("First fruit: " + fruits.get(0)); // Output: Apple
        System.out.println("Size of list: " + fruits.size()); // Output: 4
        System.out.println("Contains Banana? " + fruits.contains("Banana")); // Output: true

        // Iterate using enhanced for loop
        System.out.println("Iterating over fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Example 2: Using HashSet (Set implementation)
        // HashSet is unordered, prevents duplicates, uses hashing.
        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // Duplicate, ignored
        numbers.add(30);

        // Print the set and demonstrate operations
        System.out.println("\nNumbers Set: " + numbers); // Output: [20, 10, 30] (order may vary)
        System.out.println("Contains 20? " + numbers.contains(20)); // Output: true
        numbers.remove(20);
        System.out.println("After removing 20: " + numbers); // Output: [10, 30] (order may vary)

        // Example 3: Using HashMap (Map implementation)
        // HashMap stores key-value pairs, allows one null key, unordered.
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 85); // Add key-value pair
        studentScores.put("Bob", 92);
        studentScores.put("Alice", 88); // Updates value for existing key
        studentScores.put("Charlie", 95);

        // Print the map and demonstrate operations
        System.out.println("\nStudent Scores Map: " + studentScores); // Output: {Alice=88, Bob=92, Charlie=95}
        System.out.println("Alice's score: " + studentScores.get("Alice")); // Output: 88
        System.out.println("Contains key Bob? " + studentScores.containsKey("Bob")); // Output: true
        System.out.println("Size of map: " + studentScores.size()); // Output: 3

        // Iterate over map entries
        System.out.println("Iterating over student scores:");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Example 4: Using PriorityQueue (Queue implementation)
        // PriorityQueue orders elements by natural ordering or comparator, FIFO for equal priority.
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(30); // Add elements
        priorityQueue.offer(10);
        priorityQueue.offer(20);
        priorityQueue.offer(10); // Duplicates allowed

        // Print the queue and demonstrate operations
        System.out.println("\nPriority Queue: " + priorityQueue); // Output: [10, 10, 20, 30] (heap order)
        System.out.println("Peek first element: " + priorityQueue.peek()); // Output: 10 (smallest)
        System.out.println("Poll first element: " + priorityQueue.poll()); // Output: 10 (removes smallest)
        System.out.println("Queue after poll: " + priorityQueue); // Output: [10, 30, 20]

        // Example 5: Using ArrayDeque (Deque implementation)
        // ArrayDeque is a double-ended queue, efficient for adding/removing at both ends.
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("First"); // Add at front
        deque.addLast("Last");  // Add at end
        deque.offerFirst("NewFirst"); // Add at front
        deque.offerLast("NewLast");  // Add at end

        // Print the deque and demonstrate operations
        System.out.println("\nDeque: " + deque); // Output: [NewFirst, First, Last, NewLast]
        System.out.println("Peek first: " + deque.peekFirst()); // Output: NewFirst
        System.out.println("Peek last: " + deque.peekLast()); // Output: NewLast
        System.out.println("Poll first: " + deque.pollFirst()); // Output: NewFirst (removes front)
        System.out.println("Deque after poll: " + deque); // Output: [First, Last, NewLast]

        // Using Collections utility class to sort the fruits list
        Collections.sort(fruits);
        System.out.println("\nSorted Fruits List: " + fruits); // Output: [Apple, Apple, Banana, Orange]
    }
}