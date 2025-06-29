package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.Stack;

// Problem 2: Check Balanced Parentheses
// Statement: Check if a string with parentheses is balanced.
// Sample Test Cases:
// Input: "({[]})" -> Output: true
// Input: "([)]" -> Output: false
// TC: O(n), SC: O(n)
class BalancedParentheses {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
