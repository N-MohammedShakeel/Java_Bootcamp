package Java_Bootcamp.DSA.Collections.SortingSearchingInCollections;

import java.util.*;

// Class to demonstrate searching methods
class SearchingDemo {
    // Demonstrates searching using Collections.binarySearch(), contains(), and indexOf().

    public static void demonstrate() {
        System.out.println("\n=== Searching Demonstration ===");

        // 1. Collections.binarySearch() for sorted List
        // - Requires the List to be sorted; uses binary search (O(log n)).
        // - Returns index of the element or a negative value if not found.
        // - Use Case: Efficient searching in large sorted lists.
        System.out.println("\nUsing Collections.binarySearch() for sorted List:");
        List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Mango", "Orange"));
        Collections.sort(fruits); // Must sort before binary search
        System.out.println("Sorted List: " + fruits); // Output: [Apple, Banana, Mango, Orange]
        int index = Collections.binarySearch(fruits, "Mango");
        System.out.println("Index of Mango: " + index); // Output: 2
        index = Collections.binarySearch(fruits, "Grape");
        System.out.println("Index of Grape (not found): " + index); // Output: -2 (insertion point)

        // Binary search with Comparable
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 92),
                new Student("Charlie", 88)
        ));
        Collections.sort(students); // Sort by score (Comparable)
        System.out.println("\nSorted Students: " + students);
        Student key = new Student("Temp", 88); // Search by score
        index = Collections.binarySearch(students, key);
        System.out.println("Index of score 88: " + index); // Output: 1

        // Binary search with Comparator
        Comparator<Student> nameComparator = (s1, s2) -> s1.getName().compareTo(s2.getName());
        Collections.sort(students, nameComparator); // Sort by name
        System.out.println("Students sorted by name: " + students);
        key = new Student("Bob", 0); // Search by name
        index = Collections.binarySearch(students, key, nameComparator);
        System.out.println("Index of Bob: " + index); // Output: 1

        // 2. contains() and indexOf() for searching
        // - Linear search (O(n)); works on unsorted collections.
        // - contains(): Returns true if element exists.
        // - indexOf(): Returns index of first occurrence or -1 if not found.
        // - Use Case: Simple searches in small or unsorted collections.
        System.out.println("\nUsing contains() and indexOf() for List:");
        fruits = new ArrayList<>(Arrays.asList("Banana", "Apple", "Orange", "Apple"));
        System.out.println("Unsorted List: " + fruits);
        System.out.println("Contains Apple? " + fruits.contains("Apple")); // Output: true
        System.out.println("Index of Apple: " + fruits.indexOf("Apple")); // Output: 1
        System.out.println("Index of Grape: " + fruits.indexOf("Grape")); // Output: -1

        // contains() for Set
        Set<String> animals = new HashSet<>(Arrays.asList("Dog", "Cat", "Bird"));
        System.out.println("\nSet: " + animals);
        System.out.println("Contains Cat? " + animals.contains("Cat")); // Output: true
    }
}
