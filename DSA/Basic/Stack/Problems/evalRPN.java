package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.Stack;

public class evalRPN {
    public static void main(String[] args) {

        evalRPN();
    }

    public static void evalRPN() { // Reverse Polish Notation

        String[] tokens = new String[] { "2", "1", "+", "3", "*" };

        int returnValue = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (t) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        returnValue = Integer.valueOf(stack.pop());
        System.out.println(returnValue);
    }
}
