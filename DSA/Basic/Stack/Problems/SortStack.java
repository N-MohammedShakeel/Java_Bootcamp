package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.Stack;

// Problem 10: Sort a Stack
// Statement: Sort a stack in ascending order using only stack operations.
// Sample Test Cases:
// Input: [34,3,31,98,92,23] -> Output: [3,23,31,34,92,98]
// Input: [5,2,8,1] -> Output: [1,2,5,8]
// TC: O(n^2), SC: O(n)
class SortStack {
    public static void sort(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}
