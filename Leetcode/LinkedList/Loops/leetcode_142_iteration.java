package Java_Bootcamp.Leetcode.LinkedList.Loops;

import Java_Bootcamp.Leetcode.LinkedList.ListNode;

public class leetcode_142_iteration {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head , fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){

                slow = head;
                while(slow != fast){

                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
