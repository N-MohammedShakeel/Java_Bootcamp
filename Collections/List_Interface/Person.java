package Java_Bootcamp.Collections.List_Interface;

// Custom class for demonstrating custom objects in ArrayList
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        // Purpose: Compare Person objects based on name for equality
        // Key Features:
        // - Used by contains, remove, and other methods
        // - Compares only name field for simplicity
        // - Time Complexity: O(1) for string comparison
        // - Use Case: Ensures correct behavior in ArrayList operations like contains
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
        // - Required for correct behavior in hash-based collections
        // - Time Complexity: O(1)
        // - Use Case: Supports custom objects in ArrayList with contains/remove
        return name.hashCode();
    }

    @Override
    public String toString() {
        // Purpose: Provide string representation of Person
        // Key Features:
        // - Used by ArrayList.toString for readable output
        // - Time Complexity: O(1)
        // - Use Case: Debugging and displaying Person objects
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
