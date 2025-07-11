package Java_Bootcamp.SOLID_Principle.ISP;// PaymentSystemSolution.java
// Demonstrates adherence to the Interface Segregation Principle (ISP)
// Interfaces are split to avoid forcing unused methods

// Interface for credit card payments
interface CreditCardPayment {
    void processCreditCard();
}

// Interface for PayPal payments
interface PayPalPayment {
    void processPayPal();
}

// Interface for cash payments
interface CashPayment {
    void processCash();
}

// Class only implements relevant interface
class CreditCardProcessor implements CreditCardPayment {
    @Override
    public void processCreditCard() {
        System.out.println("Processing credit card payment");
    }
}

public class PaymentSystemSolution {
    public static void main(String[] args) {
        CreditCardPayment processor = new CreditCardProcessor();
        processor.processCreditCard(); // Works fine, no unused methods
    }
}