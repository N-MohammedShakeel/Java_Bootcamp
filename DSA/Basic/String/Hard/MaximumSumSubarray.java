package Java_Bootcamp.DSA.Basic.String.Hard;

import java.util.*;

// MaximumSumSubarray.java
// Finds the subarray with the maximum sum and prints it
// Time: O(n^3), Space: O(n^2)

public class MaximumSumSubarray {
    public static void main(String[] args) {
        // Test case
        System.out.println("Maximum Sum Subarray and Subset: ");
        sumOfSubArrayAndSubset(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}); // 4 -1 2 1
    }

    // Finds the subarray with the maximum sum and prints it
    // Time: O(n^3), Space: O(n^2)
    public static void sumOfSubArrayAndSubset(int[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                StringBuilder result = new StringBuilder();
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    result.append(arr[k]).append(" ");
                }
                map.put(result.toString(), sum);
            }
        }
        int max = Integer.MIN_VALUE;
        String maxKey = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println(maxKey);
    }
}