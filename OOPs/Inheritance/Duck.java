package Java_Bootcamp.OOPs.Inheritance;

final class Duck extends Animal implements Flyable, Swimmable { // final class
    public Duck(String species) {
        super(species);
    }

    @Override
    public void makeSound() {
        System.out.println(species + " says Quack!");
    }

    @Override
    public void fly() {
        System.out.println(species + " is flying");
    }

    @Override
    public void swim() {
        System.out.println(species + " is swimming");
    }
}
