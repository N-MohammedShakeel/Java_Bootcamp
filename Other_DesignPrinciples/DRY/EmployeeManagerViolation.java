package Java_Bootcamp.Other_DesignPrinciples.DRY;

public class EmployeeManagerViolation {
    // Violation: Duplicated salary calculation logic
    public void printAnnualSalary(Employee employee) {
        double annualSalary = employee.getBaseSalary() * 12 * 1.1; // 10% bonus
        System.out.println(employee.getName() + " annual salary: $" + annualSalary);
    }

    // Violation: Same calculation logic repeated
    public void printBonus(Employee employee) {
        double bonus = (employee.getBaseSalary() * 12 * 1.1) - (employee.getBaseSalary() * 12); // Bonus part
        System.out.println(employee.getName() + " bonus: $" + bonus);
    }

    public static void main(String[] args) {
        EmployeeManagerViolation manager = new EmployeeManagerViolation();
        Employee emp = new Employee("Alice", 5000);
        manager.printAnnualSalary(emp);
        manager.printBonus(emp);
    }
}