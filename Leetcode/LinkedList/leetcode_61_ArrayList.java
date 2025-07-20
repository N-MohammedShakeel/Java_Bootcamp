package Java_Bootcamp.Leetcode.LinkedList;

import java.util.ArrayList;

public class leetcode_61_ArrayList {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return head;

        ListNode temp = head;
        ArrayList<Integer> list = new ArrayList<>();

        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        int n = k % list.size();

        while(n-- > 0){
            int val = list.getLast();
            list.addFirst(val);
            list.removeLast();
        }

        temp = head;
        int i = 0;

        while(temp != null){
            temp.val = list.get(i++);
            temp = temp.next;
        }

        return head;
    }
}
