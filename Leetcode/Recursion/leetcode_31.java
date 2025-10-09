package Java_Bootcamp.Leetcode.Recursion;

public class leetcode_31 {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i >= 0){
            int j = nums.length -1;
            while(nums[j] <= nums[i]) j--;
            swap(nums,i,j);
        }
        int start = i+1;
        int end = nums.length-1;
        while(start < end){
            swap(nums,start++,end--);
        }

    }

    static void swap(int[] nums , int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
