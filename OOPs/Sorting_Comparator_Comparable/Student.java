package Java_Bootcamp.OOPs.Sorting_Comparator_Comparable;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Student demonstrates Comparable and Comparator for sorting Student objects by roll number (natural ordering),
 * name length, age, and multi-field criteria. Includes null handling, lambda-based comparators, and edge cases.
 * Embeds professional practices, notes for mastery, and internal implementation details for Phase 1 learners
 * mastering Java sorting in the Java Bootcamp.
 */
public class Student {
    // Student class implementing Comparable for natural ordering by roll number
    static class StudentImpl implements Comparable<StudentImpl> {
        private final int rollNumber;
        private final String name;
        private final int age;

        StudentImpl(int rollNumber, String name, int age) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
        }

        // Natural ordering by roll number using Integer.compare
        @Override
        public int compareTo(StudentImpl s) {
            return Integer.compare(this.rollNumber, s.rollNumber);
        }

        // Getters for lambda-based sorting
        public int getRollNumber() { return rollNumber; }
        public String getName() { return name; }
        public int getAge() { return age; }

        @Override
        public String toString() {
            return "Student{rollNumber=" + rollNumber + ", name='" + name + "', age=" + age + "}";
        }
    }

    // Comparator for sorting by name length, then lexicographically
    static class StudentNameComparator implements Comparator<StudentImpl> {
        @Override
        public int compare(StudentImpl s1, StudentImpl s2) {
            // Null handling: null names come first
            if (s1.name == null && s2.name == null) return 0;
            if (s1.name == null) return -1;
            if (s2.name == null) return 1;
            // Sort by length, then name for ties
            int lengthCompare = Integer.compare(s1.name.length(), s2.name.length());
            return lengthCompare != 0 ? lengthCompare : s1.name.compareTo(s2.name);
        }
    }

    public static void main(String[] args) {
        // Test data with null name and equal ages
        StudentImpl[] students = {
            new StudentImpl(3, "Alice", 20),
            new StudentImpl(1, "Bob", 22),
            new StudentImpl(2, "Charlie", 20), // Equal age to Alice
            new StudentImpl(4, null, 21)       // Null name edge case
        };

        // Natural ordering: Sort by roll number (Comparable)
        System.out.println("Sorted by Roll Number (Natural Ordering):");
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        // Custom ordering: Sort by name length (StudentNameComparator)
        System.out.println("\nSorted by Name Length:");
        Arrays.sort(students, new StudentNameComparator());
        System.out.println(Arrays.toString(students));

        // Lambda: Sort by age descending
        System.out.println("\nSorted by Age (Descending):");
        Arrays.sort(students, Comparator.comparingInt(StudentImpl::getAge).reversed());
        System.out.println(Arrays.toString(students));

        // Lambda: Sort by age, then name lexicographically
        System.out.println("\nSorted by Age, then Name:");
        Arrays.sort(students, Comparator.comparingInt(StudentImpl::getAge)
                                       .thenComparing(StudentImpl::getName, Comparator.nullsLast(String::compareTo)));
        System.out.println(Arrays.toString(students));
    }

    /**
     * Internal Implementation Details:
     * - Comparable (compareTo): Invoked by Arrays.sort() for roll number comparison. Uses Integer.compare() to return
     *   -1, 0, or 1, avoiding overflow. TimSort (O(n log n)) compares pairs iteratively.
     * - Comparator (StudentNameComparator): Defines custom ordering. Instantiated once, reused. Null checks handle
     *   null names safely. Lambdas use thenComparing for multi-field sorting.
     * - Object Creation: Sorting reorders array references, no new StudentImpl objects created. Comparator instances
     *   are lightweight. Lambdas generate synthetic classes at runtime.
     * - JVM Behavior: TimSort optimizes for partially sorted data, reducing comparisons. NullPointerException is avoided
     *   via nullsLast or explicit checks. compareTo() assumes non-null objects; null StudentImpls would throw an exception.
     * - Memory: TimSort uses O(n) auxiliary space for merging. No additional StudentImpl objects allocated.
     *
     * Professional Practices:
     * - Use generics (Comparable<StudentImpl>, Comparator<StudentImpl>) for type safety, eliminating casts.
     * - Ensure immutability with final fields to prevent sorting inconsistencies.
     * - Handle nulls with nullsLast or explicit checks to avoid NullPointerException.
     * - Use utility methods (Integer.compare) for precise, overflow-safe comparisons.
     * - Provide getters for method references in lambda-based sorting (e.g., StudentImpl::getAge).
     * - Format toString for debugging (e.g., Student{rollNumber=1, ...}).
     * - Test edge cases like null names and equal ages for robustness.
     *
     * Notes for Mastery:
     * - Comparable defines a single natural ordering (roll number), ideal for default sorting in collections like TreeSet.
     * - Comparator supports flexible sorting (name length, age), enabling dynamic criteria.
     * - Multi-field sorting (age then name) ensures deterministic results for ties.
     * - Null handling is critical for robust production code.
     * - Lambda comparators with Comparator.comparing provide concise, readable syntax.
     * - Avoid subtraction (e.g., this.rollNumber - s.rollNumber) to prevent overflow; use compare methods.
     * - Understand TimSort’s efficiency for real-world sorting performance.
     */
}