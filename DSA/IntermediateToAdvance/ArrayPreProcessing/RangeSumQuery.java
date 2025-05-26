package Java_Bootcamp.DSA.IntermediateToAdvance.ArrayPreProcessing;

public class RangeSumQuery {
    private long[] prefix;

    public RangeSumQuery(int[] nums) {
        // Algorithm:
        // 1. Precompute the prefix sum array where prefix[i] = sum of nums[0] to nums[i].
        // 2. For a query [l, r], compute sum as prefix[r] - prefix[l-1] (if l > 0).
        // 3. Handle edge case where l = 0 by returning prefix[r] directly.

        // Workflow:
        // - Initialize prefix array of size n.
        // - Compute prefix[i] = prefix[i-1] + nums[i] for i = 0 to n-1.
        // - For each query [l, r]:
        //   - If l = 0, return prefix[r].
        //   - Else, return prefix[r] - prefix[l-1].
        // - Use long to avoid overflow for large sums.

        int n = nums.length;
        prefix = new long[n];
        if (n > 0) {
            prefix[0] = nums[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i-1] + nums[i];
            }
        }
    }

    public long sumRange(int left, int right) {
        // Compute range sum [left, right]
        return left == 0 ? prefix[right] : prefix[right] - prefix[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery obj = new RangeSumQuery(nums);
        // Test queries
        System.out.println("Sum [0, 2]: " + obj.sumRange(0, 2)); // 1
        System.out.println("Sum [2, 5]: " + obj.sumRange(2, 5)); // -1
        System.out.println("Sum [0, 5]: " + obj.sumRange(0, 5)); // -3
    }
}