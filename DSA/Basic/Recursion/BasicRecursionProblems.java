package Java_Bootcamp.DSA.Basic.Recursion;// Recursion in Java:
// - Recursion is a process where a method calls itself to solve a problem by breaking it into smaller subproblems.
// - Key Components:
//   - Base Case: Condition to stop recursion and prevent infinite calls.
//   - Recursive Case: The part where the method calls itself with modified parameters.
// - Advantages: Simplifies complex problems (e.g., tree traversals, divide-and-conquer).
// - Disadvantages: Can lead to stack overflow for large inputs; higher space complexity due to call stack.
// - Java-Specific: Recursion uses the JVM call stack. Ensure base cases are well-defined to avoid StackOverflowError.
// - Time Complexity: Often O(n) or higher due to multiple calls.
// - Space Complexity: O(n) for call stack in most cases (n = input size), unless tail recursion is optimized (Java doesn't optimize tail recursion).

public class BasicRecursionProblems {
    public static void main(String[] args) {
        // Test cases for each recursive problem
        int n = 5;
        System.out.println("Print 'Hello' " + n + " times:");
        printNTimes("Hello", n); // Should print "Hello" 5 times
        
        System.out.println("\nPrint name 'ms' " + n + " times:");
        printNameNTimes("ms", n); // Should print "ms" 5 times
        
        System.out.println("\nPrint 1 to " + n + ":");
        print1ToN(1, n); // Should print 1 2 3 4 5
        
        System.out.println("\nPrint " + n + " to 1:");
        printNTo1(n); // Should print 5 4 3 2 1
        
        System.out.println("\nSum of first " + n + " numbers: " + sumOfN(n)); // Should print 15 (1+2+3+4+5)
        
        System.out.println("\nFactorial of " + n + ": " + factorial(n)); // Should print 120 (5!)
        
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("\nReverse array: ");
        reverseArray(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " "); // Should print 5 4 3 2 1
        }
        
        String str = "radar";
        System.out.println("\nIs '" + str + "' palindrome? " + isPalindrome(str, 0, str.length() - 1)); // Should print true
        
        System.out.println("\nFibonacci number at position " + n + ": " + fibonacci(n)); // Should print 5 (0, 1, 1, 2, 3, 5)
    }
    
    // Print Something N Times
    // Approach: Base case when n=0; print and recurse with n-1.
    // Time Complexity: O(n) - one call per recursion.
    // Space Complexity: O(n) - due to call stack.
    public static void printNTimes(String str, int n) {
        if (n == 0) return; // Base case
        System.out.println(str);
        printNTimes(str, n - 1); // Recursive case
    }
    
    // Print Name N Times
    // Approach: Similar to printNTimes, but specific to a name.
    // Time Complexity: O(n) - one call per recursion.
    // Space Complexity: O(n) - due to call stack.
    public static void printNameNTimes(String name, int n) {
        if (n == 0) return; // Base case
        System.out.println(name);
        printNameNTimes(name, n - 1); // Recursive case
    }
    
    // Print 1 to N
    // Approach: Start from i=1, print i, recurse with i+1 until i>n.
    // Time Complexity: O(n) - one call per number.
    // Space Complexity: O(n) - due to call stack.
    public static void print1ToN(int i, int n) {
        if (i > n) return; // Base case
        System.out.print(i + " ");
        print1ToN(i + 1, n); // Recursive case
    }
    
    // Print N to 1
    // Approach: Print n, recurse with n-1 until n=0.
    // Time Complexity: O(n) - one call per number.
    // Space Complexity: O(n) - due to call stack.
    public static void printNTo1(int n) {
        if (n == 0) return; // Base case
        System.out.print(n + " ");
        printNTo1(n - 1); // Recursive case
    }
    
    // Sum of First N Numbers
    // Approach: Base case n=0 returns 0; add n to sum of n-1.
    // Time Complexity: O(n) - one call per number.
    // Space Complexity: O(n) - due to call stack.
    public static int sumOfN(int n) {
        if (n == 0) return 0; // Base case
        return n + sumOfN(n - 1); // Recursive case
    }
    
    // Factorial of N
    // Approach: Base case n=0 or 1 returns 1; multiply n with factorial of n-1.
    // Time Complexity: O(n) - one call per number.
    // Space Complexity: O(n) - due to call stack.
    public static int factorial(int n) {
        if (n <= 1) return 1; // Base case
        return n * factorial(n - 1); // Recursive case
    }
    
    // Reverse an Array
    // Approach: Swap elements at start and end indices, recurse with updated indices until start>=end.
    // Time Complexity: O(n/2) = O(n) - processes half the array.
    // Space Complexity: O(n) - due to call stack.
    public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) return; // Base case
        // Swap elements
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1); // Recursive case
    }
    
    // Check if String is Palindrome
    // Approach: Compare characters at start and end, recurse inward until start>=end.
    // Time Complexity: O(n/2) = O(n) - processes half the string.
    // Space Complexity: O(n) - due to call stack.
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true; // Base case
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1); // Recursive case
    }
    
    // Fibonacci Number
    // Approach: Base cases n=0 returns 0, n=1 returns 1; return sum of fib(n-1) and fib(n-2).
    // Time Complexity: O(2^n) - each call branches into two (inefficient without memoization).
    // Space Complexity: O(n) - due to call stack depth.
    public static int fibonacci(int n) {
        if (n == 0) return 0; // Base case
        if (n == 1) return 1; // Base case
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
    }
}