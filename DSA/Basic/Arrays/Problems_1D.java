package Java_Bootcamp.DSA.Basic.Arrays;

import java.util.*;

public class
Problems_1D {

    public static void main(String[] args) {


        int[] arr = new int[5];
        getArray(arr);


//        kaarQuestion(arr);
//        longestSubArrayOfSumByTwoPointer(arr,3);
//        longestSubArrayOfSumByHashMap(arr,3);
//        longestSubArrayOfSum(arr,3);
//        findMaxConsecutiveOnes(arr);
//        missingNumberXOR(arr);
//        missingNumberSum(arr);
//        findIntersectionByTwoPointers(arr,arr);
//        findIntersectionByHashMap(arr,arr);
//        findIntersection(arr,arr);
//        findUnionByTwoPointers(arr,arr);
//        findUnionByHashSet(arr,arr);
//        findUnionByHashMap(arr,arr);
//        moveZeros(arr);
//        rotateRightOptimized(arr, arr.length-1 , 3);
//        rotateArrayClockwise(arr,3);
//        rotateArrayAntiClockwise(arr,3);
//        firstHalfClockwise(arr,3);
//        firstHalfAntiClockwise(arr,3);
//        secondHalfClockwise(arr,3);
//        secondHalfAntiClockwise(arr,3);
//        combineTwoArraysMethod(arr);
//        countUniqueDuplicate(arr);
//        firstUnique(arr);
//        firstDuplicate(arr);
//        findMissingNumber(arr,5);
//        System.out.println(ismountainArray(arr));
//        removeDuplicate(arr);
//        arrayElementSquare(arr);
//        arraySum(arr);
//        arrayMax(arr);
//        arraySecondMax(arr);
//        arrayAnyMax(arr);
//        arrayMin(arr);
//        arraySecondMin(arr);
//        arraySumEvenIndexMethod1(arr);
//        arraySumEvenIndexMethod2(arr);
//        removeElement(arr);
//        removeGivenElementOccurrence(arr);
//        removeElementsInArrayIsElementsOfAnotherArray(arr,arr);
//        elementsFrequency(arr);
//        combineTwoArraysMethod1(arr);
//        combineTwoArraysMethod1(arr);
//        isSorted(arr);
//        twoSum(arr,4);
//        plusOne(arr);
//        romanToNumber();
//        System.out.println(patternCheck1());
//        System.out.println(patternCheck2());
//        System.out.println(patternCheck3());

//        printArray(arr);

    }

    static boolean patternCheck3(){

        String pattern = "abbca";
        String str = "dog cat cat fish cat";
        String[] s = str.toLowerCase().split(" ");

        if (pattern.length() != s.length)
            return false;

        String[] wordMatch = new String[26];

        for (int i=0 ; i<pattern.length() ; i++){
            int index = pattern.charAt(i) - 'a';

            if (wordMatch[index] == null){
                wordMatch[index] = s[i];
            }else if(!wordMatch[index].equals(s[i]))
                return false;
        }
        return true;
    }

    static boolean patternCheck2(){

        String pattern = "abbcb";
        String str = "dog cat cat fish dog";
        String[] s = str.split(" ");

        if (pattern.length() != s.length)
            return false;

        for (int i=0 ; i < s.length -1 ; i++){
            if (pattern.charAt(i) == pattern.charAt(i+1)){
                if (!s[i].equals(s[i+1]))
                    return false;
            }else if (pattern.charAt(i) != pattern.charAt(i+1)){
                if (s[i].equals(s[i+1]))
                    return false;
            }
        }
        return true;
    }

    static boolean patternCheck1(){
        HashMap<Character,String> map = new HashMap<>();

        String pattern = "abba";
        String str = "dog cat cat dog done";
        String[] s = str.split(" ");


        boolean ismatch = true;
        for (int i=0 ; i < s.length ; i++){
            if (!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i),s[i]);
            }else if (map.containsKey(pattern.charAt(i))){
                if (!map.get(pattern.charAt(i)).equals(s[i])){
                    ismatch = false;
                }
            }
        }

        return ismatch;
    }

    static void romanToNumber() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] ch = str.toCharArray();

        String roman = "IVXLCDM";
        int[] number = {1, 5, 10, 50, 100, 500, 1000};

        int ans = 0;
        for (int i = 0; i < ch.length; i++) {
            int currentVal = number[roman.indexOf(ch[i])];
            int nextVal = 0;
            if (i + 1 < ch.length) {
                nextVal = number[roman.indexOf(ch[i + 1])];
            }
            if (currentVal < nextVal) {
                ans -= currentVal;
            } else {
                ans += currentVal;
            }
        }

        System.out.println(ans);
    }

    static void kaarQuestion(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }

        // Step 3: Find binary representation and count set bits
        int[] setBits = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String binary = Integer.toBinaryString(arr[i]);
            setBits[i] = countSetBits(arr[i]);
            System.out.println("Decimal: " + arr[i] + " Binary: " + binary + " Set Bits: " + setBits[i]);
        }

        int maxBits = -1, minBits = Integer.MAX_VALUE;
        int maxVal = -1, minVal = -1;

        for (int i = 0; i < arr.length; i++) {
            if (setBits[i] > maxBits || (setBits[i] == maxBits && arr[i] < maxVal)) {
                maxBits = setBits[i];
                maxVal = arr[i];
            }
            if (setBits[i] < minBits || (setBits[i] == minBits && arr[i] < minVal)) {
                minBits = setBits[i];
                minVal = arr[i];
            }
        }

        int product = maxVal * minVal;
        System.out.println("Product: " + product);

        int result = 1;
        while (result < product) {
            result *= 2;
        }

        System.out.println("Output (nearest power of 2): " + result);
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
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


    static void findMaxConsecutiveOnes(int[] arr) {

        int count = 0;
        int max = 0;
        for (int num : arr) {
            if (num == 1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        System.out.println("Max Consecutive Ones: " + max);
    }

    static void missingNumberXOR(int[] arr) {
        int xor1 = 0;
        int xor2 = 0;
        int n = arr.length;

        // XOR of all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor1 ^= i;
        }

        // XOR of all elements in the array
        for (int num : arr) {
            xor2 ^= num;
        }

        System.out.println(xor1);
        System.out.println(xor2);

        System.out.println("Missing Number: " + (xor1 ^ xor2));
    }


    static void missingNumberSum(int[] arr) {
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        System.out.println("Missing Number: " + (expectedSum - actualSum));
    }


    static void findIntersectionByTwoPointers(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        ArrayList<Integer> intersection = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                intersection.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println("Intersection: " + intersection);
    }

    static void findIntersectionByHashMap(int[] arr1, int[] arr2) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr1) {
            if (freq.getOrDefault(num, 0) > 0) {
                ans.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        System.out.println("Intersection: " + ans);
    }



    static void findIntersection(int[] arr1, int[] arr2){

        ArrayList<Integer> ans = new ArrayList<>();
        for (int k : arr1) {
            for (int j = 0; j < arr2.length; j++) {
                if (k == arr2[j]) {
                    ans.add(k);
                    arr2[j] = -1;
                    break;
                }
            }
        }
        System.out.println("Intersection: " + ans);
    }

    static void findUnionByTwoPointers(int[] arr1, int[] arr2) {
        int n = arr1.length , m = arr2.length;
        int i = 0, j = 0;
        ArrayList<Integer > Union = new ArrayList<>();

        while (i < n && j < m) {

            if (arr1[i] <= arr2[j])
            {
                if (Union.isEmpty() || Union.getLast() != arr1[i])
                    Union.add(arr1[i]);
                i++;

            } else
            {
                if (Union.isEmpty() || Union.getLast() != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }

        }

        while (i < n) // IF any element left in arr1
        {
            if (Union.getLast() != arr1[i])
                Union.add(arr1[i]);
            i++;
        }

        while (j < m) // If any elements left in arr2
        {
            if (Union.getLast() != arr2[j])
                Union.add(arr2[j]);
            j++;
        }

        System.out.println("Union: " + Union);
    }

    static void findUnionByHashSet(int[] arr1, int[] arr2) {

        HashSet<Integer> set = new HashSet<>();

        for (int i : arr1)
            set.add(i);
        for (int i : arr2)
            set.add(i);

        ArrayList<Integer> Union = new ArrayList<>(set);

        System.out.println("Union: " + Union);
    }

    static void findUnionByHashMap(int[] arr1, int[] arr2) {

        HashMap<Integer,Integer > freq = new HashMap<>();
        for (int i : arr1)
            freq.put(i,freq.getOrDefault(i,0)+1);

        for (int i : arr2)
            freq.put(i,freq.getOrDefault(i,0)+1);

        ArrayList<Integer> Union = new ArrayList<>(freq.keySet());

        System.out.println("Union: " + Union);
    }


    public static void moveZeros(int[] arr) {
        int n = arr.length-1;
        int j = -1;
        //place the pointer j:
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        //no non-zero elements:
        if (j == -1) return;

        //Move the pointers i and j
        //and swap accordingly:
        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                //swap a[i] & a[j]:
                swap(arr,i,j);
                j++;
            }
        }
    }

    public static void rotateRightOptimized(int[] arr, int n, int k) {
        // Reverse first n-k elements
        Reverse(arr, 0, n - k - 1);
        // Reverse last k elements
        Reverse(arr, n - k, n - 1);
        // Reverse whole array
        Reverse(arr, 0, n - 1);
    }

    public static void Reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void secondHalfAntiClockwise(int[] arr, int k){
        int n = arr.length;
        k = k % (n/2);

        while (k > 0){
            int temp = arr[n/2];
            for (int i = n/2 ; i < n-1 ; i++){
                arr[i] = arr[i+1];
            }
            arr[n-1] = temp;
            k--;
        }

    }

    static void secondHalfClockwise(int[] arr, int k){
        int n = arr.length;
        k = k % (n/2);

        while (k > 0) {
            int temp = arr[n-1];
            for (int i = n - 2; i >= n/2; i--) {
                arr[i + 1] = arr[i];
            }
            arr[n/2] = temp;
            k--;
        }
    }

    static void firstHalfAntiClockwise(int[] arr, int k){
        int n = arr.length;
        k = k % (n/2);

        while (k > 0) {
            int temp = arr[0];
            for (int i = 0 ; i < n/2-1  ; i++) {
                arr[i] = arr[i+1];
            }
            arr[n/2-1] = temp;
            k--;
        }
    }


    static void firstHalfClockwise(int[]arr, int k){
        int n = arr.length;
        k = k % (n/2);

        while (k > 0) {
            int temp = arr[n/2 - 1];
            for (int i = (n/2) - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = temp;
            k--;
        }
    }

    static void rotateArrayAntiClockwise(int[] arr, int k) {
        int n = arr.length-1;
        k = k % n;

        while (k > 0) {
            int temp = arr[0];
            for (int i = 0 ; i < n ; i++) {
                arr[i] = arr[i+1];
            }
            arr[n] = temp;
            k--;
        }
    }

    static void rotateArrayClockwise(int[] arr, int k) {
        int n = arr.length -1;
        k = k % n;

        while (k > 0) {
            int temp = arr[n];
            for (int i = n - 1; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = temp;
            k--;
        }
    }


    public static void combineTwoArraysMethod(int[] arr) {
        getArray(arr);
        int[] arr1 = new int[5];
        getArray(arr1);
        int[] res = new int[arr.length + arr1.length];

        int index = 0;
        for (int j : arr) {
            res[index++] = j;
        }

        for (int j : arr1) {
            res[index++] = j;
        }
        System.out.println("Array 1 : "+ Arrays.toString(arr));
        System.out.println("Array 2 : "+ Arrays.toString(arr1));
        System.out.println("Resulted Array : "+ Arrays.toString(res));
    }

    static void firstUnique(int[] arr) {
        boolean isUnique;

        for (int i = 0; i < arr.length; i++) {
            isUnique = true;

            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                System.out.println(arr[i]);
                return;
            }
        }

        System.out.println("No unique element found.");
    }



    static void firstDuplicate(int[] arr){

        int first_dup = 0;
        boolean isfound = false;
        for (int i=0 ; i<arr.length-1 ; i++){
            if (isfound) break;
            for (int j = i+1 ; j<arr.length ; j++){
                if(arr[i] == arr[j]){
                    first_dup = arr[i];
                    isfound = true;
                    break;
                }
            }
        }
        System.out.println(first_dup);
    }


    static boolean ismountainArray(int[] arr){

        if(arr.length < 2){
            return false;
        }
        int index = 0;
        int peak = arr[0];
        for(int i=1 ; i<arr.length ; i++){
            if(i != arr.length-1){
                if (peak >= arr[i]){
                    index = i;
                    break;
                }else {
                    peak = arr[i];
                }
            }else {
                return false;
            }
        }

        for(int i=index ; i<arr.length -1 ; i++){
            if(arr[i] <= arr[i+1]){
                return false;
            }
        }
        return true;
    }



    static void removeDuplicate(int[] arr){

        for(int i = 0; i<arr.length-1 ; i++){
            for (int j = i+1 ; j<arr.length ; j++){
                if(arr[i] == arr[j] && arr[j] != Integer.MAX_VALUE){
                    arr[j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] arr1 = new int[arr.length - 1];
        int count =0 ;
        for (int j : arr) {
            if (j != Integer.MAX_VALUE) {
                arr1[count] = j;
                count++;
            }
        }

        printArray(arr1);
    }

    static void countUniqueDuplicate(int[] arr){
        int count_dup = 0;

        for(int i = 0; i<arr.length-1 ; i++){
            for (int j = i+1 ; j<arr.length ; j++){
                if(arr[i] == arr[j] && arr[j] != Integer.MAX_VALUE){
                    arr[j] = Integer.MAX_VALUE;
                    count_dup++;
                }
            }
        }

        int count_un = 0;
        for (int j : arr) {
            if (j != Integer.MAX_VALUE) {
                count_un++;
            }
        }

        System.out.println("Unique: " + count_un + "\nDuplicate: " + count_dup);
    }


    static void findMissingNumber(int[] arr,int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        System.out.println(expectedSum - actualSum);
    }



    public static int[] arrayElementSquare(int arr[]) {

        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = arr[i] * arr[i];
        }

        return arr;
    }


    public static void arrayMax(int[] arr) {

        getArray(arr);
        int max =Integer.MAX_VALUE;

        for(int i = 0 ; i < arr.length ; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println("Max of the given array "+ Arrays.toString(arr) +" is "+ max);
    }

    public static void arraySecondMax(int[] arr) {

        getArray(arr);
        int max = Integer.MAX_VALUE;
        int smax = Integer.MAX_VALUE;

        for(int i = 0 ; i < arr.length ; i++) {
            if(max < arr[i]) {
                smax = max;
                max = arr[i];

            }else if(arr[i] > smax && arr[i] != max) {
                smax = arr[i];
            }
        }

        System.out.println("Max of the given array "+ Arrays.toString(arr) +" is "+ smax);
    }


    public static void arrayAnyMax(int[] arr) {

        System.out.println("Enter the __ largest value you need to find");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt()  ;

        getArray(arr);
        int temp;

        for(int i = 0 ; i < arr.length -1 ; i++)
        {
            for(int j = 0; j < arr.length -1 -i; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("Max of the given array "+ Arrays.toString(arr) +" is "+ arr[arr.length - n]);
    }

    public static void arrayMin(int[] arr) {
        int min = arr[0];

        for(int i = 0 ; i < arr.length ; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }

        System.out.println("Min of the given array "+ Arrays.toString(arr) +" is "+ min);
    }


    public static void arraySecondMin(int[] arr) {
        getArray(arr);

        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                smin = min;
                min = arr[i];
            } else if (arr[i] < smin && arr[i] != min) {
                smin = arr[i];
            }
        }

        System.out.println("Second Min of the given array "+ Arrays.toString(arr) +" is "+ smin);
    }

    public static void arraySum(int[] arr) {
        int sum = 0;
        getArray(arr);

        for(int i = 0 ; i < arr.length ; i++) {
            sum += arr[i];
        }

        System.out.println("Sum of the given array "+ Arrays.toString(arr) +" is "+ sum);
    }

    public static void arraySumFirstHalf(int[] arr) {
        int sum = 0;
        getArray(arr);

        for(int i = 0 ; i < arr.length/2 ; i++) {
            sum += arr[i];
        }

        System.out.println("Sum of the first half of given array "+ Arrays.toString(arr) +" is "+ sum);
    }

    public static void arraySumEvenIndexMethod1(int[] arr) {
        int sum = 0;
        getArray(arr);

        for(int i = 0 ; i < arr.length ; i++) {
            if(i % 2 == 0) {
                sum += arr[i];
            }
        }

        System.out.println("Sum Elements in the even index of the given array "+ Arrays.toString(arr) +" is "+ sum);
    }

    public static void arraySumEvenIndexMethod2(int[] arr) {
        int sum = 0;
        getArray(arr);

        for(int i = 0 ; i < arr.length ; i += 2) {
            sum += arr[i];
        }

        System.out.println("Sum Elements in the even index of the given array "+ Arrays.toString(arr) +" is "+ sum);
    }


    public static void removeElement(int[] arr) {
        getArray(arr);

        int[] res = new int[arr.length -1];
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the element to remove:");
        int key = sc.nextInt();

        int index = 0;
        for(int i = 0 ; i < arr.length ; i++) {

            if(arr[i] != key) {
                res[index++] = arr[i];
            }
        }

        System.out.println("Original Array : "+ Arrays.toString(arr));
        System.out.println("Resulted Array : " +Arrays.toString(res));

    }

    public static void removeGivenElementOccurrence(int[] arr) {
        getArray(arr);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the element to remove:");
        int key = sc.nextInt();

        int count = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == key) {
                count++;
            }
        }


        if(count > 0) {
            int[] res = new int[arr.length - count];

            int index = 0;
            for(int i = 0 ; i < arr.length ; i++) {

                if(arr[i] != key) {
                    res[index++] = arr[i];
                }
            }

            System.out.println("Original Array : "+ Arrays.toString(arr));

            System.out.println("Resulted Array : " +Arrays.toString(res));

        }else {
            System.out.println("Element not found");
        }


    }


    public static void removeElementsInArrayIsElementsOfAnotherArray(int[] arr1 , int[] arr2) {

        getArray(arr1);


        for(int i = 0 ; i < arr2.length ; i++) {
            for(int j = 0 ; j < arr1.length ; j++) {

                if(arr1[j] == arr2[i]) {
                    arr1[j] = Integer.MIN_VALUE;
                }

            }
        }

        int count = 0;
        for(int a : arr1) {
            if(a == Integer.MIN_VALUE)
                count++;
        }

        int[] res = new int[arr1.length - count];

        int index = 0;
        for(int i = 0 ; i < arr1.length ; i++) {

            if(arr1[i] != Integer.MIN_VALUE) {
                res[index++] = arr1[i];
            }
        }

        System.out.println("Resulted Array : " +Arrays.toString(res));

    }


    public static void elementsFrequency(int[] arr) {
        getArray(arr);

        int count = 0;

        for(int i = 0 ; i < arr.length ; i++) {
            count = 1;
            for(int j = i+1 ; j < arr.length ; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = Integer.MIN_VALUE;
                    count++ ;
                }
            }
            if(arr[i] != Integer.MIN_VALUE)
                System.out.println(arr[i] +" : "+ count);

            count = 0;
        }

    }

    public static void combineTwoArraysMethod1(int[] arr) {
        getArray(arr);
        int[] arr1 = new int[5];
        getArray(arr1);
        int[] res = new int[arr.length + arr1.length];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            res[index++] = arr[i];
        }

        for (int i = 0; i < arr1.length; i++) {
            res[index++] = arr1[i];
        }
        System.out.println("Array 1 : "+ Arrays.toString(arr));
        System.out.println("Array 2 : "+ Arrays.toString(arr1));
        System.out.println("Resulted Array : "+ Arrays.toString(res));
    }

    public static void combineTwoArraysMethod2(int[] arr) {
        getArray(arr);
        int[] arr1 = new int[5];
        getArray(arr1);
        int[] res = new int[arr.length + arr1.length];

        for (int i = 0; i < res.length; i++) {
            if(i < arr.length)
                res[i] = arr[i];
            else
                res[i] = arr1[i - arr1.length];

        }
        System.out.println("Array 1 : "+ Arrays.toString(arr));
        System.out.println("Array 2 : "+ Arrays.toString(arr1));
        System.out.println("Resulted Array : "+ Arrays.toString(res));
    }

    public static void isSorted(int[] arr){

        boolean isSorted = true;
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i] < arr[i-1]){
                isSorted = false;
            }
        }

        System.out.println("Is array Sorted: " + isSorted);
    }


    static void reverse(int[] arr){

        int count = 0;
        int count_rev = arr.length-1;
        while(count <= ((arr.length-1)/2)){
            swap(arr,count,count_rev);
            count++;
            count_rev--;
        }
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }








    public static void twoSum(int[] nums, int target) {
        for(int i=0 ; i<nums.length -1 ; i++){
            for(int j=i+1 ; j<=nums.length -1; j++){
                if((nums[i]+nums[j]) == target){
                    System.out.println(i + "," +j);
                }
            }
        }
        System.out.println("No ans");
    }


    public static void plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                System.out.println(Arrays.toString(digits));
                return;
            }
            digits[i] = 0;
        }

        // If we are here, all digits were 9
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;  // e.g., 999 → 1000
        System.out.println(Arrays.toString(newDigits));
    }



    static void getArray(int[] arr){
        Scanner sc = new Scanner(System.in);
        for(int i=0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
    }

    public static void printArrayUsingForEach(int arr[]) {
        for(int ele : arr) {
            System.out.println(ele);
        }
    }

    public static void printArray(int arr[]) {
        for(int i = 0 ; i <= arr.length - 1 ; i++) {
            System.out.println(arr[i]);
        }
    }


}
