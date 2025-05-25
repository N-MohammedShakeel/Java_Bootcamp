package Java_Bootcamp.DSA.Basic.Searching.BinarySearch;


public class BinarySearchRecursive {
    public static void main(String[] args) {
        // Problem: Find the index of element 25 in a sorted array
        int[] arr = {11, 12, 22, 25, 34, 64, 90};
        int target = 25;
        System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
        System.out.println("Target: " + target);

        // Solution: Implement Binary Search
        int result = binarySearchRecusive(arr, target, 0, arr.length-1);
        System.out.println("Result: " + (result == -1 ? "Element not found" : "Element found at index " + result));
    }

    // Binary Search: Repeatedly divide the search interval in half
    static int binarySearchRecusive(int[] arr, int target, int left, int right) {
        if(left > right) return -1;

        int mid = left + (right - left) / 2;

        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            return binarySearchRecusive(arr,target,mid+1,right);
        }else {
            return binarySearchRecusive(arr,target,left,mid-1);
        }

    }
}

