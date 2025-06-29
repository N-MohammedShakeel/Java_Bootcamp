package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.Stack;

// Problem 6: Valid Parentheses Sequence
// Statement: Check if a sequence of pushed and popped elements forms a valid stack sequence.
// Sample Test Cases:
// Input: pushed=[1,2,3,4,5], popped=[4,5,3,2,1] -> Output: true
// Input: pushed=[1,2,3,4,5], popped=[4,3,5,1,2] -> Output: false
// TC: O(n), SC: O(n)
class ValidStackSequence {
    public static boolean validateSequence(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
