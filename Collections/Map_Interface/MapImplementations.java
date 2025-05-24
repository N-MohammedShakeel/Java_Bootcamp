package Java_Bootcamp.Collections.Map_Interface;

// Common Collection Classes: Map Implementations
// Objective: Understand the implementation classes for the Map interface and their use cases.

// The Map interface (java.util.Map) represents a collection of key-value pairs, where each key is unique.
// Implementations differ in ordering, performance, null handling, and thread-safety.

// Overview of Map Implementations:
// 1. HashMap: Unordered, uses hashing, allows one null key and multiple null values.
// 2. LinkedHashMap: Maintains insertion order, uses hashing, allows one null key and multiple null values.
// 3. TreeMap: Sorted by keys, uses a red-black tree, does not allow null keys.
// 4. Hashtable: Synchronized, legacy class, does not allow null keys or values.

// This code demonstrates each Map implementation in separate classes for clarity.

// Main class to run all Map implementation demonstrations
public class MapImplementations {
    public static void main(String[] args) {
        // Run HashMap demonstration
        HashMapDemo.demonstrate();
        
        // Run LinkedHashMap demonstration
        LinkedHashMapDemo.demonstrate();
        
        // Run TreeMap demonstration
        TreeMapDemo.demonstrate();
        
        // Run Hashtable demonstration
        HashtableDemo.demonstrate();
    }
}