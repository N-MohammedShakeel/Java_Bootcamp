package Java_Bootcamp.Custom_Implementation.Linked_List.CLL;

public class CLL {

    private CLLNode head;
    private CLLNode tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        CLLNode node = new CLLNode(val);
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        CLLNode node = head;
        if (head != null) {
            do {
                System.out.print(node.val + " -> ");
                node = node.next;
            } while (node != head);
        }
        System.out.println("HEAD");
    }

    public void delete(int val) {
        CLLNode node = head;
        if (node == null) {
            return;
        }

        if (head == tail && head.val == val) {
            head = null;
            tail = null;
            return;
        }

        if (head.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            CLLNode nextNode = node.next;
            if (nextNode.val == val) {
                node.next = nextNode.next;
                if (nextNode == tail) {
                    tail = node;
                }
                break;
            }
            node = node.next;
        } while (node != head);
    }
}

