package Java_Bootcamp.DSA.Basic.String.Medium;

import java.util.*;

// SumOfAllSubarrays.java
// Computes the sum of all possible subarrays
// Time: O(n^3), Space: O(n^2)

public class SumOfAllSubarrays {
    public static void main(String[] args) {
        // Test case
        System.out.println("Sum of SubArray: " + sumOfSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // [-2, 1, -3, 4, -1, 2, 1, -5, 4, -1, -2, 2, -4, 5, 0, 6, 1, -1, 5, -5, 1, 2, -2, 6, 1, -3, 3, 4]
    }

    // Computes the sum of all possible subarrays
    // Time: O(n^3), Space: O(n^2)
    public static List<Integer> sumOfSubArray(int[] arr) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (!a.contains(sum)) {
                    a.add(sum);
                }
            }
        }
        return a;
    }
}