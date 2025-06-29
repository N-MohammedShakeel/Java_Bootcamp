package Java_Bootcamp.DSA.Basic.Sorting;

import java.util.Arrays;

public class InsertionSortRecursive {

    public static void main(String[] args) {

        int[] arr = {5,4,3,2,1};
        System.out.println("Original array: " + Arrays.toString(arr));

        // Solution: Implement Bubble Sort
        insertionSortRecursive(arr,0);
        System.out.println("Sorted array: " + Arrays.toString(arr));


        // Time Complexity:
        // - Worst case: O(n^2)
        //   When the array is sorted in reverse order, each insertion requires shifting all previously sorted elements.
        // - Best case: O(n)
        //   When the array is already sorted, each insertion takes constant time.

        // Space Complexity:
        // - O(n) due to recursion stack
        //   The recursion depth is at most n (number of elements).
        // - No additional significant extra space is used besides the recursion stack.

    }



    static void insertionSortRecursive(int[] arr, int n) {
        if (n == arr.length) return;

        insertionSortInner(arr, n); // Insert arr[n] into sorted part
        insertionSortRecursive(arr, n + 1); // Move to next element
    }

    static void insertionSortInner(int[] arr, int j) {
        if (j <= 0 || arr[j - 1] <= arr[j]) return;

        // Swap if needed
        int temp = arr[j - 1];
        arr[j - 1] = arr[j];
        arr[j] = temp;

        // Recurse on previous element
        insertionSortInner(arr, j - 1);
    }



//    static void insertionSort(int[] arr) {
//
//        for (int i = 1; i < arr.length; i++) {
//            int j = i;
//            while (j >= 0 && arr[j-1] > arr[j]) {
//                int temp = arr[j-1];
//                arr[j-1] = arr[j];
//                arr[j] = temp;
//                j--;
//            }
//        }
//    }
}
