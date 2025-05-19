package Java_Bootcamp.AdvancedJava.FunctionalProgramming.FunctionalInterface;

// Custom functional interface
@FunctionalInterface
interface StringProcessor {
    String process(String input);

    // Default method
    default String toUpperCase(String input) {
        return input.toUpperCase();
    }

    // Static method
    static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
