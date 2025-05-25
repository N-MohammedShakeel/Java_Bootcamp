package Java_Bootcamp.DSA.Basic.Searching.BinarySearch;

public class LowerBound {

    public static void main(String[] args) {
        // Problem: Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.
        int[] arr = {11, 12, 22, 24, 34, 64, 90};
        int x = 25;
        System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
        System.out.println("X: " + x);

        // Solution: Implement Lower Bound using Binary Search
        int result = binarySearch(arr, x);
        System.out.println("Index " + result + " is the smallest index such that arr[" + result + "] >= x.");
    }

    // Binary Search: Repeatedly divide the search interval in half
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int midn = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            midn = mid;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return midn;
    }
}
