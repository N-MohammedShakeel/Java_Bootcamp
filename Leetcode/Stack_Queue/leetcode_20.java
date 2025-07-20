package Java_Bootcamp.Leetcode.Stack_Queue;

import java.util.Stack;

public class leetcode_20 {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(char ch:s.toCharArray()){

            if(ch=='[') st.push(']');
            else if(ch=='{') st.push('}');
            else if(ch=='(') st.push(')');
            else if(st.isEmpty()|| st.pop() != ch) return false;
        }
        return st.isEmpty();
    }
}
