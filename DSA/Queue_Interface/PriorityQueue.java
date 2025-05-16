package Java_Bootcamp.DSA.Queue_Interface;

import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;

public class PriorityQueue {
    public static void main(String[] args) {

        //The PriorityQueue class in Java is part of the java.util package. It is known that a Queue follows the FIFO(First-In-First-Out) Algorithm,
        //but the elements of the Queue are needed to be processed according to the priority, that’s when the PriorityQueue comes into play.


        Queue<Integer> p = new java.util.PriorityQueue<>();
        Queue<Integer> p1 = new java.util.PriorityQueue<>(Collections.reverseOrder());


        // Add elements to the queue
        p.add(3);
        p.add(10);
        p.add(7);
        p.add(2);

        p1.addAll(p);

        Iterator iterator = p.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("Break");

        while(!p1.isEmpty()){
            System.out.println(p1.poll());
        }




    }
}
