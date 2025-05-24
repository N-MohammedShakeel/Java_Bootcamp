package Java_Bootcamp.DSA.Basic.Hashing;

import java.util.*;

public class HashingProblems {
    public static void main(String[] args) {
        // Test cases for each problem
        int[] arr1 = {1, 2, 2, 3, 1, 4};
        System.out.println("=== Count Frequencies of Array Elements ===");
        countFrequenciesEasy(arr1);
        countFrequenciesOptimized(arr1);
        
        System.out.println("\n=== Highest/Lowest Frequency Element ===");
        findHighLowFrequencyEasy(arr1);
        findHighLowFrequencyOptimized(arr1);
        
        int[] arr2 = {1, 2, 3, 2, 1, 4};
        System.out.println("\n=== Check if Array Has Duplicates ===");
        System.out.println("Has duplicates? " + hasDuplicates(arr2)); // true
        
        int[] arr3 = {1, 2, 3, 4, 5};
        int sum = 9;
        System.out.println("\n=== Find Pair with Given Sum ===");
        findPairWithSum(arr3, sum); // Pair (4, 5)
        
        int[] arr4 = {1, 4, -2, 3, -1};
        int targetSum = 2;
        System.out.println("\n=== Find Subarray with Given Sum ===");
        findSubarrayWithSum(arr4, targetSum); // Subarray from index 1 to 3
        
        int[] arr5 = {1, 2, 2, 3, 3, 3};
        int k = 2;
        System.out.println("\n=== Top K Frequent Elements ===");
        int[] result = topKFrequent(arr5, k);
        System.out.print("Top " + k + " frequent: ");
        for (int num : result) {
            System.out.print(num + " "); // 2, 3
        }
        System.out.println();
    }
    
    // Problem 1: Count Frequencies of Array Elements
    // Easy Approach: Use an array to count frequencies (assuming elements are within a known range).
    // Time Complexity: O(n) for iteration, O(1) for array access.
    // Space Complexity: O(R) where R is the range of elements.
    public static void countFrequenciesEasy(int[] arr) {
        System.out.println("Easy Approach (Array-based):");
        int max = Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[max + 1];
        for (int num : arr) {
            freq[num]++;
        }
        for (int i = 0; i <= max; i++) {
            if (freq[i] > 0) {
                System.out.println("Element " + i + ": " + freq[i]);
            }
        }
    }
    
    // Optimized Approach: Use HashMap for any range of elements.
    // Time Complexity: O(n) for iteration and HashMap operations.
    // Space Complexity: O(n) for storing unique elements.
    public static void countFrequenciesOptimized(int[] arr) {
        System.out.println("Optimized Approach (HashMap):");
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            System.out.println("Element " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    // Problem 2: Find Highest/Lowest Frequency Element
    // Easy Approach: Use array-based frequency counting, then scan for max/min.
    // Time Complexity: O(n) for counting, O(R) for scanning range.
    // Space Complexity: O(R) for frequency array.
    public static void findHighLowFrequencyEasy(int[] arr) {
        System.out.println("Easy Approach (Array-based):");
        int max = Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[max + 1];
        for (int num : arr) {
            freq[num]++;
        }
        int maxFreq = 0, minFreq = arr.length + 1;
        int maxFreqElement = -1, minFreqElement = -1;
        for (int i = 0; i <= max; i++) {
            if (freq[i] > 0) {
                if (freq[i] > maxFreq) {
                    maxFreq = freq[i];
                    maxFreqElement = i;
                }
                if (freq[i] < minFreq) {
                    minFreq = freq[i];
                    minFreqElement = i;
                }
            }
        }
        System.out.println("Highest frequency element: " + maxFreqElement + " (freq: " + maxFreq + ")");
        System.out.println("Lowest frequency element: " + minFreqElement + " (freq: " + minFreq + ")");
    }
    
    // Optimized Approach: Use HashMap to find max/min frequencies.
    // Time Complexity: O(n) for counting and scanning HashMap.
    // Space Complexity: O(n) for HashMap.
    public static void findHighLowFrequencyOptimized(int[] arr) {
        System.out.println("Optimized Approach (HashMap):");
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0, minFreq = arr.length + 1;
        int maxFreqElement = -1, minFreqElement = -1;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            int key = entry.getKey();
            if (freq > maxFreq) {
                maxFreq = freq;
                maxFreqElement = key;
            }
            if (freq < minFreq) {
                minFreq = freq;
                minFreqElement = key;
            }
        }
        System.out.println("Highest frequency element: " + maxFreqElement + " (freq: " + maxFreq + ")");
        System.out.println("Lowest frequency element: " + minFreqElement + " (freq: " + minFreq + ")");
    }
    
    // Problem 3: Check if Array Has Duplicates
    // Approach: Use HashSet to detect duplicates in one pass.
    // Time Complexity: O(n) for iterating and HashSet operations.
    // Space Complexity: O(n) for storing unique elements.
    public static boolean hasDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) { // add returns false if element exists
                return true;
            }
        }
        return false;
    }
    
    // Problem 4: Find Pair with Given Sum
    // Approach: Use HashSet to store complements while iterating.
    // Time Complexity: O(n) for single pass with HashSet.
    // Space Complexity: O(n) for HashSet.
    public static void findPairWithSum(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            int complement = sum - num;
            if (set.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return;
            }
            set.add(num);
        }
        System.out.println("No pair found with sum " + sum);
    }
    
    // Problem 5: Find Subarray with Given Sum (Non-negative numbers)
    // Approach: Use HashMap to store cumulative sums and check for target sum.
    // Time Complexity: O(n) for single pass with HashMap.
    // Space Complexity: O(n) for HashMap.
    public static void findSubarrayWithSum(int[] arr, int targetSum) {
        HashMap<Long, Integer> sumMap = new HashMap<>();
        long currentSum = 0;
        sumMap.put(0L, -1); // Handle case where subarray starts from index 0
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (sumMap.containsKey(currentSum - targetSum)) {
                System.out.println("Subarray found from index " + (sumMap.get(currentSum - targetSum) + 1) + " to " + i);
                return;
            }
            sumMap.put(currentSum, i);
        }
        System.out.println("No subarray found with sum " + targetSum);
    }
    
    // Problem 6: Top K Frequent Elements (Hard)
    // Approach: Use HashMap for frequency counting, then PriorityQueue for top K.
    // Time Complexity: O(n log n) due to PriorityQueue operations.
    // Space Complexity: O(n) for HashMap and PriorityQueue.
    public static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue() // Min-heap based on frequency
        );
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}