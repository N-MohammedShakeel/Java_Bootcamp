package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.Methods;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun(1,2,3);
        multiple(2, 3, "ms", "Rahul", "dvytsbhusc");
        demo(3,4,5);
        demo("ms","ms1");
    }

    static void demo(int ...v) {
        System.out.println(Arrays.toString(v));
    }

    static void demo(java.lang.String ...v) {
        System.out.println(Arrays.toString(v));
    }

    static void multiple(int a, int b,java.lang.String ...v) {

    }

    static void fun(int ...v) {
        System.out.println(Arrays.toString(v));
    }
}