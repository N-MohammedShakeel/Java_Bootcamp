package Java_Bootcamp.DSA.Collections;

// Core Interfaces in the Java Collections Framework
// Objective: Learn the foundational interfaces and their roles.

// The Java Collections Framework (JCF) is built on a set of core interfaces in the java.util package.
// These interfaces define the structure and behavior of collections, enabling flexible data management.
// Each interface serves a specific purpose, with methods tailored to its role.

// 1. Collection Interface
// - The root interface for most collections (except Map).
// - Represents a group of objects (elements) with no specific order or structure.
// - Key Methods:
//   - add(E e): Adds an element; returns true if the collection changed.
//   - remove(Object o): Removes an element; returns true if the collection changed.
//   - size(): Returns the number of elements.
//   - isEmpty(): Returns true if the collection is empty.
//   - contains(Object o): Returns true if the element exists.
//   - clear(): Removes all elements.
//   - iterator(): Returns an Iterator for traversing elements.
// - Used by List, Set, Queue, and Deque implementations.

// 2. List Interface
// - Extends Collection; represents an ordered collection (sequence).
// - Allows duplicates and provides positional access.
// - Key Methods:
//   - get(int index): Returns the element at the specified index.
//   - set(int index, E element): Replaces the element at the index; returns old element.
//   - indexOf(Object o): Returns the first index of the element, or -1 if not found.
//   - subList(int fromIndex, int toIndex): Returns a view of the list portion.
//   - add(int index, E element): Inserts element at the specified index.
// - Implementations: ArrayList, LinkedList, Vector.

// 3. Set Interface
// - Extends Collection; represents a collection with no duplicate elements.
// - Typically unordered (except for sorted sets like TreeSet).
// - Key Methods (inherited from Collection):
//   - add(E e): Adds an element; returns false if already present.
//   - remove(Object o): Removes the element; returns true if removed.
//   - contains(Object o): Checks if the element exists.
// - No additional methods beyond Collection, but enforces uniqueness.
// - Implementations: HashSet, LinkedHashSet, TreeSet.

// 4. Map Interface
// - Does NOT extend Collection; represents a collection of key-value pairs.
// - No duplicate keys; each key maps to exactly one value.
// - Key Methods:
//   - put(K key, V value): Associates the key with the value; returns previous value or null.
//   - get(Object key): Returns the value for the key, or null if not found.
//   - remove(Object key): Removes the key-value pair; returns the value or null.
//   - keySet(): Returns a Set of all keys.
//   - entrySet(): Returns a Set of Map.Entry objects (key-value pairs).
//   - values(): Returns a Collection of all values.
//   - containsKey(Object key): Checks if the key exists.
// - Implementations: HashMap, LinkedHashMap, TreeMap.

// 5. Queue Interface
// - Extends Collection; designed for holding elements prior to processing.
// - Typically follows FIFO (First-In-First-Out) order, but can be priority-based.
// - Key Methods:
//   - offer(E e): Adds an element if possible; returns true if successful.
//   - poll(): Removes and returns the head element, or null if empty.
//   - peek(): Returns the head element without removing it, or null if empty.
//   - add(E e): Adds an element (throws exception if capacity exceeded).
//   - remove(): Removes the head (throws exception if empty).
// - Implementations: PriorityQueue, LinkedList.

// 6. Deque Interface
// - Extends Queue; represents a double-ended queue (operations at both ends).
// - Supports adding/removing elements from both the front and back.
// - Key Methods:
//   - addFirst(E e): Adds an element at the front.
//   - addLast(E e): Adds an element at the back.
//   - offerFirst(E e): Offers an element at the front; returns true if successful.
//   - offerLast(E e): Offers an element at the back; returns true if successful.
//   - pollFirst(): Removes and returns the first element, or null if empty.
//   - pollLast(): Removes and returns the last element, or null if empty.
//   - peekFirst(): Returns the first element without removing, or null if empty.
//   - peekLast(): Returns the last element without removing, or null if empty.
// - Implementations: ArrayDeque, LinkedList.

import java.util.*; // Import java.util package for collections

public class CoreInterfaces {
    public static void main(String[] args) {
        // Example 1: Collection Interface (using ArrayList as a Collection)
        // Demonstrates basic Collection methods.
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple"); // Add elements
        collection.add("Banana");
        collection.add("Orange");
        System.out.println("Collection: " + collection); // Output: [Apple, Banana, Orange]
        System.out.println("Size: " + collection.size()); // Output: 3
        System.out.println("Contains Apple? " + collection.contains("Apple")); // Output: true
        System.out.println("Is empty? " + collection.isEmpty()); // Output: false
        collection.remove("Banana"); // Remove an element
        System.out.println("After removing Banana: " + collection); // Output: [Apple, Orange]

        // Example 2: List Interface (using ArrayList)
        // Demonstrates ordered collection with duplicates and positional access.
        List<String> list = new ArrayList<>();
        list.add("Dog"); // Add elements
        list.add("Cat");
        list.add("Dog"); // Duplicates allowed
        list.add("Bird");
        System.out.println("\nList: " + list); // Output: [Dog, Cat, Dog, Bird]
        System.out.println("Element at index 1: " + list.get(1)); // Output: Cat
        list.set(1, "Mouse"); // Replace element at index 1
        System.out.println("After set(1, Mouse): " + list); // Output: [Dog, Mouse, Dog, Bird]
        System.out.println("Index of Dog: " + list.indexOf("Dog")); // Output: 0
        List<String> subList = list.subList(1, 3); // Get sublist (index 1 to 2)
        System.out.println("SubList (index 1-2): " + subList); // Output: [Mouse, Dog]

        // Example 3: Set Interface (using HashSet)
        // Demonstrates unordered collection with no duplicates.
        Set<Integer> set = new HashSet<>();
        set.add(10); // Add elements
        set.add(20);
        set.add(10); // Duplicate ignored
        set.add(30);
        System.out.println("\nSet: " + set); // Output: [20, 10, 30] (order may vary)
        System.out.println("Contains 20? " + set.contains(20)); // Output: true
        set.remove(20); // Remove an element
        System.out.println("After removing 20: " + set); // Output: [10, 30] (order may vary)

        // Example 4: Map Interface (using HashMap)
        // Demonstrates key-value pairs with no duplicate keys.
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 85); // Add key-value pairs
        map.put("Bob", 92);
        map.put("Alice", 88); // Updates value for key Alice
        map.put("Charlie", 95);
        System.out.println("\nMap: " + map); // Output: {Alice=88, Bob=92, Charlie=95}
        System.out.println("Value for Bob: " + map.get("Bob")); // Output: 92
        System.out.println("Contains key Alice? " + map.containsKey("Alice")); // Output: true
        map.remove("Charlie"); // Remove a key-value pair
        System.out.println("After removing Charlie: " + map); // Output: {Alice=88, Bob=92}
        System.out.println("Keys: " + map.keySet()); // Output: [Alice, Bob]
        System.out.println("Values: " + map.values()); // Output: [88, 92]
        System.out.println("Entries:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        } // Output: Alice: 88, Bob: 92

        // Example 5: Queue Interface (using PriorityQueue)
        // Demonstrates FIFO or priority-based processing.
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(30); // Add elements
        queue.offer(10);
        queue.offer(20);
        queue.offer(10); // Duplicates allowed
        System.out.println("\nQueue: " + queue); // Output: [10, 10, 20, 30] (heap order)
        System.out.println("Peek: " + queue.peek()); // Output: 10 (smallest)
        System.out.println("Poll: " + queue.poll()); // Output: 10 (removes smallest)
        System.out.println("Queue after poll: " + queue); // Output: [10, 30, 20]

        // Example 6: Deque Interface (using ArrayDeque)
        // Demonstrates double-ended queue operations.
        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst("First"); // Add at front
        deque.offerLast("Last"); // Add at back
        deque.addFirst("NewFirst"); // Add at front
        deque.addLast("NewLast"); // Add at back
        System.out.println("\nDeque: " + deque); // Output: [NewFirst, First, Last, NewLast]
        System.out.println("Peek first: " + deque.peekFirst()); // Output: NewFirst
        System.out.println("Peek last: " + deque.peekLast()); // Output: NewLast
        System.out.println("Poll first: " + deque.pollFirst()); // Output: NewFirst
        System.out.println("Poll last: " + deque.pollLast()); // Output: NewLast
        System.out.println("Deque after polls: " + deque); // Output: [First, Last]
    }
}