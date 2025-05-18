package Java_Bootcamp.OOPs.Static_Dynamic_Binding.Early_Instantiation;

import Java_Bootcamp.OOPs.Static_Dynamic_Binding.Early_Instantiation.CarExample.Car;
import Java_Bootcamp.OOPs.Static_Dynamic_Binding.Early_Instantiation.CarExample.Engine;

public class Main {

    public static void main(String[] args) {

        Engine e1 = new Engine(1500);
        Car c1 = new Car(e1,"Toyota","Supra","Black");
        c1.printCarDetails();
    }
}
