package Java_Bootcamp.DSA.Greedy;

import java.util.*;

public class FractionalKnapsack {

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();

        // Example input
        values.add(60); // Value of item 1
        values.add(100); // Value of item 2
        values.add(120); // Value of item 3

        weights.add(10); // Weight of item 1
        weights.add(20); // Weight of item 2
        weights.add(30); // Weight of item 3

        // capacity of the knapsack
        int capacity = 50;

        double maxValue = fractionalKnapsack(values, weights, capacity);

        // Print the result
        System.out.println("Maximum value in the knapsack: " + maxValue);
    }

    static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();
        double[] ratio = new double[n];

        for (int i = 0; i < n; i++) {
            ratio[i] = (double) val.get(i) / wt.get(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    double tempRatio = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = tempRatio;

                    int tempVal = val.get(i);
                    val.set(i, val.get(j));
                    val.set(j, tempVal);

                    int tempWt = wt.get(i);
                    wt.set(i, wt.get(j));
                    wt.set(j, tempWt);
                }
            }
        }

        double maxValue = 0.0;
        for (int i = 0; i < n; i++) {
            if (wt.get(i) <= capacity) {
                maxValue += val.get(i);
                capacity -= wt.get(i);
            } else {
                double fraction = (double) val.get(i) / wt.get(i);
                maxValue += capacity * fraction;
            }
        }

        return maxValue;
    }




    //https://leetcode.com/problems/maximum-units-on-a-truck/
    public int maximumUnits(int[][] boxTypes, int truckSize) {


        int maxUnits = 0;
        int boxes = 0;
        int n = boxTypes.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (boxTypes[j][1] > boxTypes[j + 1][1]) {
                    int[] temp = boxTypes[j];
                    boxTypes[j] = boxTypes[j + 1];
                    boxTypes[j + 1] = temp;
                }
            }
        }

        for(int i = boxTypes.length - 1 ; i >=0 ; i--){

            if((boxes + boxTypes[i][0]) <= truckSize){
                maxUnits += (boxTypes[i][0] * boxTypes[i][1]);
                boxes += boxTypes[i][0];
            }else{
                maxUnits += (truckSize - boxes) * boxTypes[i][1];
                boxes = truckSize;

            }
        }

        return maxUnits;
    }

}
