package Java_Bootcamp.Leetcode.Array;

public class leetcode_136 {

    public int singleNumber(int[] nums) {
        int num = 0;
        for(int ele : nums){
            num = num ^ ele;
        }
        return num;
    }
}
