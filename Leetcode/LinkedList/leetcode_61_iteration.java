package Java_Bootcamp.Leetcode.LinkedList;

public class leetcode_61_iteration {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return head;

        ListNode tail = head;
        int size = 1;
        while(tail.next != null) {
            tail = tail.next;
            size++;
        }

        k = k % size;
        if(k == 0) return head;

        tail.next = head;

        ListNode newTail = head;
        for(int i = 0; i < size - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
