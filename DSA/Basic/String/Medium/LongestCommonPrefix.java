package Java_Bootcamp.DSA.Basic.String.Medium;

// LongestCommonPrefix.java
// Finds the longest common prefix among an array of strings
// Time: O(n*m), Space: O(1)

public class LongestCommonPrefix {
    public static void main(String[] args) {
        // Test case
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
    }

    // Finds the longest common prefix among an array of strings
    // Time: O(n*m), Space: O(1)
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[2];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}