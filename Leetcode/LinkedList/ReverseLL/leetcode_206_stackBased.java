package Java_Bootcamp.Leetcode.LinkedList.ReverseLL;

import Java_Bootcamp.Leetcode.LinkedList.ListNode;

import java.util.Stack;

class leetcode_206_stackBased {
    public ListNode reverseList(ListNode head) {

        Stack<Integer> s = new Stack<>();

        ListNode temp = head;

        while(temp != null){
            s.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            temp.val = s.pop();
            temp = temp.next;
        }

        return head;
        
    }
}