package Java_Bootcamp.Leetcode.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode_451 {
    public String frequencySort(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            char ch = entry.getKey();
            int fq = entry.getValue();

            for (int i = 0; i < fq; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
