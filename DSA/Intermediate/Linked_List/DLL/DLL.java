package Java_Bootcamp.DSA.Intermediate.Linked_List.DLL;

public class DLL {
    private DLLNode head;

    public void insertFirst(int val) {
        DLLNode node = new DLLNode(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int val) {
        DLLNode node = new DLLNode(val);
        DLLNode last = head;

        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public DLLNode find(int value) {
        DLLNode node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int val) {
        DLLNode p = find(after);

        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        DLLNode node = new DLLNode(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    public void display() {
        DLLNode node = head;
        DLLNode last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    public DLLNode getHead() {
        return head;
    }
}

