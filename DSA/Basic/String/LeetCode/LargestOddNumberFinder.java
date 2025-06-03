package Java_Bootcamp.DSA.Basic.String.LeetCode;// ✅ Problem: Find the largest-valued odd number that is a non-empty prefix of the string `num`
// 🔗 Link: https://leetcode.com/problems/largest-odd-number-in-string/

public class LargestOddNumberFinder {

    // --- 📜 Problem Statement ---
    /*
        You are given a string `num` representing a large integer.
        Return the largest-valued odd number (as a string) that is a non-empty prefix of `num`.
        If no such odd number exists, return an empty string "".
    */

    // --- ❌ My Initial (Inefficient) Approach ---
    public String largestOddNumber(String num) {
        while (!num.isEmpty()) {
            char s = num.charAt(num.length() - 1);

            // Check if the last character is odd
            if (Integer.parseInt(String.valueOf(s)) % 2 == 1) {
                return num;
            }

            // Manually remove the last character (inefficient string concatenation)
            String res = "";
            for (int i = 0; i < num.length() - 1; i++) {
                res += num.charAt(i);  // O(n²) time due to repeated string creation
            }
            num = res;
        }
        return "";
    }

    // --- ✅ Optimal Approach ---
    public String largestOddNumberOptimal(String num) {
        int i = num.length() - 1;

        // Traverse from the end to find the first odd digit
        while (i >= 0) {
            if ((num.charAt(i) - '0') % 2 == 1) {  // Check if digit is odd
                return num.substring(0, i + 1);     // Return substring up to and including the odd digit
            }
            i--;
        }

        return "";
    }

    // --- 🧪 Testing the methods ---
    public static void main(String[] args) {
        LargestOddNumberFinder finder = new LargestOddNumberFinder();

        // Test cases
        System.out.println(finder.largestOddNumber("52"));        // Output: "5"
        System.out.println(finder.largestOddNumber("4206"));      // Output: ""
        System.out.println(finder.largestOddNumber("35427"));     // Output: "35427"

        System.out.println(finder.largestOddNumberOptimal("52"));     // Output: "5"
        System.out.println(finder.largestOddNumberOptimal("4206"));   // Output: ""
        System.out.println(finder.largestOddNumberOptimal("35427"));  // Output: "35427"
    }
}
