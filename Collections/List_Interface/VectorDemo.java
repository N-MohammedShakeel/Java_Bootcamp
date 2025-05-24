package Java_Bootcamp.Collections.List_Interface;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

// Class to demonstrate Vector
class VectorDemo {
    // Vector: Uses a dynamic array, similar to ArrayList, but synchronized.
    // Key Features:
    // - Synchronized, thread-safe by default (methods are synchronized).
    // - Legacy class (introduced in JDK 1.0), less efficient than ArrayList due to synchronization overhead.
    // - Grows by 100% when full (doubles capacity).
    // - Supports Enumeration (legacy iterator) in addition to Iterator.
    // - Use Case: Suitable for legacy code or when thread-safety is needed without using Collections.synchronizedList (e.g., multi-threaded environments).

    public static void demonstrate() {
        System.out.println("\n=== Vector Demonstration ===");

        // Create a Vector with default initial capacity (10)
        List<String> vector = new Vector<>();

        // Add elements
        vector.add("Car"); // Adds at the end
        vector.add("Bus");
        vector.add("Train");
        vector.add(1, "Bike"); // Adds at index 1, shifts elements
        vector.add("Car"); // Duplicates allowed

        // Print the vector
        System.out.println("Vector: " + vector); // Output: [Car, Bike, Bus, Train, Car]

        // Access element by index
        System.out.println("Element at index 2: " + vector.get(2)); // Output: Bus

        // Replace element
        vector.set(2, "Truck");
        System.out.println("After set(2, Truck): " + vector); // Output: [Car, Bike, Truck, Train, Car]

        // Remove element
        vector.remove("Train");
        System.out.println("After removing Train: " + vector); // Output: [Car, Bike, Truck, Car]

        // Size and check for element
        System.out.println("Size: " + vector.size()); // Output: 4
        System.out.println("Contains Bike? " + vector.contains("Bike")); // Output: true

        // Demonstrate Enumeration (legacy feature)
        Vector<String> vec = (Vector<String>) vector;
        Enumeration<String> enumeration = vec.elements();
        System.out.println("Enumerating Vector:");
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
