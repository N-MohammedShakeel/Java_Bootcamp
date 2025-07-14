package Java_Bootcamp.Other_DesignPrinciples.DRY;

/**
 * EmployeeManagerSolution.java
 * Demonstrates adherence to the DRY principle by centralizing salary calculation logic.
 * The logic is abstracted into a single method, reducing duplication and improving maintainability.
 * Real-world scenario: Managing employee records in a payroll system.
 */
class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
