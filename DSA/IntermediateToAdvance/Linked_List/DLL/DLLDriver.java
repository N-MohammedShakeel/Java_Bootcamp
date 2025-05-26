package Java_Bootcamp.DSA.IntermediateToAdvance.Linked_List.DLL;

public class DLLDriver {
    public static void main(String[] args) {
        DLL dll = new DLL();

        System.out.println("=== Insert First ===");
        dll.insertFirst(10);
        dll.insertFirst(20);
        dll.insertFirst(30);
        dll.display();

        System.out.println("\n=== Insert Last ===");
        dll.insertLast(5);
        dll.insertLast(2);
        dll.display();

        System.out.println("\n=== Insert After a Node ===");
        dll.insert(10, 100);  // Insert 100 after 10
        dll.display();

        System.out.println("\n=== Try to Insert After Non-existent Node ===");
        dll.insert(999, 500);  // Should print a message

        System.out.println("\n=== Final List ===");
        dll.display();
    }
}
