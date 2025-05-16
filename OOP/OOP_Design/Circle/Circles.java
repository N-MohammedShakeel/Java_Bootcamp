package Java_Bootcamp.OOP.OOP_Design.Circle;

// Utility Class
public class Circles {

    public static double calculateArea(Circle c){
        return 3.14 * c.getRadius() * c.getRadius();
    }

    public static double calculatePerimeter(Circle c){
        return 2 * 3.14 * c.getRadius();
    }

    public static double calculateDiameter(Circle c){
        return 2 * c.getRadius() * c.getRadius();
    }
}
