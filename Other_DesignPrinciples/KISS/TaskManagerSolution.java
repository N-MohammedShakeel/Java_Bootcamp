package Java_Bootcamp.Other_DesignPrinciples.KISS; /**
 * TaskManagerSolution.java
 * Demonstrates adherence to the KISS principle by simplifying a task management system.
 * Uses a single class with a straightforward ArrayList for task management, avoiding unnecessary complexity.
 * Real-world scenario: Managing a to-do list in a productivity app.
 */
import java.util.ArrayList;
import java.util.List;

public class TaskManagerSolution {
    private List<String> tasks = new ArrayList<>();

    // Simple method to add a task with minimal validation
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid task description");
        }
        tasks.add(description);
        System.out.println("Task added: " + description);
    }

    // Simple method to print tasks
    public void printTasks() {
        for (String task : tasks) {
            System.out.println(task);
        }
    }

    public static void main(String[] args) {
        TaskManagerSolution manager = new TaskManagerSolution();
        manager.addTask("Buy groceries");
        manager.addTask("Write code");
        manager.printTasks();
    }
}