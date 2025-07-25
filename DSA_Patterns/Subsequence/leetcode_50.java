package Java_Bootcamp.DSA_Patterns.Subsequence;

public class leetcode_50 {
    public double myPow(double x, int n) {

        double ans = 1.0;
        long nn = n;

        if(nn < 0) nn *= -1;

        while(nn > 0){
            if(nn % 2 == 0){
                x = x * x;
                nn /= 2;
            }else{
                ans = ans * x;
                nn -= 1;
            }
        }

        if(n < 0) ans = (double)(1) / (double)(ans);

        return ans;
    }
}
