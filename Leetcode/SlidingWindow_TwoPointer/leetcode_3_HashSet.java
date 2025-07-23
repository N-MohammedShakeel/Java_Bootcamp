package Java_Bootcamp.Leetcode.SlidingWindow_TwoPointer;

import java.util.HashSet;
import java.util.Set;

public class leetcode_3_HashSet {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int maxLen = 0;

        int left = 0;

        for(int right = 0 ; right < s.length() ; right++){
            char ch = s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
