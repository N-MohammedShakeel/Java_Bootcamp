package Java_Bootcamp.DSA.Arrays;// Arrays in Java:
// - An array is a fixed-size, contiguous memory structure that stores elements of the same data type.
// - Declaration: int[] arr = new int[size];
// - Indexing: 0-based (arr[0] to arr[size-1]).
// - Time Complexity:
//   - Access: O(1) (direct index access).
//   - Insertion/Deletion: O(n) (shifting elements required).
//   - Search (unsorted): O(n), Search (sorted): O(log n) with binary search.
// - Use cases: Store lists, matrices, or implement algorithms like two-pointer, sliding window.
// - Java-specific: Arrays are static, but ArrayList can be used for dynamic size.

// This program demonstrates key array operations: traversal, insertion, deletion, linear search, binary search, and two-pointer technique.

public class ArrayOperations {
    public static void main(String[] args) {
        // Initialize an array
        int[] arr = {10, 20, 30, 40, 50};
        
        // 1. Traverse the array
        System.out.println("Traversing array:");
        traverseArray(arr);
        
        // 2. Insert an element at a specific position
        System.out.println("\nInserting 25 at index 2:");
        arr = insertElement(arr, 25, 2);
        traverseArray(arr);
        
        // 3. Delete an element at a specific position
        System.out.println("\nDeleting element at index 3:");
        arr = deleteElement(arr, 3);
        traverseArray(arr);
        
        // 4. Linear Search
        int target = 30;
        System.out.println("\nLinear Search for " + target + ":");
        int index = linearSearch(arr, target);
        System.out.println(target + " found at index: " + index);
        
        // 5. Binary Search (requires sorted array)
        System.out.println("\nBinary Search for " + target + ":");
        index = binarySearch(arr, target);
        System.out.println(target + " found at index: " + index);
        
        // 6. Two-Pointer Technique: Find pair with given sum
        int sum = 60;
        System.out.println("\nTwo-Pointer: Finding pair with sum " + sum + ":");
        findPairWithSum(arr, sum);
    }
    
    // Traverse Array: Print all elements
    // Time Complexity: O(n), where n is array length
    public static void traverseArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Insert Element at given position
    // Time Complexity: O(n) due to shifting elements
    public static int[] insertElement(int[] arr, int element, int position) {
        // Create new array with size + 1
        int[] newArr = new int[arr.length + 1];
        
        // Copy elements before position
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }
        
        // Insert new element
        newArr[position] = element;
        
        // Copy remaining elements
        for (int i = position; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        
        return newArr;
    }
    
    // Delete Element at given position
    // Time Complexity: O(n) due to shifting elements
    public static int[] deleteElement(int[] arr, int position) {
        // Create new array with size - 1
        int[] newArr = new int[arr.length - 1];
        
        // Copy elements before position
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }
        
        // Copy elements after position
        for (int i = position + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        
        return newArr;
    }
    
    // Linear Search: Find element in unsorted array
    // Time Complexity: O(n)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }
    
    // Binary Search: Find element in sorted array
    // Time Complexity: O(log n)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Not found
    }
    
    // Two-Pointer Technique: Find pair with given sum in sorted array
    // Time Complexity: O(n)
    public static void findPairWithSum(int[] arr, int sum) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == sum) {
                System.out.println("Pair found: (" + arr[left] + ", " + arr[right] + ")");
                return;
            } else if (currentSum < sum) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("No pair found with sum " + sum);
    }
}