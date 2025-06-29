package Java_Bootcamp.Leetcode_Top_25.Array;

import java.util.HashMap;
import java.util.List;

public class Problem_15 {

    public static void main(String[] args) {

        int[] arr = {-1,0,1,2,-1,-4};
        threeSum(arr);
    }

    public static void threeSum(int[] arr) {

        HashMap<String,Integer> map = new HashMap<>();

        for (int i=0 ; i<arr.length ; i++){
            for (int j=i ; j<arr.length ; j++){
                int sum = 0;
                String res = "";
                for (int k=i ; k<=j ; k++){
                    sum += arr[k];
                    res += arr[k];
                }

                if(sum == 0){
                    map.put(res,sum);
                }
            }
        }


        System.out.println(map);
    }
}
