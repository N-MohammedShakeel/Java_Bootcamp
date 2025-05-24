package Java_Bootcamp.Collections.UtilityMethodsInCollections;

// Utility Methods in Collections Class
// Objective: Explore the Collections utility class for common operations.

// The Collections class (java.util.Collections) is a utility class providing static methods
// to operate on or return collections. These methods simplify common tasks like sorting,
// reversing, and synchronizing collections.

// Overview of Topics:
// 1. General Utility Methods:
//    - reverse(): Reverses the order of elements in a List.
//    - shuffle(): Randomly permutes elements in a List.
//    - swap(): Swaps two elements in a List at specified indices.
//    - fill(): Replaces all elements in a List with a specified value.
//    - copy(): Copies elements from one List to another.
//    - min()/max(): Returns the minimum/maximum element in a Collection (uses Comparable or Comparator).
// 2. Synchronized Collections:
//    - Collections.synchronizedList(): Returns a thread-safe List.
//    - Collections.synchronizedMap(): Returns a thread-safe Map.
// 3. Unmodifiable Collections:
//    - Collections.unmodifiableList(): Returns a read-only view of a List.
//    - Collections.unmodifiableSet()/unmodifiableMap(): Returns read-only views of Set/Map.

// This code demonstrates these methods on List, Set, and Map collections.

// Main class to run all Collections utility method demonstrations
public class CollectionsUtilityDemo {
    public static void main(String[] args) {
        // Run general utility methods demonstration
        GeneralUtilityMethods.demonstrate();
        
        // Run synchronized collections demonstration
        SynchronizedCollections.demonstrate();
        
        // Run unmodifiable collections demonstration
        UnmodifiableCollections.demonstrate();
    }
}