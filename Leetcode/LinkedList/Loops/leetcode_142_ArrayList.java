package Java_Bootcamp.Leetcode.LinkedList.Loops;

import Java_Bootcamp.Leetcode.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class leetcode_142_ArrayList {

    public ListNode sortList(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(list);
        int k = 0;
        temp = head;

        while(temp != null){
            temp.val = list.get(k++);
            temp = temp.next;
        }
        return head;
    }
}
