package Java_Bootcamp.DSA.Linked_List.DLL;

public class DLLNode {
    int val;
    DLLNode next;
    DLLNode prev;

    public DLLNode(int val) {
        this.val = val;
    }

    public DLLNode(int val, DLLNode next, DLLNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
