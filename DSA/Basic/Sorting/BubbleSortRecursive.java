package Java_Bootcamp.DSA.Basic.Sorting;

public class BubbleSortRecursive {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        // Solution: Implement Bubble Sort in Recursive
        bubbleSortRecursive(arr,arr.length);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));

        /*
         * Recursive Bubble Sort - Time and Space Complexity

         * Time Complexity:
         * - Best Case:    O(n^2)      // Even if already sorted, still makes n-1 passes (no optimization here)
         * - Average Case: O(n^2)
         * - Worst Case:   O(n^2)

         * Explanation:
         * - For each pass (outer recursion), we do n-1, n-2, ..., 1 comparisons => O(n^2)

         * Space Complexity:
         * - O(n) due to recursion stack (n recursive calls for n elements)

         * Note:
         * - The space complexity is higher than iterative version (which is O(1)) because of recursive call stack usage.
         */


    }

    static void bubbleSortRecursive(int[] arr, int n) {
        // Base case for outer recursion
        if (n == 1) return;

        // Perform one pass of bubble sort (move largest to end)
        bubbleSortInner(arr, 0, n);

        // Recursive call for next pass (excluding last element)
        bubbleSortRecursive(arr, n - 1);
    }

    static void bubbleSortInner(int[] arr, int i, int n) {
        // Base case for inner recursion
        if (i == n - 1) return;

        // Swap if adjacent elements are in wrong order
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }

        // Recursive call to next index
        bubbleSortInner(arr, i + 1, n);
    }

//    static void bubbleSort(int[] arr) {
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    // Swap elements
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//    }

}
