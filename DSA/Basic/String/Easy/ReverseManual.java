package Java_Bootcamp.DSA.Basic.String.Easy;

// ReverseManual.java
// Reverses string manually by building a new string
// Time: O(n), Space: O(n)

public class ReverseManual {
    public static void main(String[] args) {
        // Test case
        System.out.println("Reverse: " + reverse("hello")); // olleh
    }

    // Reverses string manually by building a new string
    // Time: O(n), Space: O(n)
    public static String reverse(String str) {
        if (str.isEmpty()) {
            return "atleast 1 character";
        }
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }
}