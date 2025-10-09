package Java_Bootcamp.Leetcode.Array;

public class leetcode_287 {
    public int findDuplicate(int[] nums) {

        int[] arr = new int[nums.length];

        for(int num : nums){
            if (arr[num] == -1) return num;
            else arr[num] = -1;
        }

        return -1;
    }
}
