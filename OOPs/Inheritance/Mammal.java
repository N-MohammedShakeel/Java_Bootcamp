package Java_Bootcamp.OOPs.Inheritance;

// Multilevel Inheritance Example
class Mammal extends Animal {
    protected boolean hasFur;

    public Mammal(String species, boolean hasFur) {
        super(species);
        this.hasFur = hasFur;
    }

    public void displayFurStatus() {
        System.out.println(species + " has fur: " + hasFur);
    }
}
