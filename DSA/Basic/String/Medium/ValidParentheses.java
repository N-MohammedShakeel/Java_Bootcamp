package Java_Bootcamp.DSA.Basic.String.Medium;

import java.util.*;

// ValidParentheses.java
// Checks if parentheses are valid using a stack
// Time: O(n), Space: O(n)

public class ValidParentheses {
    public static void main(String[] args) {
        // Test case
        System.out.println("Valid Parentheses: " + isValidParentheses("()[]{}")); // true
    }

    // Checks if parentheses are valid using a stack
    // Time: O(n), Space: O(n)
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else if (stack.isEmpty() || !matches(stack.pop(), c)) return false;
        }
        return stack.isEmpty();
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}