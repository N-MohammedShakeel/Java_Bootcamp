package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.Stack;

// Problem 5: Next Greater Element
// Statement: Find the next greater element for each element in an array.
// Sample Test Cases:
// Input: [4,5,2,25] -> Output: [5,25,25,-1]
// Input: [13,7,6,12] -> Output: [-1,12,12,-1]
// TC: O(n), SC: O(n)
class NextGreaterElement {
    public static int[] nextGreater(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
}
