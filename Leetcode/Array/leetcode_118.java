package Java_Bootcamp.Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class leetcode_118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1 ; i <= numRows ; i++){
            pascalTriangleFindRow(i,list);
        }

        return list;
    }

    static void pascalTriangleFindRow(int row , List<List<Integer>> list){

        ArrayList<Integer> dummy = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            dummy.add(binomialCoefficient(row - 1, i));
        }

        list.add(dummy);
    }

    static int binomialCoefficient(int n, int k) {
        int res = 1;
        for (int i = 0; i < k; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
}
