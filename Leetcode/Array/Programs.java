package Java_Bootcamp.Leetcode.Array;

public class Programs {

    public static void main(String[] args) {

        int[] arr = {10,22,12,3,0,6};
        leaderInArray(arr);
    }

    static void leaderInArray(int[] arr){

        int max = arr[arr.length-1];

        System.out.println(max);
        for(int i = arr.length-2 ; i >= 0 ; i--){
            if(arr[i] > max){
                System.out.println(arr[i]);
            }
            max = Math.max(max,arr[i]);
        }

    }
}
