package Java_Bootcamp.OOPs.Inheritance;

class Labrador extends Mammal {
    private String name;

    public Labrador(String species, boolean hasFur, String name) {
        super(species, hasFur);
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " Labrador says Bark!");
    }
}
