package Java_Bootcamp.Methods;

public class GenericMethodExample {

    // Generic method that takes any type T and prints it
    public static <T> void printData(T data) {
        System.out.println("Data: " + data);
    }

    // Generic method that takes two parameters of any type and prints them
    public static <T, U> void printTwoData(T data1, U data2) {
        System.out.println("Data 1: " + data1);
        System.out.println("Data 2: " + data2);
    }

    public static void main(String[] args) {
        // Integer
        printData(123);

        // String
        printData("Hello, World!");

        // Double
        printData(45.67);

        // Boolean
        printData(true);

        // Custom object example
        Person1 p = new Person1("Alice", 30);
        printData(p);

        // Two different types
        printTwoData("Age", 30);
        printTwoData(100, 99.99);
    }
}

// Simple custom class
class Person1 {
    String name;
    int age;

    public Person1(String n, int a) {
        this.name = n;
        this.age = a;
    }

    @Override
    public String toString() {
        return "Person1{name='" + name + "', age=" + age + "}";
    }
}
