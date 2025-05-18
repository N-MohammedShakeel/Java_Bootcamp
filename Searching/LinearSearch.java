package Java_Bootcamp.Searching;

public class LinearSearch {
    public static void main(String[] args) {
        // Problem: Find the index of element 25 in an unsorted array
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int target = 25;
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("Target: " + target);

        // Solution: Implement Linear Search
        int result = linearSearch(arr, target);
        System.out.println("Result: " + (result == -1 ? "Element not found" : "Element found at index " + result));
    }

    // Linear Search: Sequentially check each element until target is found or end is reached
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Element not found
    }
}