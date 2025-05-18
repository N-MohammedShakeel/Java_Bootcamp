package Java_Bootcamp.OOP.Abstraction;

interface Flyable {
    void fly(); // Abstract method

    default void describeFlight() {
        System.out.println("This object can fly");
    }

    static void flightInfo() {
        System.out.println("Flight capability defined by Flyable interface");
    }
}
