package Java_Bootcamp.DSA.Basic.Sorting;

public class RadixSort {

    public static void main(String[] args) {
        // Problem: Sort an array of non-negative integers using Radix Sort
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        // Solution: Apply Radix Sort
        radixSort(arr);

        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }

    /**
     * Radix Sort Algorithm
     *
     * Time Complexity:
     * - Best, Average, Worst: O(n * k), where k is number of digits (≈ log(max))
     *
     * Space Complexity:
     * - O(n + k): Uses additional count array and output array
     */
    private static void radixSort(int[] arr) {
        int max = getMax(arr); // Get maximum value in the array

        // Apply counting sort for every digit place (1s, 10s, 100s, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    /**
     * Helper function to find the maximum element in the array
     */
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    /**
     * Counting Sort based on digit represented by exp
     *
     * @param arr The array to be sorted
     * @param exp The current digit place (1, 10, 100, ...)
     */
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];      // Output array
        int[] count = new int[10];      // Count array for base 10 digits

        // Step 1: Count occurrences of digits
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Step 2: Accumulate the count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build the output array (stable sort, right to left)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Step 4: Copy output to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
