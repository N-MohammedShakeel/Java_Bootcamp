package Java_Bootcamp.DSA.Basic.String.Medium;

public class SubArrayOfSumMethod1 {
    public static void main(String[] args) {
        // Test case
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 12;
        System.out.println("Subarrays with sum " + sum + ": ");
        subArrayOfSumMethod1(arr, sum);
    }

    public static void subArrayOfSumMethod1(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            int sumd = 0;
            String result = "";
            for (int j = i; j < arr.length; j++) {
                sumd += arr[j];
                result += arr[j] + " ";
                if (sumd == sum) {
                    System.out.println(result);
                }
            }
        }
    }
}