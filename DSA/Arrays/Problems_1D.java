package Java_Bootcamp.DSA.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Problems_1D {

    public static void main(String[] args) {

        int[] arr = new int[5];
        getArray(arr);

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
//        reverse(arr);

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
//        twoSum(arr,4);
//        plusOne(arr);

        printArray(arr);


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
        for(int i=0 ; i<arr.length ; i++){
            if (arr[i] != Integer.MAX_VALUE){
                arr1[count] = arr[i];
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
        for (int i=0 ; i<arr.length ; i++){
            if(arr[i] != Integer.MAX_VALUE){
                count_un++;
            }
        }

        System.out.println("Unique: " + count_un + "\nDuplicate: " + count_dup);
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
        getArray(digits);

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                printArray(digits);
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        printArray(digits);
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
