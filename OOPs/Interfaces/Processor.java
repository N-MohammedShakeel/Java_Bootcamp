package Java_Bootcamp.OOPs.Interfaces;

// Functional interface
@FunctionalInterface
interface Processor {
    // Single abstract method
    void process();

    // Default method (does not affect functional interface status)
    default void reset() {
        System.out.println("Processor reset");
    }
}
