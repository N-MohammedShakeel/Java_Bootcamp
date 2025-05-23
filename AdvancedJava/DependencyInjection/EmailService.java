package Java_Bootcamp.AdvancedJava.DependencyInjection;

// Concrete implementation: Email service
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Email sent to " + recipient + ": " + message);
    }
}
