package Java_Bootcamp.DSA.IntermediateToAdvance.GreedyAlgorithm.Medium;

public class JumpGame_1 {

    public static void main(String[] args) {

        int[] nums = {3,2,1,0,4};
        System.out.println(jumps(nums));
    }

    static boolean jumps(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return false;
    }

}
