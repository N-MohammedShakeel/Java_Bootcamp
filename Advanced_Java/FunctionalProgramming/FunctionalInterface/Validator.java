package Java_Bootcamp.Advanced_Java.FunctionalProgramming.FunctionalInterface;

// Custom functional interface with one abstract method
@FunctionalInterface
interface Validator {
    boolean isValid(int value);
}
