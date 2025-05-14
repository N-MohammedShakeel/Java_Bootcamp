package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.DSA.Queue_Interface;

import java.util.LinkedList;
import java.util.Queue;

public class Intro_Queue {
    public static void main(String[] args) {
//        The Queue Interface is present in java.util package and extends the Collection interface.
//        It stores and processes the data in FIFO(First In First Out) order.
//        It is an ordered list of objects limited to inserting elements at the end of the list and deleting elements from the start of the list.

        Queue<String> q = new LinkedList<String>();

        // Queue is a interface and we cannot use it directly because then we need to implement all its methods
        // So that we use LinkedList class , this class implements Queue interface so we can use all the features of queue.

        // add = enqueue , offer()
        // remove = dequeue , poll();

        q.add("C");
        q.offer("java");  // recommended
        q.offer("python");

        System.out.println(q); // [C, java, python]

        System.out.println(q.peek()); // Shows First Element C

        System.out.println(q.poll()); // removes First Element C  // recommended

        System.out.println(q.remove()); // removes First Element java

        System.out.println(q); // [python]

        System.out.println(q.isEmpty() + " " + q.size() + " " + q.contains("java"));


        Queue<Integer> q1 = new LinkedList<Integer>();


        for(int i=1 ; i<10 ; i++){
            q1.add(i);
        }

        while(!q1.isEmpty()){
            System.out.println(q1.poll());
        }


    }
}
