package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.Stack;

// Problem 8: Reverse Stack Using Recursion
// Statement: Reverse a stack using recursion without extra space (except recursion stack).
// Sample Test Cases:
// Input: [1,2,3,4,5] -> Output: [5,4,3,2,1]
// Input: [10] -> Output: [10]
// TC: O(n^2), SC: O(n) (recursion stack)
class ReverseStack {
    public static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverse(stack);
            insertAtBottom(stack, temp);
        }
    }

    private static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            int temp = stack.pop();
            insertAtBottom(stack, x);
            stack.push(temp);
        }
    }
}
