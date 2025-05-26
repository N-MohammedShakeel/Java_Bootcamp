package Java_Bootcamp.DSA.IntermediateToAdvance.Linked_List.SLL;

/**
 * Combined driver class for Linked List operations.
 *
 * Operations:
 * 1. Bubble Sort (Custom)
 * 2. Reverse Iteratively – LeetCode: https://leetcode.com/problems/reverse-linked-list/
 * 3. Reverse Recursively – LeetCode: https://leetcode.com/problems/reverse-linked-list/
 * 4. Find Middle Node – LeetCode: https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class LLDriver {
    public static void main(String[] args) {
        LL list = new LL();

        list.insertLast(10);
        list.insertLast(30);
        list.insertLast(20);
        list.insertLast(50);
        list.insertLast(40);

        System.out.println("Original List:");
        list.display();

//        System.out.println("\nAfter Bubble Sort:");
//        list.bubbleSort();
//        list.display();
//
//        System.out.println("\nAfter Reversing:");
//        list.reverse();
//        list.display();
//
//        System.out.println("\nReversing Recursively:");
//        list.reverseRecursively();
//        list.display();
//
//        System.out.println("\nMiddle Node:");
//        LLNode middle = LL.findMiddle(list.getHead());
//        System.out.println("Middle: " + (middle != null ? middle.getValue() : "null"));
    }
}