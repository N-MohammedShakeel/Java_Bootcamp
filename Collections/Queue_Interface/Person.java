package Java_Bootcamp.Collections.Queue_Interface;

// Custom class for demonstrating custom objects in ArrayDeque
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        // Purpose: Initialize a Person object
        // Key Features:
        // - Stores name and age
        // - Used in ArrayDeque for custom object demonstration
        // - Time Complexity: O(1)
        // - Use Case: Structured data storage in queue/stack
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        // Purpose: Compare Person objects for equality
        // Key Features:
        // - Used by contains, remove, etc., for element matching
        // - Compares only name field for simplicity
        // - Time Complexity: O(1) for string comparison
        // - Use Case: Ensures correct behavior in ArrayDeque operations
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        // Purpose: Generate hash code for Person objects
        // Key Features:
        // - Consistent with equals (based on name)
        // - Required for operations like contains
        // - Time Complexity: O(1)
        // - Use Case: Supports custom objects in ArrayDeque
        return name.hashCode();
    }

    @Override
    public String toString() {
        // Purpose: Provide string representation of Person
        // Key Features:
        // - Used by ArrayDeque.toString for readable output
        // - Time Complexity: O(1)
        // - Use Case: Debugging and displaying Person objects
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
