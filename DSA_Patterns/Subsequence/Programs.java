package Java_Bootcamp.DSA_Patterns.Subsequence;

import java.util.ArrayList;
import java.util.List;

public class Programs {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        generateSubsequences(0, arr, new ArrayList<>(), result);

         for (List<Integer> seq : result) {
            System.out.println(seq);
        }
    }

    static void generateSubsequences(int index, int[] arr, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(arr[index]);
        generateSubsequences(index + 1, arr, current, result);

        current.removeLast();
        generateSubsequences(index + 1, arr, current, result);
    }

}
