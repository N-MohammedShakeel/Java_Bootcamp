package Java_Bootcamp.AdvancedJava.DependencyInjection;

// Dependent class using constructor injection
class MessageProcessor {
    private final MessageService messageService;

    // Constructor injection
    public MessageProcessor(MessageService messageService) {
        if (messageService == null) {
            throw new IllegalArgumentException("MessageService cannot be null");
        }
        this.messageService = messageService;
    }

    public void processMessage(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}
