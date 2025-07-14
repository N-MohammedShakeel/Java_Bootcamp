package Java_Bootcamp.Other_DesignPrinciples.YAGNI;

public class OrderProcessorSolution {
    // Simple implementation for the only required payment method
    public void processOrder(Order order) {
        System.out.println("Processing order: " + order.getItem() + ", Price: $" + order.getPrice());
        processCreditCard(order);
    }

    private void processCreditCard(Order order) {
        System.out.println("Processing credit card payment for $" + order.getPrice());
    }

    public static void main(String[] args) {
        OrderProcessorSolution processor = new OrderProcessorSolution();
        Order order = new Order("Laptop", 999.99);
        processor.processOrder(order);
    }
}