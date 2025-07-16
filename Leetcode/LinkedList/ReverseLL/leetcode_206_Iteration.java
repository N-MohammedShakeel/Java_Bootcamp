package Java_Bootcamp.Leetcode.LinkedList.ReverseLL;

import Java_Bootcamp.Leetcode.LinkedList.ListNode;

class leetcode_206_Iteration {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null; 

        while (current != null) {
            next = current.next;    
            current.next = prev;    
            prev = current;        
            current = next;         
        }
        return prev;
        
    }
}