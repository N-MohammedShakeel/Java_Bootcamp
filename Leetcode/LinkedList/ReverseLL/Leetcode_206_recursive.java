package Java_Bootcamp.Leetcode.LinkedList.ReverseLL;

import Java_Bootcamp.Leetcode.LinkedList.ListNode;

class Leetcode_206_recursive {

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode newNode = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newNode;
    }
}