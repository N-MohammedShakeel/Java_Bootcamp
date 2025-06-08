package Java_Bootcamp.DSA.Basic.String.Medium;

// StringClockwiseRotation.java
// Rotates a string clockwise by k positions
// Time: O(n*k), Space: O(n)

public class StringClockwiseRotation {
    public static void main(String[] args) {
        // Test case
        System.out.println("String Clockwise Rotation: ");
        stringClockwiseRotation("hello", 2); // lohel
    }

    // Rotates a string clockwise by k positions
    // Time: O(n*k), Space: O(n)
    public static void stringClockwiseRotation(String str, int k) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        k = k % n;
        while (k > 0) {
            char temp = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = temp;
            k--;
        }
        System.out.println(new String(arr));
    }
}