package Java_Bootcamp.DSA.IntermediateToAdvance.ArrayPreProcessing;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        // Algorithm:
        // 1. Use prefix sum to compute cumulative sums.
        // 2. For a subarray [l, r] to sum to k, prefix[r] - prefix[l-1] = k.
        // 3. Rearrange: prefix[r] - k = prefix[l-1].
        // 4. Use a HashMap to store frequency of prefix sums.
        // 5. For each prefix sum, check if prefix[i] - k exists in the map and add its frequency to the result.

        // Workflow:
        // - Initialize a HashMap to store prefix sum frequencies (key: prefix sum, value: count).
        // - Initialize prefix sum as 0 and add (0, 1) to map to handle subarrays starting from index 0.
        // - Iterate through nums:
        //   - Compute prefix sum: prefix += nums[i].
        //   - If prefix - k exists in map, add its frequency to result.
        //   - Update map with current prefix sum.
        // - Return total count of valid subarrays.
        // - Use long for prefix sums to avoid overflow.

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // Handle subarrays starting from index 0
        long prefix = 0;
        int count = 0;

        for (int num : nums) {
            prefix += num;
            // Check if there’s a prefix sum such that prefix - k exists
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }
            // Update frequency of current prefix sum
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Number of subarrays with sum " + k + ": " + subarraySum(nums, k)); // 2

        nums = new int[]{1, 2, 3};
        k = 3;
        System.out.println("Number of subarrays with sum " + k + ": " + subarraySum(nums, k)); // 2
    }
}