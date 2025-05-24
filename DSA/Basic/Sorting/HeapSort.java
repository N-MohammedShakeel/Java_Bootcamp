package Java_Bootcamp.DSA.Basic.Sorting;

public class HeapSort {

    public static void main(String[] args) {
        // Problem: Sort an array of integers in ascending order
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));

        // Solution: Apply Heap Sort
        heapSort(arr);

        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }

    /**
     * Heap Sort Algorithm
     *
     * Time Complexity:
     * - Building Max Heap: O(n)
     * - Extracting Elements: O(n log n)
     * - Total: O(n log n)
     *
     * Space Complexity:
     * - O(1) Auxiliary space (In-place sorting)
     */
    private static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max Heap
        // Start from last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (maximum) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * heapify - To maintain max-heap property
     *
     * @param arr The array to be heapified
     * @param n   The size of the heap
     * @param i   The index to heapify from
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;           // Initialize largest as root
        int left = 2 * i + 1;      // Left child index
        int right = 2 * i + 2;     // Right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and heapify affected subtree
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
}
