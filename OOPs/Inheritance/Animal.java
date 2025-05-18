package Java_Bootcamp.OOPs.Inheritance;

// Superclass for all examples
class Animal {
    protected String species;
    protected final int BASE_LIFESPAN = 10; // final variable

    public Animal(String species) {
        this.species = species;
    }

    public void makeSound() {
        System.out.println(species + " makes a sound");
    }

    public final void eat() { // final method
        System.out.println(species + " is eating");
    }
}
