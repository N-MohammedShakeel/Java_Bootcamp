package Java_Bootcamp.OOP.Polymophism;

class Animal {
    protected String species;

    public Animal(String species) {
        this.species = species;
    }

    public void makeSound() {
        System.out.println(species + " makes a generic sound");
    }

    // Overloaded method
    public void displayInfo() {
        System.out.println(species);
    }

    // Overloaded method
    public void getDetails(String detail) {
        System.out.println(species + " Detail: " + detail);
    }
}
