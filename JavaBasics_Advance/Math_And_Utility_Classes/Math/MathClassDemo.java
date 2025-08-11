package Java_Bootcamp.JavaBasics_Advance.Math_And_Utility_Classes.Math;

/**
 * MathClassDemo.java
 * Demonstrates Math class methods for numerical computations.
 * Scenario: Calculate distance between two points using sqrt and pow.
 * Features: Uses Math.sqrt(), Math.pow(), and input validation.
 * DSA Relevance: Numerical algorithms, distance calculation.
 */
public class MathClassDemo {
    public static void main(String[] args) {
        System.out.println("=== Math Class Demo ===");
        // Example usage of Math methods
        System.out.println("Absolute value of -5: " + Math.abs(-5)); // 5
        System.out.println("2^3: " + Math.pow(2, 3)); // 8.0
        System.out.println("Square root of 16: " + Math.sqrt(16)); // 4.0
        System.out.println("Random [0,1): " + Math.random());
        System.out.println("Round 3.6: " + Math.round(3.6)); // 4
        System.out.println("Floor 3.7: " + Math.floor(3.7)); // 3.0
        System.out.println("Ceiling 3.2: " + Math.ceil(3.2)); // 4.0
        System.out.println("Max of 5, 10: " + Math.max(5, 10)); // 10
        System.out.println("Sin(90 degrees): " + Math.sin(Math.toRadians(90))); // 1.0

        // Practice Task: Calculate distance between two points
        System.out.println("\n=== Practice Task: Distance Between Points ===");
        double x1 = 1.0, y1 = 2.0, x2 = 4.0, y2 = 6.0;
        try {
            double dx = x2 - x1;
            double dy = y2 - y1;
            double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            if (Double.isNaN(distance) || Double.isInfinite(distance)) {
                throw new ArithmeticException("Invalid distance calculation");
            }
            System.out.printf("Distance between (%.1f, %.1f) and (%.1f, %.1f): %.2f%n", 
                              x1, y1, x2, y2, distance);
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}