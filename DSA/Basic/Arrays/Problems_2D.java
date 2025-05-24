package Java_Bootcamp.DSA.Basic.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Problems_2D {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array 1 ");
        System.out.print("Row size: ");
        int size1 = sc.nextInt();
        System.out.print("Col size: ");
        int size2 = sc.nextInt();
        int[][] arr1 = new int[size1][size2];
        System.out.println("Enter array 1 elements ");
        getArray(arr1);

        System.out.println("Enter the size of array 2 ");
        System.out.print("Row size: ");
        size1 = sc.nextInt();
        System.out.print("Col size: ");
        size2 = sc.nextInt();
        int[][] arr2 = new int[size1][size2];
        System.out.println("Enter array 2 elements ");
        getArray(arr2);

        getArray(arr1);
        printArray(arr1);


        rotateImageUsingAdditionalArray(arr1);
        rotateImageWithoutUsingAdditionalArray(arr1);

        add2DArray(arr1,arr2);
        mul2DArray(arr1,arr2);
        sub2DArray(arr1,arr2);
        transpose(arr1);


    }


    public static void rotateImageUsingAdditionalArray(int[][] matrix) {

        int[][] temp = new int[matrix.length][matrix[0].length];

        for(int i=0 ; i < matrix.length ; i++){
            for(int j=0 ; j < matrix[i].length ; j++){
                temp[i][j] = matrix[j][i];
            }
        }

        for(int i=0 ; i < matrix.length ; i++){
            int count = 0;
            for(int j=matrix[i].length -1 ; j >= 0  ; j--){
                matrix[i][count++] = temp[i][j];
            }
        }


    }

    public static void rotateImageWithoutUsingAdditionalArray(int[][] matrix) {


        int row = matrix.length;
        int col = matrix[0].length;

        for(int i=0 ; i < matrix.length ; i++){
            for(int j=0 ; j < matrix[i].length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        for(int i=0 ; i < row ; i++){
            int left = 0 , right = matrix.length - 1;
            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void add2DArray(int[][] arr1, int[][] arr2) {
        int[][] res = new int[arr1.length][arr1.length];

        for(int i = 0 ; i < arr1.length ; i++) {
            for(int j = 0 ; j< arr2.length ; j++) {
                res[i][j] = arr1[i][j] + arr2[i][j];
            }

        }
        printArray(res);
    }

    public static void mul2DArray(int[][] arr1, int[][] arr2) {
        int[][] res = new int[arr1.length][arr1.length];

        for(int i = 0 ; i < arr1.length ; i++) {
            for(int j = 0 ; j< arr2.length ; j++) {
                for(int k = 0 ; k < arr1.length ; k++ ) {
                    res[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        printArray(res);
    }

    public static void sub2DArray(int[][] arr1, int[][] arr2) {
        int[][] res = new int[arr1.length][arr1.length];

        for(int i = 0 ; i < arr1.length ; i++) {
            for(int j = 0 ; j< arr2.length ; j++) {
                res[i][j] = arr1[i][j] + arr2[i][j];
            }

        }
        System.out.println(Arrays.deepToString(res));
    }


    public static void transpose(int[][] arr1) {
        int[][] res = new int[arr1.length][arr1.length];

        for(int i = 0 ; i < arr1.length ; i++) {
            for(int j = 0 ; j< arr1.length ; j++) {
                res[i][j] = arr1[j][i];
            }

        }
        printArray(res);
    }


    public static void getArray(int[][] arr) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = 0 ; j< arr[i].length ; j++) {
                arr[i][j] = sc.nextInt();
            }

        }
    }

    public static void printArrayUsingForEach(int arr[][]) {
        for(int[] ele : arr) {
            for(int el : ele) {
                System.out.print(el);
            }
            System.out.println();
        }
    }


    public static void printArray(int[][] arr) {

        for(int i = 0 ; i < arr.length  ; i++) {
            for(int j = 0 ; j< arr.length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }
    }
}
