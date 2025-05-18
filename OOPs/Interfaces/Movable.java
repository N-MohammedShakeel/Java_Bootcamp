package Java_Bootcamp.OOPs.Interfaces;

// Interface with abstract and default methods
interface Movable {
    // Abstract method
    void move();

    // Default method
    default void describeMovement() {
        System.out.println("This object is moving");
    }

    // Static method
    static void movementInfo() {
        System.out.println("Movable interface defines movement behavior");
    }

    // Constant
    int MAX_SPEED = 100;
}
