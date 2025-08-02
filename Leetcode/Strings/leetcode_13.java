package Java_Bootcamp.Leetcode.Strings;

public class leetcode_13 {
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();

        String roman = "IVXLCDM";
        int[] number = {1, 5, 10, 50, 100, 500, 1000};

        int ans = 0;
        for (int i = 0; i < ch.length; i++) {
            int currentVal = number[roman.indexOf(ch[i])];
            int nextVal = 0;
            if (i + 1 < ch.length) {
                nextVal = number[roman.indexOf(ch[i + 1])];
            }
            if (currentVal < nextVal) {
                ans -= currentVal;
            } else {
                ans += currentVal;
            }
        }

        return ans;
    }
}
