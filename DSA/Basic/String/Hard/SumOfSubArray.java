package Java_Bootcamp.DSA.Basic.String.Hard;

import java.util.ArrayList;

public class SumOfSubArray {
    public static void main(String[] args) {
        // Test case
        System.out.println("Unique subarray sums: ");
        sumOfSubArray();
    }

    public static void sumOfSubArray() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (!a.contains(sum))
                    a.add(sum);
            }
        }
        System.out.println(a);
    }
}