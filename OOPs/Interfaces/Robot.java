package Java_Bootcamp.OOPs.Interfaces;

// Class implementing multiple interfaces
class Robot implements Movable, Speakable, Processor {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " robot is moving at speed up to " + MAX_SPEED);
    }

    @Override
    public void speak() {
        System.out.println(name + " robot says: Beep Boop!");
    }

    @Override
    public void process() {
        System.out.println(name + " robot is processing data");
    }

    // Override default method to customize or resolve conflicts
    @Override
    public void describeMovement() {
        Movable.super.describeMovement();
        System.out.println(name + " robot moves with precision");
    }
}
