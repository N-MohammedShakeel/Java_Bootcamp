package Java_Bootcamp.OOPs.Abstraction;

@FunctionalInterface
interface Processor {
    void process(); // Single abstract method

    // Additional default or static methods allowed
    default void reset() {
        System.out.println("Processor reset");
    }
}
