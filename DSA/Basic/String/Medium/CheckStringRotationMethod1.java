package Java_Bootcamp.DSA.Basic.String.Medium;

// CheckStringRotationMethod1.java
// Checks if one string is a rotation of another using concatenation
// Time: O(n), Space: O(n)

public class CheckStringRotationMethod1 {
    public static void main(String[] args) {
        // Test case
        System.out.println("Check if Strings are Rotations (Method 1): " + checkStringIsRotationOfAnotherMethod1("waterbottle", "erbottlewat")); // true
    }

    // Checks if one string is a rotation of another using concatenation
    // Time: O(n), Space: O(n)
    public static boolean checkStringIsRotationOfAnotherMethod1(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        return (str1 + str1).contains(str2);
    }
}