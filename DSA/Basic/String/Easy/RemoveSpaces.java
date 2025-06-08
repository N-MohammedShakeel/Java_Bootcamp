package Java_Bootcamp.DSA.Basic.String.Easy;

// RemoveSpaces.java
// Removes all spaces using regex
// Time: O(n), Space: O(n)

public class RemoveSpaces {
    public static void main(String[] args) {
        // Test case
        System.out.println("Remove Spaces: " + removeSpaces("  hello  world  ")); // helloworld
    }

    // Removes all spaces using regex
    // Time: O(n), Space: O(n)
    public static String removeSpaces(String s) {
        return s.replaceAll("\\s", "");
    }
}