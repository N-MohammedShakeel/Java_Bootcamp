package Java_Bootcamp.DSA.Basic.String.Medium;

import java.util.*;

// GenerateAllSubarrays.java
// Generates all possible subarrays from an array
// Time: O(n^3), Space: O(n^2)

public class GenerateAllSubarrays {
    public static void main(String[] args) {
        // Test case
        System.out.println("SubArray: " + subArray(new int[]{1, 2, 3, 4, 5})); // [1, 1 2, 1 2 3, 1 2 3 4, 1 2 3 4 5, 2, 2 3, 2 3 4, 2 3 4 5, 3, 3 4, 3 4 5, 4, 4 5, 5]
    }

    // Generates all possible subarrays from an array
    // Time: O(n^3), Space: O(n^2)
    public static List<String> subArray(int[] arr) {
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                StringBuilder result = new StringBuilder();
                for (int k = i; k <= j; k++) {
                    result.append(arr[k]).append(" ");
                }
                if (!a.contains(result.toString())) {
                    a.add(result.toString());
                }
            }
        }
        return a;
    }
}