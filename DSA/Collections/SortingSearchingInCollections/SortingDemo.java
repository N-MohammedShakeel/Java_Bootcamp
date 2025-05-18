package Java_Bootcamp.DSA.Collections.SortingSearchingInCollections;

import java.util.*;

// Class to demonstrate sorting methods
class SortingDemo {
    // Demonstrates sorting using Collections.sort(), Comparable, Comparator, TreeSet, and TreeMap.

    public static void demonstrate() {
        System.out.println("=== Sorting Demonstration ===");

        // 1. Collections.sort() for List
        // - Sorts a List in place; requires elements to implement Comparable or a Comparator.
        // - Use Case: Sorting a dynamic list of elements (e.g., leaderboard).
        System.out.println("\nUsing Collections.sort() for List:");
        List<String> fruits = new ArrayList<>(Arrays.asList("Banana", "Apple", "Orange", "Mango"));
        System.out.println("Before sorting: " + fruits);
        Collections.sort(fruits); // Sorts in natural order (alphabetical)
        System.out.println("After sorting: " + fruits); // Output: [Apple, Banana, Mango, Orange]

        // 2. Collections.sort() with Comparable
        // - Student class implements Comparable for natural ordering by score.
        System.out.println("\nUsing Collections.sort() with Comparable (Student by score):");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 92),
                new Student("Charlie", 88)
        ));
        System.out.println("Before sorting: " + students);
        Collections.sort(students); // Uses Student's compareTo (by score)
        System.out.println("After sorting: " + students); // Output: [Alice: 85, Charlie: 88, Bob: 92]

        // 3. Collections.sort() with Comparator
        // - Custom sorting by name (alphabetical) using Comparator.
        // - Use Case: When natural ordering is not suitable or multiple sort criteria are needed.
        System.out.println("\nUsing Collections.sort() with Comparator (Student by name):");
        Comparator<Student> nameComparator = (s1, s2) -> s1.getName().compareTo(s2.getName());
        Collections.sort(students, nameComparator); // Sorts by name
        System.out.println("After sorting by name: " + students); // Output: [Alice: 85, Bob: 92, Charlie: 88]

        // 4. TreeSet (automatic sorting)
        // - Maintains elements in sorted order using Comparable or Comparator.
        // - Use Case: When you need a set that is always sorted (e.g., unique sorted IDs).
        System.out.println("\nUsing TreeSet (automatic sorting):");
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(30);
        numbers.add(10);
        numbers.add(20);
        System.out.println("TreeSet: " + numbers); // Output: [10, 20, 30] (sorted)

        // 5. TreeMap (automatic sorting by keys)
        // - Maintains key-value pairs sorted by keys using Comparable or Comparator.
        // - Use Case: When you need a sorted map (e.g., dictionary).
        System.out.println("\nUsing TreeMap (automatic sorting by keys):");
        Map<String, Integer> scores = new TreeMap<>();
        scores.put("Charlie", 88);
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        System.out.println("TreeMap: " + scores); // Output: {Alice=85, Bob=92, Charlie=88} (sorted by keys)
    }
}
