package Java_Bootcamp.Collections.Set_Interface;

// Custom class for demonstrating custom objects in HashSet
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        // Purpose: Initialize a Person object
        // Key Features:
        // - Stores name and age
        // - Used in HashSet for custom object demonstration
        // - Time Complexity: O(1)
        // - Use Case: Structured data storage with uniqueness
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        // Purpose: Compare Person objects based on name for equality
        // Key Features:
        // - Used by contains, remove, and add to ensure uniqueness
        // - Compares only name field for simplicity
        // - Time Complexity: O(1) for string comparison
        // - Use Case: Ensures correct behavior in HashSet operations
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
        // - Required for efficient HashSet operations
        // - Time Complexity: O(1)
        // - Use Case: Supports custom objects in HashSet
        return name.hashCode();
    }

    @Override
    public String toString() {
        // Purpose: Provide string representation of Person
        // Key Features:
        // - Used by HashSet.toString for readable output
        // - Time Complexity: O(1)
        // - Use Case: Debugging and displaying Person objects
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
