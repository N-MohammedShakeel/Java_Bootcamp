package Java_Bootcamp.DSA_Patterns.Two_Pointer;

public class leetcode_167 {

    public int[] twoSum(int[] numbers, int target) {

        for(int i=0 ; i<numbers.length ; i++){
            for(int j=i+1 ; j<numbers.length ; j++){
                if(target == (numbers[i] + numbers[j])){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[]{1,2};
    }
}
