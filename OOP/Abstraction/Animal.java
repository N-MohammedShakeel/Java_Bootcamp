package Java_Bootcamp.OOP.Abstraction;

abstract class Animal {
    protected String species;

    public Animal(String species) {
        this.species = species;
    }

    // Abstract method
    abstract void makeSound();

    // Concrete method
    public void eat() {
        System.out.println(species + " is eating");
    }
}
