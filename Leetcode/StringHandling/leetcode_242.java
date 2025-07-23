package Java_Bootcamp.Leetcode.StringHandling;

import java.util.Arrays;

public class leetcode_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    static String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
