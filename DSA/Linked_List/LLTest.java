package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.DSA.Linked_List;

public class LLTest {

    int size;
    Node head;
    Node tail;

    LLTest(){
        size = 0;
    }

    public void insert(int val){

        if(size == 0){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);

        tail.next = node;
        tail = node;
        size++;
    }

    public void insertFirst(int val){

        if(size == 0){
            Node node = new Node(val);
            head = node;
            tail = node;
            size++;
            return;
        }
        if(head == null){
            head = tail;
        }

        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void insertLast(int val){

        if(size == 0){
            insertFirst(val);
        }

        Node node =  new Node(val);

        tail.next = node;
        tail = node;
        size++;
    }

    public void delete(int val){

        Node temp = head;

        if(temp.val == val){
            head = head.next;
            temp.next = null;
            size--;
            return;
        }


        while(temp.next.val != val){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        size--;

    }



    public void display(){

        Node temp = head;

        for(int i=0 ; i < size ; i++){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }


    class Node{

        int val ;
        Node next;

        Node(int val){
            this.val = val;
        }

        Node(int val , Node next){
            this.val = val;
            this.next = next;
        }

    }



    public static void main(String[] args) {

        LLTest ll = new LLTest();

        ll.insert(5);
        ll.insert(6);
        ll.insert(7);
        ll.insertFirst(4);
        ll.insertLast(8);

        ll.delete(7);

        ll.display();

    }
}
