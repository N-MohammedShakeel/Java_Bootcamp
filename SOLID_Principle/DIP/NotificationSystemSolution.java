package Java_Bootcamp.SOLID_Principle.DIP;// NotificationSystemSolution.java
// Demonstrates adherence to the Dependency Inversion Principle (DIP)
// Both high-level and low-level modules depend on abstractions

// Abstraction for notification services
interface NotificationService {
    void sendNotification(String message);
}

// Concrete email service
class EmailService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}

// High-level module depends on abstraction
public class NotificationSystemSolution {
    private final NotificationService notificationService;

    // Dependency injection via constructor
    public NotificationSystemSolution(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notify(String message) {
        notificationService.sendNotification(message);
    }

    public static void main(String[] args) {
        NotificationService emailService = new EmailService();
        NotificationSystemSolution system = new NotificationSystemSolution(emailService);
        system.notify("Hello, user!");
        // Can easily swap with another service (e.g., SMSService) without changing this class
    }
}