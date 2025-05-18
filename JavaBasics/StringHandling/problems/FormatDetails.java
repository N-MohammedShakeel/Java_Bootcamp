package Java_Bootcamp.JavaBasics.StringHandling.problems;

public class FormatDetails {
    public static void main(String[] args) {
        // Problem: Format a person's details: name="John", age=30, salary=75000.50
        String name = "John";
        int age = 30;
        double salary = 75000.50;
        System.out.println("Input: name=" + name + ", age=" + age + ", salary=" + salary);

        // Solution: Use String.format for formatted output
        String formatted = String.format("Name: %s, Age: %d, Salary: $%.2f", name, age, salary);
        System.out.println("Formatted: " + formatted);
    }
}