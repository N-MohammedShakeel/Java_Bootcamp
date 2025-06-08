package Java_Bootcamp.DSA.Basic.String.Medium;

// StringToInteger.java
// Converts string to integer, handling signs and overflow
// Time: O(n), Space: O(1)

public class StringToInteger {
    public static void main(String[] args) {
        // Test case
        System.out.println("String to Integer (atoi): " + myAtoi("42")); // 42
    }

    // Converts string to integer, handling signs and overflow
    // Time: O(n), Space: O(1)
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sign = 1, i = 0;
        if (s.charAt(0) == '-') { sign = -1; i++; }
        else if (s.charAt(0) == '+') i++;
        long result = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) (result * sign);
    }
}