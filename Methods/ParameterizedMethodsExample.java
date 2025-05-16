package Java_Bootcamp.Methods;

import java.lang.String;

public class ParameterizedMethodsExample {

    // Method for int parameter
    public static void printData(int data) {
        System.out.println("Integer data: " + data);
    }

    // Method for double parameter
    public static void printData(double data) {
        System.out.println("Double data: " + data);
    }

    // Method for boolean parameter
    public static void printData(boolean data) {
        System.out.println("Boolean data: " + data);
    }

    // Method for String parameter
    public static void printData(String data) {
        System.out.println("String data: " + data);
    }

    // Method for custom object parameter
    public static void printData(Person1 data) {
        System.out.println("Person1 data: " + data);
    }

    public static void main(String[] args) {
        printData(42);
        printData(3.1415);
        printData(true);
        printData("Hello Java!");
        printData(new Person1("Bob", 25));
    }
}

class Person {
    String name;
    int age;

    public Person(String n, int a) {
        this.name = n;
        this.age = a;
    }

    public String toString() {
        return "Person1{name='" + name + "', age=" + age + "}";
    }
}

