package Java_Bootcamp.Leetcode.Heap;

import java.util.PriorityQueue;

public class leetcode_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0 ; i < nums.length ; i++){
            q.offer(nums[i]);
        }

        while(k-- > 0){
            q.offer(-(q.poll()));
        }

        int res = 0;
        while(!q.isEmpty()){
            res += q.poll();
        }

        return res;
    }
}
