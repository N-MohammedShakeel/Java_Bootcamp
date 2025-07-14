package Java_Bootcamp.Other_DesignPrinciples.DRY;

public class EmployeeManagerSolution {
    // Centralized method for salary calculation
    private double calculateAnnualSalary(Employee employee) {
        return employee.getBaseSalary() * 12 * 1.1; // 10% bonus
    }

    public void printAnnualSalary(Employee employee) {
        double annualSalary = calculateAnnualSalary(employee);
        System.out.println(employee.getName() + " annual salary: $" + annualSalary);
    }

    public void printBonus(Employee employee) {
        double annualSalary = calculateAnnualSalary(employee);
        double baseAnnual = employee.getBaseSalary() * 12;
        double bonus = annualSalary - baseAnnual;
        System.out.println(employee.getName() + " bonus: $" + bonus);
    }

    public static void main(String[] args) {
        EmployeeManagerSolution manager = new EmployeeManagerSolution();
        Employee emp = new Employee("Alice", 5000);
        manager.printAnnualSalary(emp);
        manager.printBonus(emp);
    }
}