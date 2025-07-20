package Java_Bootcamp.Leetcode.LinkedList;

import java.util.HashSet;

public class leetcode_160_HashSet {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();

        ListNode temp = headA;

        while(temp != null){
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            if(set.contains(temp)) return temp;
            temp = temp.next;
        }

        return null;
    }
}
