package Java_Bootcamp.Leetcode_Top_25.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/insert-interval/description/
public class Problem_57 {
    public static void main(String[] args) {

        int[][] arr1 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] arr2 = {4,8};

        System.out.println(Arrays.deepToString(insert(arr1,arr2)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
