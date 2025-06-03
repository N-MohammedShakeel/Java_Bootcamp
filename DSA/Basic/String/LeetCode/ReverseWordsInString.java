package Java_Bootcamp.DSA.Basic.String.LeetCode;

// Link: https://leetcode.com/problems/reverse-words-in-a-string/

public class ReverseWordsInString {

    // --- Problem Statement ---
    /*
        Given an input string `s`, reverse the order of the words.

        Notes:
        - A word is defined as a sequence of non-space characters.
        - The words are separated by at least one space.
        - Return a string with the words in reverse order.
        - Your reversed string should not contain:
            - Leading or trailing spaces
            - More than one space between two words

        Examples:

        Input:  "  hello world  "
        Output: "world hello"

        Input:  "a good   example"
        Output: "example good a"
    */

    // --- ✅ My Approach (Accepted) ---
    public String reverseWords(String s) {
        // Step 1: Trim leading and trailing spaces
        // Step 2: Split the string into words using "\\s+" (one or more spaces)
        String[] arr = s.trim().split("\\s+");

        // Step 3: Use StringBuilder to efficiently build the reversed sentence
        StringBuilder res = new StringBuilder();

        // Step 4: Append words in reverse order with a space in between
        for (int i = arr.length - 1; i > 0; i--) {
            res.append(arr[i]).append(" ");
        }

        // Step 5: Append the last word without a trailing space
        res.append(arr[0]);

        return res.toString();
    }

    /*
        --- ✅ Explanation ---
        - `trim()` removes extra spaces at the beginning and end.
        - `split("\\s+")` breaks the string into words, ignoring multiple spaces.
        - A reverse loop appends words in reverse order with exactly one space.
        - We avoid trailing spaces by handling the last word separately.

        Time Complexity: O(n) — We traverse the string once and build a new string.
        Space Complexity: O(n) — For storing the split words and result string.
    */

    // --- 🔁 Optimal Approach (Clean & Efficient) ---
    public String reverseWordsOptimal(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        // Efficient single-pass with cleaner condition
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }

    // --- 🧪 Testing ---
    public static void main(String[] args) {
        ReverseWordsInString obj = new ReverseWordsInString();

        String test1 = "  hello world  ";
        String test2 = "a good   example";
        String test3 = "   fly me   to   the moon  ";

        System.out.println(obj.reverseWords(test1));  // Output: "world hello"
        System.out.println(obj.reverseWords(test2));  // Output: "example good a"
        System.out.println(obj.reverseWords(test3));  // Output: "moon the to me fly"
    }
}
