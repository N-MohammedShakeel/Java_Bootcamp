package Java_Bootcamp.AdvancedJava.FunctionalProgramming.FunctionalInterface;

// Custom functional interface with one abstract method
@FunctionalInterface
interface Validator {
    boolean isValid(int value);
}
