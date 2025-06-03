package Java_Bootcamp.DSA.Basic.String.LeetCode;// ✅ Link:
// https://leetcode.com/problems/longest-common-prefix/

// --- 📜 Problem Statement ---
// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".

// --- 💡 My Approach ---
/*
1. Start by assuming the first string is the longest common prefix.
2. For each subsequent string, check if it starts with the current prefix.
3. If not, reduce the prefix one character at a time from the end until it matches.
4. If the prefix becomes empty, return "" (no common prefix).
*/

// --- ✅ My Final Working Code ---
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0) return "";

        String s = arr[0];  // Step 1: initial prefix = first word

        for (int i = 1; i < arr.length; i++) {
            // Step 2: shrink prefix until it matches the start of current word
            while (!arr[i].startsWith(s)) {
                s = s.substring(0, s.length() - 1);
                if (s.isEmpty()) return "";
            }
        }

        return s;
    }

    public static void main(String[] args) {
        String[] arr1 = {"flower", "flow", "flight"};
        String[] arr2 = {"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix(arr1));  // Output: "fl"
        System.out.println(longestCommonPrefix(arr2));  // Output: ""
    }
}

// --- 📘 Explanation ---
/*
- We take the first string as the "candidate" prefix.
- Then we iteratively shorten it while checking against each word.
- We stop early if the prefix becomes empty.
- Efficient because we avoid character-by-character comparison across all strings.
*/

// --- 🧠 Optimal Approach by Me (Same as Yours) ---
/*
This is already optimal using the **prefix shrink** method with `startsWith()`.
Alternative optimal methods include:

1. **Vertical Scanning:**
   - Check each character column-wise across strings.

2. **Divide and Conquer / Binary Search:**
   - Divide the array and merge results (for very large input sets).
   - But adds complexity and often unnecessary.

This prefix-shrinking loop is clean, intuitive, and performant for most inputs.
*/

// --- ⏱ Time & Space Complexity ---
/*
- Time: O(N * M), where N = number of strings, M = average length of strings
- Space: O(1) auxiliary (excluding output)
*/
