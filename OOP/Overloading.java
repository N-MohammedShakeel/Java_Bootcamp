package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.OOP;

public class Overloading {
    public static void main(String[] args) {

        fun(1);
        fun("ms");

        int ans = sum(3, 4, 78);
        int ans1 = sum(3,  78);
        System.out.println(ans);
        System.out.println(ans1);
    }

    static int sum(int a, int b) {
        return a + b;
    }

    static int sum(int a, int b, int c) {
        return a + b + c;
    }

    static void fun(int a) {
        System.out.println("first one");
        System.out.println(a);
    }

    static void fun(String name) {
        System.out.println("Second one");
        System.out.println(name);
    }
}