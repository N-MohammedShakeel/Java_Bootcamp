package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.DSA.List_Interface;

import java.util.Stack;

public class Intro_Stack {
    public static void main(String[] args) {


//        The Java collections framework has a class named Stack that provides the functionality of the stack data structure.
//        The Stack class extends the Vector class. In stack, elements are stored and accessed in Last In First Out manner.
//        That is, elements are added to the top of the stack and removed from the top of the stack.


        Stack<String> s = new Stack<>();

        // inserting Element into the stack
        s.push("C");
        s.push("java");
        s.push("kotlin");
        s.push("javascript");
        s.push("rust");

        System.out.println(s); // [C, java, kotlin, javascript, rust]

        System.out.println(s.search("java")); // 4 (because it counts from last)

        s.pop(); // removes rust


        for(String e : s){   // prints all data in the stack
            System.out.println(e);
        }
    }
}
