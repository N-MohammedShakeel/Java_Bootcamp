package Java_Bootcamp.DSA.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        // Problem: Sort an array of integers in ascending order
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        // Solution: Implement Insertion Sort
        insertionSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));

        // Insertion Sort Algorithm
        // Time Complexity:
        //   - Best Case:    O(n)       -> Already sorted array
        //   - Average Case: O(n^2)
        //   - Worst Case:   O(n^2)     -> Reverse sorted array
        //z
        // Space Complexity:
        //   - O(1): In-place sorting with constant extra space
    }

    // Insertion Sort: Build sorted array one element at a time by inserting elements in correct position
    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j >= 0 && arr[j-1] > arr[j]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}