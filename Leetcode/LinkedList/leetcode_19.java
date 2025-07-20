package Java_Bootcamp.Leetcode.LinkedList;

public class leetcode_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (size == n) {
            return head.next;
        }

        temp = head;
        for (int i = 0; i < size - n - 1; i++) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }
}
