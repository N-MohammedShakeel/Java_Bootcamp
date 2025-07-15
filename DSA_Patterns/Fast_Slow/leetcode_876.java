package Java_Bootcamp.DSA_Patterns.Fast_Slow;

public class leetcode_876 {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head , fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
