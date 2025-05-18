package Java_Bootcamp.OOPs.Interfaces;

// Interface with abstract and default methods
interface Speakable {
    // Abstract method
    void speak();

    // Default method
    default void describeSpeech() {
        System.out.println("This object can speak");
    }
}
