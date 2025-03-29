package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.Greedy;

import java.util.Arrays;

//https://leetcode.com/problems/assign-cookies/description/
public class AssignCookies {
    public static void main(String[] args) {

        int[] childrens = {1,2,3};
        int[] cookies = {1,1};

        int res = findContentChildren(childrens,cookies);
        System.out.println(res);
    }

    public static int findContentChildren(int[] g, int[] s) {
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
