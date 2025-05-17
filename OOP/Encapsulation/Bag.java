package Java_Bootcamp.OOP.Encapsulation;

class Bag {

    private String color;
    private double price;


    public void setColor(String color){
        this.color = color;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

}