package Java_Bootcamp.DSA.Basic.String.Medium;

public class SubArrayOfSumMethod2 {
    public static void main(String[] args) {
        // Test case
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 12;
        System.out.println("Subarrays with sum " + sum + ": ");
        subArrayOfSumMethod2(arr, sum);
    }

    public static void subArrayOfSumMethod2(int[] arr, int sum) {
        int start = 0, end = 0, currSum = 0;
        while (end < arr.length) {
            currSum += arr[end];
            while (currSum > sum && start <= end) {
                currSum -= arr[start++];
            }
            if (currSum == sum) {
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            end++;
        }
    }
}