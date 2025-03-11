package java_BASIC_OOPS_DSA_PROJECTS_PROBLEMS.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        // initialisation
        for (int i = 0; i < 5; i++) {
            list.add(new ArrayList<Integer>());
        }

        // add elements
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                list.get(i).add(in.nextInt());
            }
        }

        System.out.println(list);

        // eg o/p for own input
        // [[1, 2, 3], [4, 5, 6], [7, 8, 9], [11, 22, 33], [44, 55, 66]]
    }
}