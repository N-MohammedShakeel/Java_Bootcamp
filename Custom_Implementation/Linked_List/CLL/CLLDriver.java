package Java_Bootcamp.Custom_Implementation.Linked_List.CLL;

public class CLLDriver {
    public static void main(String[] args) {
        CLL list = new CLL();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println("Circular Linked List:");
        list.display();

        System.out.println("Deleting 30:");
        list.delete(30);
        list.display();

        System.out.println("Deleting 10 (head):");
        list.delete(10);
        list.display();

        System.out.println("Deleting 50 (tail):");
        list.delete(50);
        list.display();
    }
}
