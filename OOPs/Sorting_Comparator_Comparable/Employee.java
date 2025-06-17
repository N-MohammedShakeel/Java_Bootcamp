package Java_Bootcamp.OOPs.Sorting_Comparator_Comparable;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Employee demonstrates Comparable and Comparator for sorting Employee objects by ID (natural ordering),
 * name length, salary, and multi-field criteria. Includes null handling, lambda-based comparators, and
 * edge cases. Embeds professional practices, notes for mastery, and internal implementation details for
 * Phase 1 learners mastering Java sorting in the Java Bootcamp.
 */
public class Employee {
    // Employee class implementing Comparable for natural ordering by ID
    static class EmployeeImpl implements Comparable<EmployeeImpl> {
        private final int id;
        private final String name;
        private final double salary;

        EmployeeImpl(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        // Natural ordering by ID using Integer.compare to avoid overflow
        @Override
        public int compareTo(EmployeeImpl e) {
            return Integer.compare(this.id, e.id);
        }

        // Getters for lambda-based sorting
        public int getId() { return id; }
        public String getName() { return name; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
        }
    }

    // Comparator for sorting by name length, then lexicographically
    static class EmployeeNameComparator implements Comparator<EmployeeImpl> {
        @Override
        public int compare(EmployeeImpl e1, EmployeeImpl e2) {
            // Null handling: null names come first
            if (e1.name == null && e2.name == null) return 0;
            if (e1.name == null) return -1;
            if (e2.name == null) return 1;
            // Sort by length, then name for ties
            int lengthCompare = Integer.compare(e1.name.length(), e2.name.length());
            return lengthCompare != 0 ? lengthCompare : e1.name.compareTo(e2.name);
        }
    }

    // Comparator for sorting by salary
    static class SalaryComparator implements Comparator<EmployeeImpl> {
        @Override
        public int compare(EmployeeImpl e1, EmployeeImpl e2) {
            // Sort by salary ascending using Double.compare for precision
            return Double.compare(e1.salary, e2.salary);
        }
    }

    public static void main(String[] args) {
        // Test data with null name and equal salaries
        EmployeeImpl[] employees = {
            new EmployeeImpl(2, "John", 50000),
            new EmployeeImpl(1, "Anna", 70000),
            new EmployeeImpl(3, "Christopher", 60000),
            new EmployeeImpl(4, null, 60000), // Null name edge case
            new EmployeeImpl(5, "Bob", 50000) // Equal salary to John
        };

        // Natural ordering: Sort by ID (Comparable)
        System.out.println("Sorted by ID (Natural Ordering):");
        Arrays.sort(employees);
        System.out.println(Arrays.toString(employees));

        // Custom ordering: Sort by name length (EmployeeNameComparator)
        System.out.println("\nSorted by Name Length:");
        Arrays.sort(employees, new EmployeeNameComparator());
        System.out.println(Arrays.toString(employees));

        // Custom ordering: Sort by salary (SalaryComparator)
        System.out.println("\nSorted by Salary:");
        Arrays.sort(employees, new SalaryComparator());
        System.out.println(Arrays.toString(employees));

        // Lambda: Sort by salary descending, then ID ascending
        System.out.println("\nSorted by Salary (Descending), then ID:");
        Arrays.sort(employees, Comparator.comparingDouble(EmployeeImpl::getSalary)
                                        .reversed()
                                        .thenComparingInt(EmployeeImpl::getId));
        System.out.println(Arrays.toString(employees));

        // Lambda: Sort by name lexicographically, nulls last
        System.out.println("\nSorted by Name (Lexicographical, Nulls Last):");
        Arrays.sort(employees, Comparator.comparing(EmployeeImpl::getName, 
                                                  Comparator.nullsLast(String::compareTo)));
        System.out.println(Arrays.toString(employees));
    }

    /**
     * Internal Implementation Details:
     * - Comparable (compareTo): Invoked by Arrays.sort() to compare EmployeeImpl objects by ID. Returns -1, 0, or 1
     *   using Integer.compare(), preventing overflow (e.g., for large IDs). TimSort (O(n log n)) compares pairs iteratively.
     * - Comparator (e.g., SalaryComparator): Defines custom ordering. Instantiated once per sort, reused. Null checks in
     *   EmployeeNameComparator handle null names safely. Chained lambdas (salary then ID) evaluate sequentially.
     * - Object Creation: Sorting modifies array references in-place, no new EmployeeImpl objects created. Comparator instances
     *   (e.g., new SalaryComparator()) are lightweight. Lambdas generate synthetic classes at runtime.
     * - JVM Behavior: TimSort optimizes for partially sorted data, reducing comparisons. NullPointerException is avoided
     *   via nullsLast or explicit checks. compareTo() assumes non-null objects; null EmployeeImpls would throw an exception.
     * - Memory: TimSort uses O(n) auxiliary space for merging. No additional EmployeeImpl objects are allocated.
     *
     * Professional Practices:
     * - Use generics (Comparable<EmployeeImpl>, Comparator<EmployeeImpl>) for type safety, eliminating casts.
     * - Ensure immutability with final fields to prevent sorting inconsistencies.
     * - Handle nulls with nullsLast or explicit checks to avoid NullPointerException.
     * - Use utility methods (Integer.compare, Double.compare) for precise, overflow-safe comparisons.
     * - Provide getters for method references in lambda-based sorting (e.g., EmployeeImpl::getSalary).
     * - Format toString for debugging (e.g., Employee{id=1, ...}).
     * - Test edge cases like null names and equal salaries for robustness.
     *
     * Notes for Mastery:
     * - Comparable provides a single natural ordering (ID), suitable for default sorting in collections like TreeSet.
     * - Comparator supports flexible sorting (name length, salary), enabling dynamic criteria.
     * - Multi-field sorting (salary then ID) resolves ties for deterministic results.
     * - Null handling is critical for production code to prevent runtime errors.
     * - Lambda comparators (Comparator.comparing) offer concise, modern syntax.
     * - Avoid subtraction (e.g., this.id - e.id) to prevent overflow; use compare methods.
     * - Understand TimSort’s efficiency for optimizing real-world sorting.
     */
}