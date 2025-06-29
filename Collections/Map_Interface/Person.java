package Java_Bootcamp.Collections.Map_Interface;

// Custom class for demonstrating custom objects as keys/values in HashMap
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        // Purpose: Initialize a Person object
        // Key Features:
        // - Stores name and age
        // - Used as key/value in HashMap
        // - Time Complexity: O(1)
        // - Use Case: Structured data as map keys/values
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        // Purpose: Compare Person objects for equality
        // Key Features:
        // - Used by containsKey, remove, etc., for key matching
        // - Compares only name field for simplicity
        // - Time Complexity: O(1) for string comparison
        // - Use Case: Ensures correct behavior in HashMap operations
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
        // - Required for HashMap key operations
        // - Time Complexity: O(1)
        // - Use Case: Supports custom objects as keys
        return name.hashCode();
    }

    @Override
    public String toString() {
        // Purpose: Provide string representation of Person
        // Key Features:
        // - Used by HashMap.toString for readable output
        // - Time Complexity: O(1)
        // - Use Case: Debugging and displaying Person objects
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
