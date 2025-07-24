package Java_Bootcamp.Leetcode.Strings;

public class leetcode_205 {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length())
            return false;

        int[] sMatch = new int[256];
        int[] tMatch = new int[256];

        for(int i=0 ; i < s.length() ; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(sMatch[ch1] != tMatch[ch2])
                return false;

            sMatch[ch1] = i+1;
            tMatch[ch2] = i+1;
        }

        return true;
    }
}
