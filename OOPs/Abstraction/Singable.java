package Java_Bootcamp.OOPs.Abstraction;

interface Singable {
    void sing(); // Abstract method

    default void describeSong() {
        System.out.println("This object can sing");
    }
}
