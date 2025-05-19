package Java_Bootcamp.AdvancedJava.DependencyInjection;

// Dependent class using setter injection
class MessageProcessorWithSetter {
    private MessageService messageService;

    // Setter injection
    public void setMessageService(MessageService messageService) {
        if (messageService == null) {
            throw new IllegalArgumentException("MessageService cannot be null");
        }
        this.messageService = messageService;
    }

    public void processMessage(String message, String recipient) {
        if (messageService == null) {
            throw new IllegalStateException("MessageService not set");
        }
        messageService.sendMessage(message, recipient);
    }
}
