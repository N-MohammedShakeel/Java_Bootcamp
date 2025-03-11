package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // array of primitives
        int[] arr = new int[5];
        arr[0] = 23;
        arr[1] = 45;
        arr[2] = 233;
        arr[3] = 543;
        arr[4] = 3;

        System.out.println(Arrays.toString(arr));        // [23, 45, 233, 543, 3]
        System.out.println(arr[3]);     // 543


        int[] arr1 = new int[5];
        // input using for loops
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = in.nextInt();
        }

        // For displaying the array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        for(int num : arr) { // for every element in array, print the element
            System.out.print(num + " "); //  here num represents element of the array
        }

//        System.out.println(arr[6]); // index out of bound error

        // array of objects
        String[] str = new String[4];
        for (int i = 0; i < str.length; i++) {
            str[i] = in.next();   // String Array
        }

        System.out.println(Arrays.toString(str));

        // modify
        str[1] = "ms" + "";

        System.out.println(Arrays.toString(str));
    }
}
