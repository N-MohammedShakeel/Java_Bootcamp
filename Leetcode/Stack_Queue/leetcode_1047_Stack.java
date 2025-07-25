package Java_Bootcamp.Leetcode.Stack_Queue;

import java.util.Stack;

public class leetcode_1047_Stack {
    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek() == ch) st.pop();
            else st.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
