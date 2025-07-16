package Java_Bootcamp.DSA_Patterns.Subsequences;

import java.util.Arrays;
import java.util.HashMap;

public class Programs {

    public static void main(String[] args) {

        int[] arr = {2,5,10};
        int target = 15;
        System.out.println(isSubArrayOfSumExist(arr,target));
        System.out.println(Arrays.toString(SubArrayOfSumIndices(arr,target)));
        System.out.println(isSubArrayOfSumExistByTwoPointer(arr,target));
        smallestSubArrayOfSum(arr,target);
    }


    static void smallestSubArrayOfSum(int[] arr, int sum) {
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;

            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];

                if (currentSum == sum) {
                    int len = j - i + 1;
                    minLen = Math.min(minLen, len);
                }
            }
        }
        System.out.println("Length of Smallest Subarray: " + minLen);
    }

    static boolean isSubArrayOfSumExistByTwoPointer(int[] arr, int targetSum) {
        int start = 0, end = 0;
        int currentSum = 0;

        while (end < arr.length) {
            currentSum += arr[end];

            while (currentSum > targetSum && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == targetSum) {
                return true;
            }

            end++;
        }
        return false;
    }

    static int[] SubArrayOfSumIndices(int[] arr, int sum) {

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;

            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];

                if (currentSum == sum) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    static boolean isSubArrayOfSumExist(int[] arr, int sum) {

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;

            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];

                if (currentSum == sum) {
                    return true;
                }
                if (currentSum > sum)
                    break;
            }
        }
        return false;
    }

    static void longestSubArrayOfSumByTwoPointer(int[] arr, int targetSum) {
        //  This is a Sliding Window technique — implemented using Two Pointers.
        int start = 0, end = 0;
        int currentSum = 0;
        int maxLength = 0;

        while (end < arr.length) {
            currentSum += arr[end];

            while (currentSum > targetSum && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == targetSum) {
                maxLength = Math.max(maxLength, end - start + 1);
            }

            end++;
        }

        System.out.println("Length of Longest Subarray with sum " + targetSum + " is: " + maxLength);
    }


    static void longestSubArrayOfSumByHashMap(int[] arr, int targetSum) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int currSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == targetSum) {
                maxLength = i + 1;
            }

            if (prefixSumMap.containsKey(currSum - targetSum)) {
                int length = i - prefixSumMap.get(currSum - targetSum);
                maxLength = Math.max(maxLength, length);
            }

            // Store only the first occurrence of currSum
            if (!prefixSumMap.containsKey(currSum)) {
                prefixSumMap.put(currSum, i);
            }
        }
        System.out.println("Length of Longest Subarray with sum " + targetSum + " is: " + maxLength);
    }


    static void longestSubArrayOfSum(int[] arr, int sum) {
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;

            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];

                if (currentSum == sum) {
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        System.out.println("Length of Longest Subarray: " + maxLen);
    }

}
