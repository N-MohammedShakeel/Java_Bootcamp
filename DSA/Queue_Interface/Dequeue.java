package Java_Bootcamp.DSA.Queue_Interface;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Dequeue {
    public static void main(String[] args) {

        // Create a Deque of Strings
        Deque<String> dq = new ArrayDeque<>();

        dq.addFirst("1");
        dq.addLast("2");

        String f = dq.removeFirst();
        String l = dq.removeLast();

        dq.add("For");
        dq.addFirst("Geeks");
        dq.addLast("Geeks");

        System.out.println(dq);

        for (Iterator itr = dq.iterator(); itr.hasNext();) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        for (Iterator itr = dq.descendingIterator(); itr.hasNext();) {
            System.out.print(itr.next() + " ");
        }

        System.out.println(dq.pop());

        System.out.println(dq.poll());

        System.out.println(dq.pollFirst());

        System.out.println(dq.pollLast());

      //  -------------------------------

        Deque<String> deque = new LinkedList<String>();

        // We can add elements to the queue
        // in various ways

        // Add at the last
        deque.add("Element 1 (Tail)");

        // Add at the first
        deque.addFirst("Element 2 (Head)");

        // Add at the last
        deque.addLast("Element 3 (Tail)");

        // Add at the first
        deque.push("Element 4 (Head)");

        // Add at the last
        deque.offer("Element 5 (Tail)");

        // Add at the first
        deque.offerFirst("Element 6 (Head)");

        System.out.println(deque + "\n");

        // We can remove the first element
        // or the last element.
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removing "
                + "first and last: "
                + deque);
    }
}
