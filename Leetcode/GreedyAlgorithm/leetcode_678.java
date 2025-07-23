package Java_Bootcamp.Leetcode.GreedyAlgorithm;

public class leetcode_678 {
    public boolean checkValidString(String s) {

        char[] arr = s.toCharArray();
        int min = 0 , max = 0;

        for(int i=0 ;  i < arr.length ; i++){

            if(arr[i] == '('){
                min++;
                max++;
            }else if(arr[i] == ')'){
                min--;
                max--;
            }else{
                min--;
                max++;
            }

            if(min < 0){
                min = 0;
            }

            if (max < 0){
                return false;
            }
        }

        return min == 0;

    }
}
