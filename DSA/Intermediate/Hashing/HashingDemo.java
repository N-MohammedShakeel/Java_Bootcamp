package Java_Bootcamp.DSA.Intermediate.Hashing;

/*
 * 🔐 What is Hashing?
 * -------------------
 * Hashing is a technique to map data (keys) to fixed-size indices (buckets) in a data structure
 * using a hash function, enabling fast retrieval, insertion, and deletion.
 *
 * 📦 Key Components:
 * ------------------
 * 1. Hash Function:
 *    - Maps keys to indices (e.g., hash(key) % tableSize).
 *    - A good hash function minimizes collisions and distributes keys uniformly.
 *
 * 2. Hash Table:
 *    - An array where each index (bucket) stores key-value pairs or a linked list (in case of collisions).
 *
 * 3. Collisions:
 *    - Occur when multiple keys map to the same index.
 *    - Resolved using:
 *      a. Chaining: Store multiple keys in a linked list at the same index.
 *      b. Open Addressing: Use probing (linear, quadratic) to find the next available slot.
 *
 * ☕ Java-Specific Notes:
 * -----------------------
 * - Java provides: HashMap, HashSet, Hashtable.
 * - HashMap is most commonly used due to its flexibility and efficiency.
 *
 * ✅ Advantages:
 * --------------
 * - Average time complexity: O(1) for insertion, deletion, and lookup.
 * - Efficient for problems like frequency counting, checking duplicates, or mapping relationships.
 *
 * ❌ Disadvantages:
 * ------------------
 * - Worst-case time complexity: O(n) if many collisions occur.
 * - Requires a good hash function and sufficient table size to minimize collisions.
 *
 * 🧠 Applications:
 * ----------------
 * - Counting frequencies (e.g., element occurrences in an array).
 * - Finding duplicates or unique elements.
 * - Solving subarray problems (e.g., subarray with given sum).
 * - Implementing data structures like dictionaries or caches.
 *
 * 🔧 Key Operations:
 * ------------------
 * - Insert: Add a key-value pair to the hash table.
 * - Search: Check if a key exists or retrieve its value.
 * - Delete: Remove a key-value pair.
 * - Collision Handling:
 *   - Java’s HashMap uses chaining (linked lists or red-black trees for high collisions).
 *
 * 📊 Time and Space Complexity:
 * ------------------------------
 * - Average Case:
 *   - Insert/Search/Delete: O(1) with a good hash function.
 *
 * - Worst Case (many collisions):
 *   - Insert/Search/Delete: O(n) for chaining or open addressing.
 *
 * - Space Complexity:
 *   - O(n) for storing n key-value pairs.
 *   - Additional space for collision handling (e.g., linked lists in chaining).
 *
 * 🗂 Java’s HashMap:
 * -------------------
 * - Stores key-value pairs, allowing null keys/values.
 * - Common Methods:
 *   - put(key, value)       // Inserts or updates a key-value pair in the map.
 *   - get(key)              // Retrieves the value associated with the specified key.
 *   - remove(key)           // Deletes the key-value pair from the map.
 *   - containsKey(key)      // Checks if the map contains the specified key.
 *   - size()                // Returns the number of key-value pairs in the map.
 *   - keySet(), values()    // Returns a set of all keys or a collection of all values in the map.
 *
 * - Internals:
 *   - Uses an array of buckets.
 *   - Handles collisions using chaining.
 *   - Switches to a red-black tree if a bucket’s linked list exceeds a threshold.
 */


// Hashing Demonstration in Java
// This program shows:
// 1. Using Java's HashMap for basic operations (insert, search, delete).
// 2. A custom hash table implementation with chaining to handle collisions.
// 3. Example usage for frequency counting and duplicate detection.

// Time Complexity (HashMap):
// - Insert (put): O(1) average, O(n) worst case (many collisions).
// - Search (get): O(1) average, O(n) worst case.
// - Delete (remove): O(1) average, O(n) worst case.
// Space Complexity: O(n) for storing n key-value pairs.

// Custom Hash Table Time Complexity:
// - Insert/Search/Delete: O(1) average, O(n) worst case (due to collisions in a single bucket).
// Space Complexity: O(n) for keys + linked lists for collisions.

import java.util.*;

public class HashingDemo {
    public static void main(String[] args) {
        // Part 1: Using Java's HashMap
        System.out.println("=== Using Java's HashMap ===");
        HashMap<Integer, String> hashMap = new HashMap<>();
        
        // Insert key-value pairs
        hashMap.put(1, "Apple");
        hashMap.put(2, "Banana");
        hashMap.put(3, "Cherry");
        System.out.println("HashMap after inserts: " + hashMap);
        
        // Search for a key
        System.out.println("Value for key 2: " + hashMap.get(2)); // Banana
        System.out.println("Contains key 4? " + hashMap.containsKey(4)); // false
        
        // Delete a key
        hashMap.remove(1);
        System.out.println("HashMap after removing key 1: " + hashMap);
        
        // Example: Frequency counting
        int[] arr = {1, 2, 2, 3, 1, 4};
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Frequency of elements: " + freqMap);
        
        // Part 2: Custom Hash Table with Chaining
        System.out.println("\n=== Custom Hash Table with Chaining ===");
        CustomHashTable customTable = new CustomHashTable(5);
        customTable.insert(1, "One");
        customTable.insert(6, "Six"); // Collision with 1 (1%5 = 6%5 = 1)
        customTable.insert(2, "Two");
        customTable.display();
        
        System.out.println("Value for key 6: " + customTable.search(6)); // Six
        customTable.delete(1);
        System.out.println("After deleting key 1:");
        customTable.display();
    }
}

// Custom Hash Table Implementation with Chaining
class CustomHashTable {
    private class Node {
        int key;
        String value;
        Node next;
        Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private Node[] table;
    private int size;
    
    public CustomHashTable(int size) {
        this.table = new Node[size];
        this.size = size;
    }
    
    // Hash function: key % size
    private int hash(int key) {
        return key % size;
    }
    
    // Insert key-value pair
    public void insert(int key, String value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            // Handle collision: add to the end of the linked list
            Node current = table[index];
            while (current.next != null) {
                if (current.key == key) {
                    current.value = value; // Update value if key exists
                    return;
                }
                current = current.next;
            }
            if (current.key == key) {
                current.value = value;
            } else {
                current.next = newNode;
            }
        }
    }
    
    // Search for a key
    public String search(int key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }
    
    // Delete a key
    public void delete(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;
        
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    
    // Display hash table
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = table[i];
            while (current != null) {
                System.out.print("(" + current.key + ", " + current.value + ") ");
                current = current.next;
            }
            System.out.println();
        }
    }
}