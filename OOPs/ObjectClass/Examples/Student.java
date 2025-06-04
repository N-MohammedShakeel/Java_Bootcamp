package Java_Bootcamp.OOPs.ObjectClass.Examples;

import java.util.HashSet;
import java.util.Objects;

public class Student {
    // Fields representing a student's properties
    private String id;    // Unique identifier for the student
    private String name;  // Student's name
    private int age;     // Student's age

    // Constructor to initialize a Student object
    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Override toString() to provide a human-readable representation
    @Override
    public String toString() {
        // Purpose: Returns a string describing the Student object for debugging or logging
        // Implementation: Concatenates field values in a clear format
        return "Student{id='" + id + "', name='" + name + "', age=" + age + "}";
        // Workflow:
        // 1. Constructs a string with field names and values.
        // 2. Uses single quotes for strings (id, name) and numeric format for age.
        // 3. Returns formatted string, e.g., "Student{id='S001', name='Alice', age=20}".
        // Best Practice: Keep concise, include all relevant fields.
    }

    // Override equals() to compare two Student objects for logical equality
    @Override
    public boolean equals(Object obj) {
        // Purpose: Determines if this Student is logically equal to another object
        // Implementation: Compares id, name, and age fields
        // Contract: Reflexive, symmetric, transitive, consistent, and null returns false

        // Check if same object reference (reflexive)
        if (this == obj) {
            return true;
        }

        // Check for null or different class (type safety)
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Cast to Student and compare fields
        Student other = (Student) obj;
        return age == other.age &&
               Objects.equals(id, other.id) &&
               Objects.equals(name, other.name);
        // Workflow:
        // 1. Early return true if same object (optimization).
        // 2. Return false if obj is null or not a Student (guards against invalid input).
        // 3. Compare fields using Objects.equals() for null-safe string comparison.
        // 4. Compare age directly (primitive int).
        // Best Practice: Use Objects.equals() for reference types, ensure all fields are compared.
    }

    // Override hashCode() to generate a hash code consistent with equals()
    @Override
    public int hashCode() {
        // Purpose: Returns a hash code for use in hash-based collections (e.g., HashMap, HashSet)
        // Implementation: Combines hash codes of id, name, and age
        // Contract: Equal objects must have equal hash codes, consistent during execution

        return Objects.hash(id, name, age);
        // Workflow:
        // 1. Uses Objects.hash() to compute a hash code from all fields.
        // 2. Internally, Objects.hash() combines field hashes using a formula (e.g., 31 * hash1 + hash2).
        // 3. Returns integer hash code, ensuring consistency with equals().
        // Best Practice: Include same fields as equals(), use Objects.hash() for simplicity.
        // Note: Custom formula like 31 * id.hashCode() + name.hashCode() + age could be used,
        // but Objects.hash() is concise and reliable.
    }

    // Main method to test overridden methods
    public static void main(String[] args) {
        // Create two Student objects with same field values
        Student s1 = new Student("S001", "Alice", 20);
        Student s2 = new Student("S001", "Alice", 20);
        // Create a different Student object
        Student s3 = new Student("S002", "Bob", 21);

        // Test toString()
        System.out.println("s1 toString: " + s1);
        // Expected Output: Student{id='S001', name='Alice', age=20}

        // Test equals()
        System.out.println("s1 equals s2: " + s1.equals(s2)); // true (same field values)
        System.out.println("s1 equals s3: " + s1.equals(s3)); // false (different fields)
        System.out.println("s1 equals null: " + s1.equals(null)); // false (null check)

        // Test hashCode()
        System.out.println("s1 hashCode: " + s1.hashCode());
        System.out.println("s2 hashCode: " + s2.hashCode()); // Same as s1 (equal objects)
        System.out.println("s3 hashCode: " + s3.hashCode()); // Likely different

        // Test in HashSet (relies on equals() and hashCode())
        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2); // Not added (duplicate due to equals())
        set.add(s3);
        System.out.println("HashSet size: " + set.size()); // 2 (s1/s2 are equal)
        System.out.println("HashSet contains s2: " + set.contains(s2)); // true
    }
}