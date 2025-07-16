package Java_Bootcamp.DSA_Patterns.Fast_Slow;

public class leetcode_142 {
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
