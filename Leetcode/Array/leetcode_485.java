package Java_Bootcamp.Leetcode.Array;

public class leetcode_485 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int maxSum = 0, currSum =0;
        for(int num : nums){
            if(num != 0){
                currSum += 1;
                maxSum = (currSum > maxSum) ? currSum : maxSum;
            }
            else currSum = 0;
        }

        return maxSum;
    }
}
