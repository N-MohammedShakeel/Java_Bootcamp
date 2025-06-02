package Java_Bootcamp.DSA.IntermediateToAdvance.GreedyAlgorithm.Medium;

public class MinimumPlatforms {

    // Problem Statement: We are given two arrays that represent the arrival and departure times of trains that stop at the platform.
    // We need to find the minimum number of platforms needed at the railway station so that no train has to wait.

    public static void main(String[] args) {

        int n = 4;

        double[] arr = {10.00, 9.00, 9.40, 9.50};
        double[] dep = {10.30, 9.10, 10.00, 10.20};

        java.util.Arrays.sort(arr);
        java.util.Arrays.sort(dep);

        int i = 1; // pointer for next arrival
        int j = 0; // pointer for current departure
        int platform_needed = 1;
        int max_platforms = 1;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platform_needed++;
                i++;
            } else {
                platform_needed--;
                j++;
            }

            max_platforms = Math.max(max_platforms, platform_needed);
        }

        System.out.println(max_platforms);
    }

}
