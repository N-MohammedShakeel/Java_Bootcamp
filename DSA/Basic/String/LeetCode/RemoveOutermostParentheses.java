package Java_Bootcamp.DSA.Basic.String.LeetCode;


// Link: https://leetcode.com/problems/remove-outermost-parentheses/

// Problem Statement:
// A valid parentheses string is either:
//   - "()" or
//   - A concatenation of two valid strings or
//   - A string wrapped in a pair of parentheses: "(A)", where A is valid.
// A primitive is a non-empty valid string that cannot be split further into two valid non-empty parts.
// Given a valid parentheses string s, remove the outermost parentheses of every primitive and return the result.

// Example:
// Input: s = "(()())(())"
// Output: "()()()"

// --- My Approach ---
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        char[] arr = s.toCharArray();
        String res = "";
        int left = 0;
        int right = 0;
        int count = 0;
        int i = 0;

        while (right < arr.length - 1) {
            if (arr[i] == '(') {
                count++;
            } else if (arr[i] == ')') {
                count--;
            }

            while (count != 0) {
                i++;
                if (arr[i] == '(') {
                    count++;
                } else if (arr[i] == ')') {
                    count--;
                }
                if (count == 0) {
                    right = i;
                }
            }

            // Exclude the outermost parentheses
            for (int j = left + 1; j < right; j++) {
                res += arr[j];
            }

            left = right + 1;
            i++;
        }

        System.out.println(res);
    }
}

// --- Explanation ---
// The idea is to split the string into primitive valid parentheses blocks.
// Use two pointers (left and right) and a count to track balance.
// When count becomes zero, we find a complete primitive.
// Then we append the inner part (excluding the outermost '(' and ')').

// --- Optimal Approach (Using Balance Counter and StringBuilder) ---
class OptimalSolution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0) sb.append(c); // Not the outermost
                count++;
            } else {
                count--;
                if (count > 0) sb.append(c); // Not the outermost
            }
        }

        return sb.toString();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
