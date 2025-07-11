package Java_Bootcamp.SOLID_Principle.OCP;// DiscountCalculatorSolution.java
// Demonstrates adherence to the Open/Closed Principle (OCP)
// Open for extension (new discount types) but closed for modification

// Interface for discount strategies
interface DiscountStrategy {
    double calculateDiscount(double price);
}

// Concrete strategy for student discount
class StudentDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double price) {
        return price * 0.1; // 10% discount
    }
}

// Concrete strategy for senior discount
class SeniorDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double price) {
        return price * 0.15; // 15% discount
    }
}

// Main class to apply discounts
public class DiscountCalculatorSolution {
    private final DiscountStrategy strategy;

    // Constructor injection for strategy
    public DiscountCalculatorSolution(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateDiscount(double price) {
        return strategy.calculateDiscount(price);
    }

    public static void main(String[] args) {
        // Create calculators with different strategies
        DiscountCalculatorSolution studentCalc = new DiscountCalculatorSolution(new StudentDiscount());
        DiscountCalculatorSolution seniorCalc = new DiscountCalculatorSolution(new SeniorDiscount());

        System.out.println("Student discount on $100: " + studentCalc.calculateDiscount(100));
        System.out.println("Senior discount on $100: " + seniorCalc.calculateDiscount(100));
        // New discount types can be added by creating new strategy classes without modifying this class
    }
}