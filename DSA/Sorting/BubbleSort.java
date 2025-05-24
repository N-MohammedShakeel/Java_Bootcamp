package Java_Bootcamp.DSA.Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        // Problem: Sort an array of integers in ascending order
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        // Solution: Implement Bubble Sort
        bubbleSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));

        // Bubble Sort Algorithm
        // Time Complexity:
        //   - Best Case:    O(n)       -> When the array is already sorted (with optimization)
        //   - Average Case: O(n^2)
        //   - Worst Case:   O(n^2)
        //   Explanation: Compares adjacent elements and swaps if needed, for every pass.
        //
        // Space Complexity:
        //   - O(1): In-place sorting, no extra space used except temporary variables
    }

    // Bubble Sort: Repeatedly swap adjacent elements if they are in wrong order
    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}