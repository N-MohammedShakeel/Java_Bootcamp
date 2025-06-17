package Java_Bootcamp.DSA.Basic.String.Medium;

import java.util.ArrayList;

public class SubArray {
    public static void main(String[] args) {
        // Test case
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("All subarrays: ");
        subArray(arr);
    }

    public static void subArray(int[] arr) {
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                String result = "";
                for (int k = i; k <= j; k++) {
                    result += arr[k] + " ";
                }
                if (!a.contains(result))
                    a.add(result);
            }
        }
        System.out.println(a);
    }
}