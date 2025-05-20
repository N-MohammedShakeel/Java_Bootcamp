package Java_Bootcamp.DSA.Searching;

public class BinarySearch {
    public static void main(String[] args) {
        // Problem: Find the index of element 25 in a sorted array
        int[] arr = {11, 12, 22, 25, 34, 64, 90};
        int target = 25;
        System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
        System.out.println("Target: " + target);

        // Solution: Implement Binary Search
        int result = binarySearch(arr, target);
        System.out.println("Result: " + (result == -1 ? "Element not found" : "Element found at index " + result));
    }

    // Binary Search: Repeatedly divide the search interval in half
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    }
}