package Java_Bootcamp.OOP.Inheritance;

// Single Inheritance Example
class Dog extends Animal {
    private String breed;

    public Dog(String species, String breed) {
        super(species);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(breed + " dog says Woof!");
    }

    public void fetch() {
        System.out.println(breed + " dog is fetching a ball");
    }
}
