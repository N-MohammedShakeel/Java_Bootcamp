package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.Stack;

// Problem 4: Convert Infix to Postfix
// Statement: Convert an infix expression to postfix (e.g., "a+b*(c-d)" to "abcd-*+").
// Sample Test Cases:
// Input: "a+b*(c-d)" -> Output: "abcd-*+"
// Input: "(a+b)*c" -> Output: "ab+c*"
// TC: O(n), SC: O(n)
class InfixToPostfix {
    private static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    public static String convert(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
}
