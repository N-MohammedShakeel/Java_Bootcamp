package Java_Bootcamp.DSA.Basic.String.Easy;

// PrintString.java
// Prints each character of a string in multiple ways
// Time: O(n), Space: O(1)

public class PrintString {
    public static void main(String[] args) {
        // Test case
        System.out.println("Print String Characters: ");
        printString(); // prints each character of "Hello"
    }

    // Prints each character of a string in multiple ways
    // Time: O(n), Space: O(1)
    public static void printString() {
        String s1 = "Hello";
        // Using index-based loop
        for (int i = 0; i < s1.length(); i++) {
            System.out.println(s1.charAt(i));
        }
        System.out.println("------------");
        // Using enhanced for loop
        for (char ch : s1.toCharArray()) {
            System.out.println(ch);
        }
        System.out.println("------------");
        // Print character array
        System.out.println(s1.toCharArray());
    }
}