package Java_Bootcamp.DSA.IntermediateToAdvance.Backtracking;

import java.util.*;

public class GenerateSubsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking with an empty subset
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    // Algorithm:
    // 1. For each element in the array, we have two choices: include it or exclude it.
    // 2. Use recursion to build subsets by making a choice at each index.
    // 3. Base case: When we reach the end of the array, add the current subset to the result.
    // 4. Backtrack by removing the last included element to try the next choice (exclude).

    // Workflow:
    // - Start with an empty subset and index 0.
    // - For each index i:
    //   - Exclude nums[i]: Skip to the next index.
    //   - Include nums[i]: Add nums[i] to the subset, recurse, then remove it (backtrack).
    // - When index reaches nums.length, add the current subset to the result.
    // - Use ArrayList to store the current subset and result list.

    private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Base case: If we've processed all elements, add the current subset
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Exclude the current element
        backtrack(nums, index + 1, current, result);

        // Choice 2: Include the current element
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result);
        // Backtrack: Undo the choice
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}