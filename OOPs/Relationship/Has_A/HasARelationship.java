package Java_Bootcamp.OOPs.Relationship.Has_A;

import java.util.ArrayList;
import java.util.List;

// Composition: Engine is part of Car
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    // Composition: Car owns an Engine
    private final Engine engine; // Immutable reference

    public Car() {
        this.engine = new Engine();
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}

// Aggregation: Department has Employees
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    // Aggregation: Department has a list of Employees
    private final List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        if (emp != null) { // Null check
            employees.add(emp);
        }
    }

    public void displayEmployees() {
        System.out.println("Department Employees:");
        for (Employee emp : employees) {
            System.out.println("- " + emp.getName());
        }
    }
}

public class HasARelationship {
    public static void main(String[] args) {
        // Test Composition
        System.out.println("Testing Composition (Car has Engine):");
        Car car = new Car();
        car.drive();
        // Output:
        // Engine started
        // Car is driving

        // Test Aggregation
        System.out.println("\nTesting Aggregation (Department has Employees):");
        Department dept = new Department();
        Employee emp1 = new Employee("Alice");
        Employee emp2 = new Employee("Bob");
        dept.addEmployee(emp1);
        dept.addEmployee(emp2);
        dept.displayEmployees();
        // Output:
        // Department Employees:
        // - Alice
        // - Bob
    }
}