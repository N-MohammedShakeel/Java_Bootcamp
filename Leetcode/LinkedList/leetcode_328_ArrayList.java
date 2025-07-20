package Java_Bootcamp.Leetcode.LinkedList;

import java.util.ArrayList;

public class leetcode_328_ArrayList {
    public ListNode oddEvenList(ListNode head) {

        if (head == null) return null;

        ArrayList<Integer> list = new ArrayList<>();
        ListNode i = head;

        while(i != null){
            list.add(i.val);
            if(i.next == null) break;
            i = i.next.next;
        }

        i = head.next;
        while(i != null){
            list.add(i.val);
            if(i.next == null) break;
            i = i.next.next;
        }

        i = head;
        int k = 0;
        while(i != null){
            i.val = list.get(k++);
            i = i.next;
        }

        return head;
    }
}
