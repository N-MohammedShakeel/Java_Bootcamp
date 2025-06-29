package Java_Bootcamp.DSA.Basic.Stack.Problems;

import java.util.*;

// Stack Problems using java.util.Stack

// Problem 1: Reverse a String
// Statement: Given a string, reverse it using a stack.
// Sample Test Cases:
// Input: "hello" -> Output: "olleh"
// Input: "world" -> Output: "dlrow"
// TC: O(n), SC: O(n)
class ReverseString {
    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}

