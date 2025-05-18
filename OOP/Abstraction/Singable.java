package Java_Bootcamp.OOP.Abstraction;

interface Singable {
    void sing(); // Abstract method

    default void describeSong() {
        System.out.println("This object can sing");
    }
}
