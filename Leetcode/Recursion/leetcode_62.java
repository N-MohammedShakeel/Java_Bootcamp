package Java_Bootcamp.Leetcode.Recursion;

public class leetcode_62 {

    public int uniquePaths(int m, int n) {

        long res = 1;
        int nu = m + n - 2;
        int de = Math.min(m-1,n-1);

        for(int i=0 ; i<de ; i++){
            res = res * (nu - i);
            res = res / (i + 1);
        }

        return (int)res;
    }
}
