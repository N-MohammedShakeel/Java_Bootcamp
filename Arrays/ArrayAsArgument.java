package Java_Bootcamp.Arrays;

import java.util.Arrays;

public class ArrayAsArgument {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 12};
        System.out.println(Arrays.toString(nums));
        change(nums); // The value will be changed
        System.out.println(Arrays.toString(nums));
    }
    static void change(int[] arr) {
        arr[0] = 99;
    }
}
