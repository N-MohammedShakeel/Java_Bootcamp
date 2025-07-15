package Java_Bootcamp.DSA_Patterns.Fast_Slow;

public class leetcode_141 {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head , p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
