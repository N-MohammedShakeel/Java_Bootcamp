package Java_Bootcamp.DSA.Basic.String.Medium;

// CheckStringRotationMethod2.java
// Checks rotation by manually rotating characters
// Time: O(n^2), Space: O(n)

public class CheckStringRotationMethod2 {
    public static void main(String[] args) {
        // Test case
        System.out.println("Check if Strings are Rotations (Method 2): " + checkStringIsRotationOfAnotherMethod2("waterbottle", "erbottlewat")); // true
    }

    // Checks rotation by manually rotating characters
    // Time: O(n^2), Space: O(n)
    public static boolean checkStringIsRotationOfAnotherMethod2(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        char[] arr = str1.toCharArray();
        int n = arr.length;
        int k = 0;
        while (k < arr.length) {
            char temp = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = temp;
            String res = new String(arr);
            if (str2.equals(res)) {
                return true;
            }
            k++;
        }
        return false;
    }
}