package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.Methods;

import java.util.Arrays;

public class method1{
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 45, 6};
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void change(int[] nums) {
        nums[0] = 99;
    }
}
