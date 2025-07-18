package Java_Bootcamp.Leetcode.Array;

public class leetcode_121 {
    public int maxProfit(int[] prices) {

        int min = prices[0];
        int profit = 0;

        for(int i=1 ; i<prices.length ; i++){
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }
}
