package Java_Bootcamp.Other_DesignPrinciples.YAGNI;

/**
 * OrderProcessorViolation.java
 * Demonstrates a violation of the YAGNI principle by implementing unnecessary payment gateways.
 * The system includes speculative support for PayPal and Crypto, which aren't currently needed.
 * Real-world scenario: Processing orders in an e-commerce system with a single payment method required.
 */
class Order {
    private String item;
    private double price;

    public Order(String item, double price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }
}
