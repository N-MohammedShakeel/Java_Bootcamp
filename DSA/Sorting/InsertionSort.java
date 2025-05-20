package Java_Bootcamp.DSA.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        // Problem: Sort an array of integers in ascending order
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        // Solution: Implement Insertion Sort
        insertionSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }

    // Insertion Sort: Build sorted array one element at a time by inserting elements in correct position
    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}