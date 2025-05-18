package Java_Bootcamp.OOP.Polymophism;

class Cat extends Animal {
    private String color;

    public Cat(String species, String color) {
        super(species);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println(color + " cat says Meow!");
    }
}
