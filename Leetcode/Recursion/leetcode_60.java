package Java_Bootcamp.Leetcode.Recursion;

import java.util.ArrayList;

public class leetcode_60 {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> num = new ArrayList<>();
        int[] fact = new int[n+1];
        fact[0] = 1;

        for(int i=1 ; i<=n ; i++){
            num.add(i);
            fact[i] = fact[i-1] * i;
        }

        k--;
        StringBuilder res = new StringBuilder();

        for(int i=n ; i>=1 ; i--){
            int index = k / fact[i-1];
            res.append(num.get(index));
            num.remove(index);
            k = k % fact[i-1];
        }

        return new String(res);
    }
}
