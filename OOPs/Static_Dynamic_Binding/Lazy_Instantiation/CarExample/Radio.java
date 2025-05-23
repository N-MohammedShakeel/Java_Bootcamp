package Java_Bootcamp.OOPs.Static_Dynamic_Binding.Lazy_Instantiation.CarExample;

public class Radio {

    private String model;
    private double price;

    public Radio(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
