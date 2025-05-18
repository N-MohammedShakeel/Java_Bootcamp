package Java_Bootcamp.OOPs.Static_Dynamic_Binding.Lazy_Instantiation;


import Java_Bootcamp.OOPs.Static_Dynamic_Binding.Lazy_Instantiation.CarExample.Car;

public class Main {

    public static void main(String[] args) {

        Car c1 = new Car("Toyota","Supra","Black");
        c1.printCarDetails();

        c1.addRadio("ABC" , 10000);
        c1.printCarDetails();

        c1.removeRadio();
        c1.printCarDetails();
    }
}
