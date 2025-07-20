package Java_Bootcamp.Leetcode.LinkedList;

public class leetcode_160_iteration {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int sa = 0;
        int sb = 0;
        ListNode tempa = headA;
        ListNode tempb = headB;

        while (tempa!=null){
            tempa = tempa.next;
            sa++;
        }

        while (tempb!=null){
            tempb = tempb.next;
            sb++;
        }

        while (sa > sb){
            headA = headA.next;
            sa--;
        }
        while (sb > sa){
            headB = headB.next;
            sb--;
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
