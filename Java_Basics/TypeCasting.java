package Java_Bootcamp.Java_Basics;

import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1 = input.nextInt();
        System.out.println(num1);

        // type casting
        int num = (int)(67.56f);
        System.out.println(num);

        // automatic type promotion in expressions
        int a1 = 257;
        byte b1 = (byte)(a1); // 257 % 256 = 1


        byte b = 42;
        char c = 'a';
        short s = 1024;
        int i = 50000;
        float f = 5.67f;
        double d = 0.1234;
        double result = (f * b) + (i / c) - (d * s);
        // float + int - double = double
        System.out.println((f * b) + " " + (i / c) + " " + (d * s));
        System.out.println(result);
    }
}