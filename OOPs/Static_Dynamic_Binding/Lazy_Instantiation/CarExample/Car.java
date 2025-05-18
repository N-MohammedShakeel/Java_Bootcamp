package Java_Bootcamp.OOPs.Static_Dynamic_Binding.Lazy_Instantiation.CarExample;

public class Car {

    private String brand;
    private String model;
    private String colour;
    private Radio r;

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

    public void addRadio(String model , double price){
        if (r == null) {
            r = new Radio(model, price);
            System.out.println("Radio is Added");
        }else{
            System.out.println("Radio already present");
        }
    }

    public void removeRadio(){
        if (r != null) {
            r = null;
            System.out.println("Radio is Removed");
        }else{
            System.out.println("Radio already removed");
        }
    }

    public Car(String brand, String model, String colour) {
        this.brand = brand;
        this.model = model;
        this.colour = colour;
    }


    public void printCarDetails(){

        String radioStatus = r == null ? "Not Present" : "Present" ;
        System.out.println("Brand: " + getBrand() + "\nModal: " + getModel() + "\nColour: " + getColour() + "\nRadio Status: " + radioStatus);
    }
}


