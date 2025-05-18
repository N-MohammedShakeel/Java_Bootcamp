package Java_Bootcamp.Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        // Problem: Sort an array of integers in ascending order
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        // Solution: Implement Selection Sort
        selectionSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }

    // Selection Sort: Find minimum element in unsorted portion and place it at the beginning
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap minimum element with first element of unsorted portion
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}