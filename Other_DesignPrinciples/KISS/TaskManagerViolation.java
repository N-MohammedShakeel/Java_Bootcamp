package Java_Bootcamp.Other_DesignPrinciples.KISS;

/**
 * TaskManagerViolation.java
 * Demonstrates a violation of the KISS principle by overcomplicating a simple task management system.
 * The system uses multiple classes and complex logic for a basic task list, adding unnecessary complexity.
 * Real-world scenario: Managing a to-do list in a productivity app.
 */
class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        isCompleted = true;
    }
}

class TaskValidator {
    // Violation: Unnecessary class for simple validation
    public boolean isValidTask(String description) {
        return description != null && !description.trim().isEmpty();
    }
}

class TaskRepository {
    // Violation: Overcomplicated storage with array and manual resizing
    private Task[] tasks = new Task[10];
    private int size = 0;

    public void addTask(Task task) {
        if (size >= tasks.length) {
            Task[] newTasks = new Task[tasks.length * 2];
            System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
            tasks = newTasks;
        }
        tasks[size++] = task;
    }

    public Task[] getTasks() {
        Task[] result = new Task[size];
        System.arraycopy(tasks, 0, result, 0, size);
        return result;
    }
}

public class TaskManagerViolation {
    private TaskRepository repository = new TaskRepository();
    private TaskValidator validator = new TaskValidator();

    // Violation: Complex method with unnecessary validation and repository logic
    public void addTask(String description) {
        if (validator.isValidTask(description)) {
            repository.addTask(new Task(description));
            System.out.println("Task added: " + description);
        } else {
            throw new IllegalArgumentException("Invalid task description");
        }
    }

    public void printTasks() {
        Task[] tasks = repository.getTasks();
        for (Task task : tasks) {
            System.out.println(task.getDescription() + (task.isCompleted() ? " [Completed]" : ""));
        }
    }

    public static void main(String[] args) {
        TaskManagerViolation manager = new TaskManagerViolation();
        manager.addTask("Buy groceries");
        manager.addTask("Write code");
        manager.printTasks();
    }
}