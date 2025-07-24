package Java_Bootcamp.Leetcode.Strings;

public class leetcode_14 {
    public String longestCommonPrefix(String[] arr) {

        if (arr == null || arr.length == 0) return "";

        String s = arr[0];

        for (int i = 1; i < arr.length; i++) {
            while (!arr[i].startsWith(s)) {
                s = s.substring(0, s.length() - 1);
                if (s.isEmpty()) return "";
            }
        }

        return s;

    }
}
