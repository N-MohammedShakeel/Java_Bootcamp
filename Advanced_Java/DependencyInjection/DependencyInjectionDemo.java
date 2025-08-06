package Java_Bootcamp.Advanced_Java.DependencyInjection;// Java Fundamentals: Dependency Injection (DI) in Core Java
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
Dependency Injection Overview
----------------------------
- Dependency Injection (DI) is a design pattern where dependencies (objects a class needs) are provided externally rather than created internally.
- Purpose: Promotes loose coupling, testability, and maintainability by separating object creation from usage.
- In Core Java:
  - No frameworks required; DI can be implemented manually via constructors, setters, or interfaces.
  - Objects are "injected" (passed) into a class, typically through constructor parameters or setter methods.
- Key Principles:
  - Inversion of Control (IoC): The control of creating dependencies is inverted to an external entity (e.g., a main class).
  - Dependency: An object or service another object relies on.
  - Injection: Passing the dependency to the dependent object.
- Benefits:
  - Easier to test (swap real dependencies with mocks).
  - Flexible (change implementations without modifying dependent classes).
  - Reduces tight coupling between classes.
- Example Structure:
  - MessageService: Interface for sending messages.
  - EmailService, SMSService: Implementations of MessageService.
  - MessageProcessor: Depends on MessageService, receives it via constructor or setter.
- Notes:
  - Manual DI in core Java is simple but requires explicit wiring.
  - Frameworks like Spring automate DI, but core Java shows the concept clearly.
*/

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // Example 1: Constructor Injection with EmailService
        System.out.println("Example 1: Constructor Injection (EmailService)");
        MessageService emailService = new EmailService();
        MessageProcessor emailProcessor = new MessageProcessor(emailService);
        emailProcessor.processMessage("Hello, World!", "user@example.com");

        // Example 2: Constructor Injection with SMSService
        System.out.println("\nExample 2: Constructor Injection (SMSService)");
        MessageService smsService = new SMSService();
        MessageProcessor smsProcessor = new MessageProcessor(smsService);
        smsProcessor.processMessage("Meeting at 5 PM", "+1234567890");

        // Example 3: Setter Injection with EmailService
        System.out.println("\nExample 3: Setter Injection (EmailService)");
        MessageProcessorWithSetter setterProcessor = new MessageProcessorWithSetter();
        setterProcessor.setMessageService(new EmailService());
        setterProcessor.processMessage("Test Email", "test@example.com");

        // Example 4: Setter Injection with SMSService
        System.out.println("\nExample 4: Setter Injection (SMSService)");
        setterProcessor.setMessageService(new SMSService());
        setterProcessor.processMessage("Reminder: Call tomorrow", "+0987654321");
    }
}