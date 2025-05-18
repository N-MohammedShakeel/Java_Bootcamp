package Java_Bootcamp.DSA.Collections.SortingSearchingInCollections;

// Sorting and Searching in Collections
// Objective: Understand how to order and search elements in collections.

// Sorting involves arranging elements in a specific order (e.g., ascending, descending).
// Searching involves locating elements within a collection efficiently.
// Java provides utility methods and interfaces to facilitate these operations.

// Overview of Topics:
// Sorting:
// 1. Collections.sort(): Sorts a List in natural order or using a Comparator.
// 2. Comparable Interface: Defines natural ordering for objects (used by Collections.sort(), TreeSet, TreeMap).
// 3. Comparator: Provides custom sorting logic, independent of natural ordering.
// 4. TreeSet/TreeMap: Automatically maintain sorted order (using Comparable or Comparator).
// Searching:
// 1. Collections.binarySearch(): Efficiently searches sorted Lists (O(log n)).
// 2. contains()/indexOf(): Linear search for unsorted collections (O(n)).

// This code demonstrates sorting and searching on List, TreeSet, and TreeMap.

// Main class to run all sorting and searching demonstrations
public class SortingSearchingCollections {
    public static void main(String[] args) {
        // Run sorting demonstration
        SortingDemo.demonstrate();
        
        // Run searching demonstration
        SearchingDemo.demonstrate();
    }
}