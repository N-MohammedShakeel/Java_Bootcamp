package Java_Bootcamp.OOPs.Static_Dynamic_Binding.Early_Instantiation.CarExample;

public class Car {

    private String brand;
    private String model;
    private String colour;
    private Engine e;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getE1() {
        return e;
    }

    public Car(Engine e, String brand, String model, String colour) {
        this.e = e;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
    }


    public void printCarDetails(){
        System.out.println("Brand: " + getBrand() + "\nModal: " + getModel() + "\nColour: " + getColour() + "hp: " + getE1().getHp());
    }
}


