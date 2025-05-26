package Java_Bootcamp.DSA.IntermediateToAdvance.Linked_List.SLL;

public class LLNode {
    int value;
    LLNode next;

    public LLNode(int value) {
        this.value = value;
    }

    public LLNode(int value, LLNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public LLNode getNext() {
        return next;
    }
}