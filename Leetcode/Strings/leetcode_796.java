package Java_Bootcamp.Leetcode.Strings;

public class leetcode_796 {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        String str = s + s;
        return str.contains(goal);
    }
}
