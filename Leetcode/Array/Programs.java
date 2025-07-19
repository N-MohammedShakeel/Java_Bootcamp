package Java_Bootcamp.Leetcode.Array;

public class Programs {

    public static void main(String[] args) {

        int[] arr = {10,22,12,3,0,6};
//        leaderInArray(arr);
//        pascalTriangleFindElement(5,3);
//        pascalTriangleFindRow(6);
        pascalTriangle(6);
    }

    static void pascalTriangle(int rows){
        for (int i = 1 ; i <= rows ; i++){
            for (int s = 0; s < rows - i; s++) {
                System.out.print(" ");
            }
            pascalTriangleFindRow(i);
        }
    }

    static void pascalTriangleFindRow(int row){

        for (int i = 0; i < row; i++) {
            System.out.print(binomialCoefficient(row - 1, i) + " ");
        }
        System.out.println();
    }

    static int binomialCoefficient(int n, int k) {
        int res = 1;
        for (int i = 0; i < k; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }


    static void pascalTriangleFindElement(int row , int col) {

        int res = 1;
        row = row -1;
        col = col -1;

        for (int i = 0; i < col; i++) {
            res = res * (row - i);
            res = res / (i + 1);
        }

        System.out.println("Element at (" + row + ", " + col + ") = " + res);
    }

    static void leaderInArray(int[] arr){

        int max = arr[arr.length-1];

        System.out.println(max);
        for(int i = arr.length-2 ; i >= 0 ; i--){
            if(arr[i] > max){
                System.out.println(arr[i]);
            }
            max = Math.max(max,arr[i]);
        }

    }
}
