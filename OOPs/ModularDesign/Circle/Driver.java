package Java_Bootcamp.OOPs.ModularDesign.Circle;

// Driver Class
public class Driver {

    public static void main(String[] args) {

        Circle c = new Circle();
        c.setRadius(20);

        System.out.println("Area : " + Circles.calculateArea(c));
        System.out.println("Perimeter : " + Circles.calculatePerimeter(c));
        System.out.println("Diameter : " + Circles.calculateDiameter(c));

    }

}
