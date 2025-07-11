package Java_Bootcamp.SOLID_Principle.ISP;// PaymentSystemViolation.java
// Demonstrates a violation of the Interface Segregation Principle (ISP)
// Clients are forced to implement unused methods

// Fat interface with too many methods
interface Payment {
    void processCreditCard();
    void processPayPal();
    void processCash();
}

// Violation: CreditCardPayment must implement unused methods
class CreditCardPayment1 implements Payment {
    @Override
    public void processCreditCard() {
        System.out.println("Processing credit card payment");
    }

    // Unnecessary method for this class
    @Override
    public void processPayPal() {
        throw new UnsupportedOperationException("PayPal not supported");
    }

    // Unnecessary method for this class
    @Override
    public void processCash() {
        throw new UnsupportedOperationException("Cash not supported");
    }
}

public class PaymentSystemViolation {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment1();
        payment.processCreditCard(); // Works fine
        // payment.processPayPal(); // Throws exception
    }
}