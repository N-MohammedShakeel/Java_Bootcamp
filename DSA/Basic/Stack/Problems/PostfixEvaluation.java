package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.Stack;

// Problem 3: Evaluate Postfix Expression
// Statement: Evaluate a postfix expression (e.g., "231*+9-").
// Sample Test Cases:
// Input: "231*+9-" -> Output: 4
// Input: "123+*4-" -> Output: 2
// TC: O(n), SC: O(n)
class PostfixEvaluation {
    public static int evaluate(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
