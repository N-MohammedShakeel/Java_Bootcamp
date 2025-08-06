package Java_Bootcamp.Advanced_Java.DependencyInjection;

// Concrete implementation: SMS service
class SMSService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("SMS sent to " + recipient + ": " + message);
    }
}
