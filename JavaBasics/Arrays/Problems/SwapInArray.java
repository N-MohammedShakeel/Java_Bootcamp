package Java_Bootcamp.JavaBasics.Arrays.Problems;

import java.util.Arrays;

public class SwapInArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 23, 9, 18, 56};
        swap(arr, 1, 4);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
