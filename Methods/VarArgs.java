package Java_Bootcamp.Methods;

import java.util.Arrays;

public class VarArgs {

    public static void printInts(int... nums) {
        System.out.print("Ints: ");
        for (int n : nums) System.out.print(n + " ");
        System.out.println();
    }

    public static void printDoubles(double... nums) {
        System.out.print("Doubles: ");
        for (double n : nums) System.out.print(n + " ");
        System.out.println();
    }

    public static void printLongs(long... nums) {
        System.out.print("Longs: ");
        for (long n : nums) System.out.print(n + " ");
        System.out.println();
    }

    public static void printFloats(float... nums) {
        System.out.print("Floats: ");
        for (float n : nums) System.out.print(n + " ");
        System.out.println();
    }

    public static void printChars(char... chars) {
        System.out.print("Chars: ");
        for (char c : chars) System.out.print(c + " ");
        System.out.println();
    }

    public static void printBooleans(boolean... bools) {
        System.out.print("Booleans: ");
        for (boolean b : bools) System.out.print(b + " ");
        System.out.println();
    }

    public static void printBytes(byte... bytes) {
        System.out.print("Bytes: ");
        for (byte b : bytes) System.out.print(b + " ");
        System.out.println();
    }

    public static void printShorts(short... shorts) {
        System.out.print("Shorts: ");
        for (short s : shorts) System.out.print(s + " ");
        System.out.println();
    }

    public static void printStrings(String... strs) {
        System.out.print("Strings: ");
        for (String s : strs) System.out.print(s + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        printInts(1, 2, 3, 4);
        printDoubles(1.1, 2.2, 3.3);
        printLongs(100000L, 200000L);
        printFloats(1.0f, 2.5f, 3.5f);
        printChars('a', 'b', 'c');
        printBooleans(true, false, true);
        printBytes((byte) 1, (byte) 2);
        printShorts((short) 10, (short) 20);
        printStrings("hello", "world");
    }



}
