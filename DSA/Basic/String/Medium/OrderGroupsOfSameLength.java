package Java_Bootcamp.DSA.Basic.String.Medium;

import java.util.*;

// OrderGroupsOfSameLength.java
// Groups and prints strings of the same length after sorting
// Time: O(n^2 + n*log(n)), Space: O(n)

public class OrderGroupsOfSameLength {
    public static void main(String[] args) {
        // Test case
        System.out.println("Order Groups of Same Length: ");
        orderGroupsOfSameLength(new Scanner("3\ncat\ndog\nrat\n")); // cat rat dog
    }

    // Groups and prints strings of the same length after sorting
    // Time: O(n^2 + n*log(n)), Space: O(n)
    public static void orderGroupsOfSameLength(Scanner sc) {
        int size = sc.nextInt();
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                length = arr[i].length();
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] != null && arr[j].length() == length) {
                        System.out.print(arr[j] + " ");
                        arr[j] = null;
                    }
                }
                System.out.println();
            }
        }
    }
}