package Java_Bootcamp.DSA.Basic.Sorting;

public class QuickSort {
    public static void main(String[] args) {
        // Problem: Sort an array of integers in ascending order
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        // Solution: Implement Quick Sort
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));

        /*
         * Time Complexity:
         * Best Case: O(n log n) — when partitions are balanced
         * Average Case: O(n log n) — expected performance with random pivots
         * Worst Case: O(n^2) — when the pivot is always min or max (unbalanced split)

         * Space Complexity:
         * O(log n) — due to recursive call stack (in-place sorting, no extra array)
         */
    }

    // Quick Sort: Choose a pivot, partition array around it, and recursively sort sub-arrays
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort left and right subarrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /*
     * Hoare's partition:
     * - Chooses first element as pivot
     * - Partitions the array so that elements <= pivot are on left,
     *   elements >= pivot are on right.
     */
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low ;
        int j = high;

        while (i < j){
            while (arr[i] < pivot){
                i++;
            }
            while (arr[j] > pivot){
                j--;
            }

            if(i >= j) return j;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return -1;
    }


    // Actual Hoare's partition code
//    static int partition(int[] arr, int low, int high) {
//        int pivot = arr[low];
//        int i = low - 1;
//        int j = high + 1;
//
//        while (true) {
//            do {
//                i++;
//            } while (arr[i] < pivot);
//
//            do {
//                j--;
//            } while (arr[j] > pivot);
//
//            if (i >= j)
//                return j;
//
//            // Swap arr[i] and arr[j]
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//        }
//    }
}