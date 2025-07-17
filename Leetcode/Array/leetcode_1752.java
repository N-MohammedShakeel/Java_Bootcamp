package Java_Bootcamp.Leetcode.Array;

public class leetcode_1752 {

    public boolean check(int[] nums) {
        int countBreaks = 0;
        int n = nums.length;

        if(nums[nums.length -1] > nums[0]){
            countBreaks++;
        }

        for(int i = 0; i < n - 1; i++) {
            if(nums[i] > nums[i+1]) {
                countBreaks++;
            }
            if(countBreaks > 1) {
                return false;
            }
        }

        return true;
    }
}
