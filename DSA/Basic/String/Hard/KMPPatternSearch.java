package Java_Bootcamp.DSA.Basic.String.Hard;

// KMPPatternSearch.java
// Implements Knuth-Morris-Pratt algorithm for pattern searching
// Time: O(n+m), Space: O(m)

public class KMPPatternSearch {
    public static void main(String[] args) {
        // Test case
        System.out.println("KMP Pattern Search: " + kmpSearch("ABABDABACDABABCABAB", "ABABCABAB")); // 10
    }

    // Implements Knuth-Morris-Pratt algorithm for pattern searching
    // Time: O(n+m), Space: O(m)
    public static int kmpSearch(String text, String pattern) {
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                return i - j;
            }
            if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }

    private static int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }
}