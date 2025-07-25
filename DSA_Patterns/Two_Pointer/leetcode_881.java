package Java_Bootcamp.DSA_Patterns.Two_Pointer;

import java.util.Arrays;

public class leetcode_881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boats = 0;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            boats++;
        }

        return boats;
    }
}
