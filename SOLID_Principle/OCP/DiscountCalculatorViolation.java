package Java_Bootcamp.SOLID_Principle.OCP;// DiscountCalculatorViolation.java
// Demonstrates a violation of the Open/Closed Principle (OCP)
// Modifying the class to add new discount types

public class DiscountCalculatorViolation {
    // Violation: New discount types require modifying this class
    public double calculateDiscount(String discountType, double price) {
        if (discountType.equals("Student")) {
            return price * 0.1; // 10% discount
        } else if (discountType.equals("Senior")) {
            return price * 0.15; // 15% discount
        } else {
            return 0.0; // No discount
        }
    }

    public static void main(String[] args) {
        DiscountCalculatorViolation calc = new DiscountCalculatorViolation();
        System.out.println("Student discount on $100: " + calc.calculateDiscount("Student", 100));
        System.out.println("Senior discount on $100: " + calc.calculateDiscount("Senior", 100));
        // Adding a new discount type (e.g., "Military") requires modifying this class
    }
}