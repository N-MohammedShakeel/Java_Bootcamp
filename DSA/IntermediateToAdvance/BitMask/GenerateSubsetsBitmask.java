package Java_Bootcamp.DSA.IntermediateToAdvance.BitMask;

import java.util.*;

public class GenerateSubsetsBitmask {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // Iterate through all possible subsets (0 to 2^n - 1)
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            // Check each bit to include/exclude elements
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    // If i-th bit is set, include nums[i]
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    // Algorithm:
    // 1. Use an integer mask to represent all possible subsets (0 to 2^n - 1).
    // 2. For each mask, check each bit (0 to n-1):
    //    - If the i-th bit is set (mask & (1 << i)), include nums[i] in the subset.
    // 3. Add the constructed subset to the result list.
    // 4. No backtracking is needed since we iterate through all masks explicitly.

    // Workflow:
    // - For n elements, there are 2^n possible subsets, represented by masks 0 to 2^n - 1.
    // - For each mask:
    //   - Initialize an empty subset.
    //   - Iterate through each bit i (0 to n-1).
    //   - If bit i is set, add nums[i] to the subset.
    //   - Add the subset to the result.
    // - Example: For nums = [1,2,3], mask = 5 (binary 101) represents subset [1,3].

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}