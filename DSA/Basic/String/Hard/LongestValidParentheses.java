package Java_Bootcamp.DSA.Basic.String.Hard;

import java.util.*;

// LongestValidParentheses.java
// Finds the length of the longest valid parentheses substring
// Time: O(n), Space: O(n)

public class LongestValidParentheses {
    public static void main(String[] args) {
        // Test case
        System.out.println("Longest Valid Parentheses: " + longestValidParentheses("(()))")); // 4
    }

    // Finds the length of the longest valid parentheses substring
    // Time: O(n), Space: O(n)
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}