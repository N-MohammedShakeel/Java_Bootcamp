package Java_Bootcamp.DSA.Basic.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // Problem: Sort an array of integers in ascending order
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));

        // Solution: Implement Merge Sort
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));


        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array Method 2: " + Arrays.toString(arr1));
        int[] temp = new int[arr.length]; // Single temp array
        mergesort(arr1, temp, 0, arr.length - 1);
        System.out.println("Sorted array Method 2: " + Arrays.toString(arr1));


        /*
         * Merge Sort - Time and Space Complexity

         * Time Complexity:
         * - Best Case:    O(n log n)
         * - Average Case: O(n log n)
         * - Worst Case:   O(n log n)

         * Explanation:
         * - The array is recursively divided into halves → log₂(n) levels
         * - Each level does O(n) work for merging
         * - So total time = O(n) * O(log n) = O(n log n)

         * Space Complexity:
         * - O(n) extra space for the temporary array used during merge
         * - Space is not reused across all recursive calls in standard implementation
         * - Therefore, total auxiliary space = O(n)
         */


    }

    // Merge Sort: Divide array into halves, recursively sort, and merge sorted halves
    static void mergeSort(int[] arr, int low, int high){

        if (low >= high) return;

        int mid = (low + high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    static void merge(int[] arr, int low, int mid, int high){

        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high){
            if (arr[left] < arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while (right <= high){
            temp.add(arr[right]);
            right++;
        }

        for(int i=low ; i <= high ; i++){
            arr[i] = temp.get(i - low);
        }
    }




    static void mergesort(int[] arr, int[] temp, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        mergesort(arr, temp, low, mid);
        mergesort(arr, temp, mid + 1, high);
        merge(arr, temp, low, mid, high);
    }

    static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int index = low;

        // Merge two sorted subarrays into temp[]
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        // Copy remaining elements from left half
        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        // Copy remaining elements from right half
        while (right <= high) {
            temp[index++] = arr[right++];
        }

        // Copy sorted temp[] back to arr[]
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }
}