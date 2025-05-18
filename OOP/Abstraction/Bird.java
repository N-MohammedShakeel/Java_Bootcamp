package Java_Bootcamp.OOP.Abstraction;

class Bird extends Animal implements Flyable, Singable, Processor {
    private String name;

    public Bird(String species, String name) {
        super(species);
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " bird chirps");
    }

    @Override
    public void fly() {
        System.out.println(name + " bird is flying");
    }

    @Override
    public void sing() {
        System.out.println(name + " bird is singing a song");
    }

    @Override
    public void process() {
        System.out.println(name + " bird is processing data");
    }

    // Override default method to resolve potential conflicts or customize
    @Override
    public void describeFlight() {
        Flyable.super.describeFlight(); // Call Flyable's default method
        System.out.println(name + " bird flies gracefully");
    }
}
