package Java_Bootcamp.DSA.Basic.String.Hard;

public class KedansAlgorithm {
    public static void main(String[] args) {
        // Test case
        System.out.println("Maximum subarray sum: ");
        kedansAlgorithm();
    }

    public static void kedansAlgorithm() {
        int[] arr = {-2, 7, 3, -6};
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : arr) {
            currentSum += num;
            if (currentSum > max)
                max = currentSum;
            if (currentSum < 0)
                currentSum = 0;
        }
        System.out.println(max);
    }
}