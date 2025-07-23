package Java_Bootcamp.Leetcode.GreedyAlgorithm;

import java.util.Arrays;

public class leetcode_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gindex = 0;
        int sindex = 0;
        int res = 0;

        while (gindex < g.length && sindex < s.length) {
            if (s[sindex] >= g[gindex]) {
                res++;
                gindex++;
            }
            sindex++;
        }
        return res;
    }
}
