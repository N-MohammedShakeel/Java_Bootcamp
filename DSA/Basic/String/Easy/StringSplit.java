package Java_Bootcamp.DSA.Basic.String.Easy;

import java.util.*;

// StringSplit.java
// Splits string based on a delimiter and prints result
// Time: O(n), Space: O(n)

public class StringSplit {
    public static void main(String[] args) {
        // Test case
        System.out.println("String Split: ");
        stringSplit(); // [He, , o wor, d]
    }

    // Splits string based on a delimiter and prints result
    // Time: O(n), Space: O(n)
    public static void stringSplit() {
        String sen = "Hello world";
        System.out.println(Arrays.toString(sen.split("l")));
    }
}