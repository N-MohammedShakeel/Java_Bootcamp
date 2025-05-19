package Java_Bootcamp.OOPs.Record;// Java Fundamentals: Records
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Records Overview
---------------
- Introduced in Java 16 (JEP 395), records are a special kind of class for immutable data carriers.
- Purpose: Simplify creation of classes that hold data with minimal boilerplate code.
- Key Features:
  - Automatically provide: constructor, getters, equals(), hashCode(), toString().
  - Implicitly final (cannot be extended).
  - Fields (components) are final, ensuring immutability.
- Syntax: record RecordName(Type1 field1, Type2 field2) { ... }
- Example: record Point(int x, int y) { }
- Use Cases:
  - Data transfer objects (DTOs), configuration objects, or immutable data holders.
  - Replaces traditional POJOs with verbose getters/setters.
- Notes:
  - Records can include additional methods, static fields, and custom constructors.
  - Cannot extend other classes but can implement interfaces.
  - Components are accessed via auto-generated accessor methods (e.g., x() for field x).
*/

public class RecordDemo {
    public static void main(String[] args) {
        // Example 1: Creating and using a Point record
        System.out.println("Example 1: Point Record");
        Point p1 = new Point(3, 4);
        System.out.println("Point: " + p1); // Auto-generated toString: Point[x=3, y=4]
        System.out.println("X coordinate: " + p1.x()); // Accessor method
        System.out.println("Distance from origin: " + p1.distanceFromOrigin()); // 5.0
        Point p2 = new Point(3, 4);
        System.out.println("p1 equals p2: " + p1.equals(p2)); // true (auto-generated equals)
        System.out.println("Shifted point: " + Point.shift(p1, 1, 1)); // Point[x=4, y=5]
        System.out.println("Origin: " + Point.ORIGIN); // Point[x=0, y=0]

        // Example 2: Person record with interface
        System.out.println("\nExample 2: Person Record");
        Person person = new Person("Alice", 25);
        System.out.println("Person: " + person); // Person[name=Alice, age=25]
        person.print(); // Person: Alice, Age: 25

        // Example 3: Handling invalid input
        System.out.println("\nExample 3: Invalid Input");
        try {
            Point invalid = new Point(-1, 5); // Throws IllegalArgumentException
            System.out.println(invalid);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Coordinates must be non-negative
        }
    }
}