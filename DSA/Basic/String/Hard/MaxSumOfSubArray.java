package Java_Bootcamp.DSA.Basic.String.Hard;

public class MaxSumOfSubArray {
    public static void main(String[] args) {
        // Test case
        System.out.println("Maximum subarray sum: ");
        maxSumOfSubArray();
    }

    public static void maxSumOfSubArray() {
        int[] arr = {-2, 7, 3, -6};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (max < sum)
                    max = sum;
            }
        }
        System.out.println(max);
    }
}