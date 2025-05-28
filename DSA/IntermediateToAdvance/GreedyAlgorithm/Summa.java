package Java_Bootcamp.DSA.IntermediateToAdvance.GreedyAlgorithm;

import java.util.ArrayList;

public class Summa {

    public static void main(String[] args) {

        String s = "***())(";

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
                System.out.println("Not Valid");
                break;
            }
        }

        System.out.println(min == 0);
    }
}
