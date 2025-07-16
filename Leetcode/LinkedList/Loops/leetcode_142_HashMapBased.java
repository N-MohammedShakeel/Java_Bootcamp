package Java_Bootcamp.Leetcode.LinkedList.Loops;

import Java_Bootcamp.Leetcode.LinkedList.ListNode;

import java.util.HashMap;

public class leetcode_142_HashMapBased {
    public ListNode detectCycle(ListNode head) {

        HashMap<ListNode, Integer> map = new HashMap<>();

        ListNode temp = head;
        while(temp != null){

            if(map.containsKey(temp)){
                return temp;
            }else{
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            temp = temp.next;
        }

        return null;
    }
}
