package Java_Bootcamp.DSA.Basic.Queue.Problems;

import java.util.LinkedList;
import java.util.Queue;

// Problem 7: First Circular Tour (Petrol Pump Problem)
// Statement: Find the starting point for a circular tour where a truck can complete a circle with given petrol pumps.
// Sample Test Cases:
// Input: petrol=[4,6,7,4], distance=[6,5,3,5] -> Output: 1
// Input: petrol=[1,2], distance=[2,1] -> Output: -1
// TC: O(n), SC: O(n)
class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int p, int d) {
            petrol = p;
            distance = d;
        }
    }

    public static int findTour(PetrolPump[] arr, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int start = 0, currPetrol = 0;
        for (int i = 0; i < n; i++) {
            currPetrol += arr[i].petrol - arr[i].distance;
            queue.offer(i);
            while (currPetrol < 0 && !queue.isEmpty()) {
                int index = queue.poll();
                currPetrol -= arr[index].petrol - arr[index].distance;
                start = queue.isEmpty() ? i + 1 : queue.peek();
            }
        }
        return currPetrol >= 0 ? start : -1;
    }
}
