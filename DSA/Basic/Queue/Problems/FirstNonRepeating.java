package Java_Bootcamp.DSA.Basic.Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;

// Problem 4: First Non-Repeating Character in Stream
// Statement: Find the first non-repeating character in a stream at each position.
// Sample Test Cases:
// Input: "aabc" -> Output: "a#bc"
// Input: "zz" -> Output: "z#"
// TC: O(n), SC: O(1) (fixed alphabet)
class FirstNonRepeating {
    public static String firstNonRepeating(String stream) {
        int[] count = new int[26];
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (char c : stream.toCharArray()) {
            count[c - 'a']++;
            queue.offer(c);
            while (!queue.isEmpty() && count[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            result.append(queue.isEmpty() ? '#' : queue.peek());
        }
        return result.toString();
    }
}
