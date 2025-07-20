package Java_Bootcamp.Leetcode.LinkedList;

public class leetcode_25 {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while (hasKNodes(curr, k)) {
            ListNode groupStart = curr;
            ListNode prev = null;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            prevGroupEnd.next = prev;
            groupStart.next = curr;

            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private boolean hasKNodes(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            if (node == null) return false;
            node = node.next;
        }
        return true;
    }
}
