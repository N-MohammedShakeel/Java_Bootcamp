package Java_Bootcamp.Leetcode.Stack_Queue;

public class leetcode_1047_Array {
    public static String removeDuplicates(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for( char ch : s.toCharArray()){
            if( top != -1 && stack[top] == ch ){
                top--;
            } else {
                stack[++top] = ch;
            }
        }
        return new String(stack, 0, top+1);
    }
}
