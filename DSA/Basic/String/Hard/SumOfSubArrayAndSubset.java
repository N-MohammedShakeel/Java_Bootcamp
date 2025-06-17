package Java_Bootcamp.DSA.Basic.String.Hard;

import java.util.HashMap;

public class SumOfSubArrayAndSubset {
    public static void main(String[] args) {
        // Test case
        System.out.println("Subarray with maximum sum: ");
        sumOfSubArrayAndSubset();
    }

    public static void sumOfSubArrayAndSubset() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                String result = "";
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    result += arr[k] + " ";
                }
                if (!map.containsKey(result))
                    map.put(result, sum);
            }
        }
        int max = Integer.MIN_VALUE;
        String maxKey = "";
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println(maxKey);
    }
}