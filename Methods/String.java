package Java_Bootcamp.Methods;

import java.util.Scanner;
public class String {

    public static void main(String[] args) {


        Scanner in  = new Scanner(System.in);
        System.out.print("Enter your name: ");
        var name = in.next();
        String personalised = myGreet(name);
        System.out.println(personalised);
    }

    static String myGreet(java.lang.String name) {
        String message = myGreet("Hello " + name);
        return message;
    }


    static String greet() {
        String greeting = myGreet("how are you");
        return greeting;
    }
}