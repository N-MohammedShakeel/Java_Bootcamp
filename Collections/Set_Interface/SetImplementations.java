package Java_Bootcamp.Collections.Set_Interface;

// Common Collection Classes: Set Implementations
// Objective: Understand the implementation classes for the Set interface and their use cases.

// The Set interface (java.util.Set) represents a collection that does not allow duplicate elements.
// Implementations differ in ordering, performance, and null handling.

// Overview of Set Implementations:
// 1. HashSet: Unordered, uses hashing, allows one null element.
// 2. LinkedHashSet: Maintains insertion order, uses hashing, allows one null element.
// 3. TreeSet: Sorted, uses a red-black tree, does not allow null elements.

// This code demonstrates each Set implementation in separate classes for clarity.

// Main class to run all Set implementation demonstrations
public class SetImplementations {
    public static void main(String[] args) {
        // Run HashSet demonstration
        HashSetDemo.demonstrate();
        
        // Run LinkedHashSet demonstration
        LinkedHashSetDemo.demonstrate();
        
        // Run TreeSet demonstration
        TreeSetDemo.demonstrate();
    }
}