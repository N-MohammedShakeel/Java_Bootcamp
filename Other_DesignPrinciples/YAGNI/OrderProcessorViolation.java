package Java_Bootcamp.Other_DesignPrinciples.YAGNI;

public class OrderProcessorViolation {
    // Violation: Implementing multiple payment methods when only one is needed
    public void processOrder(Order order, String paymentMethod) {
        System.out.println("Processing order: " + order.getItem() + ", Price: $" + order.getPrice());
        if (paymentMethod.equals("CreditCard")) {
            processCreditCard(order);
        } else if (paymentMethod.equals("PayPal")) {
            processPayPal(order); // Unnecessary, not currently required
        } else if (paymentMethod.equals("Crypto")) {
            processCrypto(order); // Unnecessary, not currently required
        } else {
            throw new IllegalArgumentException("Unsupported payment method");
        }
    }

    private void processCreditCard(Order order) {
        System.out.println("Processing credit card payment for $" + order.getPrice());
    }

    // Violation: Speculative implementation
    private void processPayPal(Order order) {
        System.out.println("Processing PayPal payment for $" + order.getPrice());
    }

    // Violation: Speculative implementation
    private void processCrypto(Order order) {
        System.out.println("Processing crypto payment for $" + order.getPrice());
    }

    public static void main(String[] args) {
        OrderProcessorViolation processor = new OrderProcessorViolation();
        Order order = new Order("Laptop", 999.99);
        processor.processOrder(order, "CreditCard");
    }
}