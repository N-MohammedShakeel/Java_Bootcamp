package Java_Bootcamp.Leetcode.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_225 {

    class MyStack {
        private Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<>();
        }

        public void push(int x) {
            q.offer(x);
            for (int i = 0; i < q.size() - 1; i++) {
                q.offer(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

}
