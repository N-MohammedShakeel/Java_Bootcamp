package Java_Bootcamp.DSA.Basic.Stack;
// Stack Implementation using Array
class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // Push operation
    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
        } else {
            throw new IllegalStateException("Stack Overflow");
        }
    }

    // Pop operation
    public int pop() {
        if (top >= 0) {
            return stackArray[top--];
        } else {
            throw new IllegalStateException("Stack Underflow");
        }
    }

    // Peek operation
    public int peek() {
        if (top >= 0) {
            return stackArray[top];
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get size of stack
    public int size() {
        return top + 1;
    }
}

// Problem 1: Reverse a String using Stack
class ReverseString {
    public static String reverse(String str) {
        Stack stack = new Stack(str.length());
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append((char) stack.pop());
        }
        return reversed.toString();
    }
}

// Problem 2: Check for Balanced Parentheses
class BalancedParentheses {
    public static boolean isBalanced(String s) {
        Stack stack = new Stack(s.length());
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char top = (char) stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

// Problem 3: Evaluate Postfix Expression
class PostfixEvaluation {
    public static int evaluate(String exp) {
        Stack stack = new Stack(exp.length());
        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
}

// Problem 4: Convert Infix to Postfix
class InfixToPostfix {
    private static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    public static String convert(String infix) {
        Stack stack = new Stack(infix.length());
        StringBuilder postfix = new StringBuilder();
        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append((char) stack.pop());
                }
                stack.pop(); // Remove '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence((char) stack.peek())) {
                    postfix.append((char) stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append((char) stack.pop());
        }
        return postfix.toString();
    }
}

// Problem 5: Next Greater Element
class NextGreaterElement {
    public static int[] nextGreater(int[] arr) {
        int[] result = new int[arr.length];
        Stack stack = new Stack(arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
}

// Problem 6: Implement Two Stacks in One Array
class TwoStacks {
    private int[] arr;
    private int top1, top2;
    private int size;

    public TwoStacks(int n) {
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = n;
    }

    public void push1(int x) {
        if (top1 < top2 - 1) {
            arr[++top1] = x;
        } else {
            throw new IllegalStateException("Stack Overflow");
        }
    }

    public void push2(int x) {
        if (top1 < top2 - 1) {
            arr[--top2] = x;
        } else {
            throw new IllegalStateException("Stack Overflow");
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        }
        throw new IllegalStateException("Stack Underflow");
    }

    public int pop2() {
        if (top2 < size) {
            return arr[top2++];
        }
        throw new IllegalStateException("Stack Underflow");
    }
}

// Problem 7: Find Maximum Element in Stack
class MaxStack {
    private Stack stack;
    private Stack maxStack;

    public MaxStack(int size) {
        stack = new Stack(size);
        maxStack = new Stack(size);
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    public int pop() {
        int x = stack.pop();
        if (x == maxStack.peek()) {
            maxStack.pop();
        }
        return x;
    }

    public int getMax() {
        return maxStack.peek();
    }
}

// Problem 8: Check if String is Valid Sequence of Stack Operations
class ValidStackSequence {
    public static boolean validateSequence(int[] pushed, int[] popped) {
        Stack stack = new Stack(pushed.length);
        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}

// Problem 9: Min Stack (LeetCode #155)
class MinStack {
    private Stack stack;
    private Stack minStack;

    public MinStack(int size) {
        stack = new Stack(size);
        minStack = new Stack(size);
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public int pop() {
        int x = stack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
        return x;
    }

    public int getMin() {
        return minStack.peek();
    }
}

// Problem 10: Reverse Stack Using Recursion
class ReverseStack {
    public static void reverse(Stack stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverse(stack);
            insertAtBottom(stack, temp);
        }
    }

    private static void insertAtBottom(Stack stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            int temp = stack.pop();
            insertAtBottom(stack, x);
            stack.push(temp);
        }
    }
}
