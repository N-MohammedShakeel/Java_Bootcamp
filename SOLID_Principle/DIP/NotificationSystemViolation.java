package Java_Bootcamp.SOLID_Principle.DIP;// NotificationSystemViolation.java
// Demonstrates a violation of the Dependency Inversion Principle (DIP)
// High-level module depends on concrete low-level module

// Concrete email service
class EmailService1 {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

// Violation: NotificationSystem depends directly on EmailService
public class NotificationSystemViolation {
    private EmailService1 emailService = new EmailService1();

    public void notify(String message) {
        emailService.sendEmail(message); // Hardcoded dependency
    }

    public static void main(String[] args) {
        NotificationSystemViolation system = new NotificationSystemViolation();
        system.notify("Hello, user!");
    }
}