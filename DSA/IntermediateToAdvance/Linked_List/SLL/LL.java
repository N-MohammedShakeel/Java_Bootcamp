package Java_Bootcamp.DSA.IntermediateToAdvance.Linked_List.SLL;

public class LL {

    private LLNode head;
    private LLNode tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        LLNode temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        LLNode node = new LLNode(val, temp.next);
        temp.next = node;
        size++;
    }

    public void insertFirst(int val) {
        LLNode node = new LLNode(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        LLNode node = new LLNode(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public int delete(int index) {
        if (index == 0) return deleteFirst();
        if (index == size - 1) return deleteLast();

        LLNode prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1) return deleteFirst();

        LLNode secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public LLNode find(int value) {
        LLNode node = head;
        while (node != null) {
            if (node.value == value) return node;
            node = node.next;
        }
        return null;
    }

    public LLNode get(int index) {
        LLNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void display() {
        LLNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private LLNode insertRec(int val, int index, LLNode node) {
        if (index == 0) {
            LLNode temp = new LLNode(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) return;

        if (col < row) {
            LLNode first = get(col);
            LLNode second = get(col + 1);

            if (first.value > second.value) {
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    LLNode prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    LLNode prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    public void reverse() {
        if (size < 2) return;

        LLNode prev = null;
        LLNode present = head;
        LLNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

    public void reverseRecursively() {
        reverse(head);
    }

    private void reverse(LLNode node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public static LLNode findMiddle(LLNode head) {
        LLNode slow = head;
        LLNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    public LLNode getHead() {
        return head;
    }
}