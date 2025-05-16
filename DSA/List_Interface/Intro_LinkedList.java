package Java_Bootcamp.DSA.List_Interface;

import java.util.Iterator;
import java.util.LinkedList;

public class Intro_LinkedList {
    public static void main(String[] args) {

        // Creating a LinkedList
        LinkedList<String> l = new LinkedList<String>();

        // Adding elements to the LinkedList using add() method
        l.add("One");
        l.add("Two");
        l.add("Three");
        l.add("Four");
        l.add("Five");

        Object[] a = l.toArray();
        for(Object element : a)
            System.out.println(element+" ");


        l.add(2,"2");
        // Printing the LinkedList
        System.out.println(l);

        l.remove(2);

        System.out.println(l);

        Iterator<String> listI = l.listIterator();

        for (Iterator<String> it = listI; it.hasNext(); ) {
            String e = it.next();
            System.out.println(e);
        }

    }
}
