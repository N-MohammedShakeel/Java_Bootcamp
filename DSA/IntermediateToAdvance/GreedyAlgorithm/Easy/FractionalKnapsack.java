package Java_Bootcamp.DSA.IntermediateToAdvance.GreedyAlgorithm.Easy;

public class FractionalKnapsack {

    // Problem Statement: The weight of N items and their corresponding values are given.
    // We have to put these items in a knapsack of weight W such that the total value obtained is maximized.
    public static void main(String[] args) {

        int n = 3;
        int capacity = 50;
        int[] value = {100,60,120};
        int[] weight = {20,10,30};

        double[] ratio = new double[value.length];

        for(int i=0 ; i < value.length ; i++){
            ratio[i] = (double) value[i] / weight[i];
        }

        for (int i = 0; i < ratio.length - 1; i++) {
            for (int j = 0; j < ratio.length - 1 - i; j++) {
                if (ratio[j] < ratio[j + 1]) {

                    double tempRatio = ratio[j];
                    ratio[j] = ratio[j + 1];
                    ratio[j + 1] = tempRatio;

                    int tempVal = value[j];
                    value[j] = value[j + 1];
                    value[j + 1] = tempVal;

                    int tempWt = weight[j];
                    weight[j] = weight[j + 1];
                    weight[j + 1] = tempWt;
                }
            }
        }


        double ans = 0;

        for(int i=0 ; i < value.length ; i++){
            if(capacity >= weight[i]){
                capacity -= weight[i];
                ans += value[i];
            }else if(capacity > 0){
                ans += ((double) value[i] / weight[i]) * capacity;
                capacity = 0;
            }else {
                break;
            }
        }
        System.out.println(ans);
    }

//    public static void main(String[] args) {
//        List<Integer> values = new ArrayList<>();
//        List<Integer> weights = new ArrayList<>();
//
//        // Example input
//        values.add(60); // Value of item 1
//        values.add(100); // Value of item 2
//        values.add(120); // Value of item 3
//
//        weights.add(10); // Weight of item 1
//        weights.add(20); // Weight of item 2
//        weights.add(30); // Weight of item 3
//
//        // capacity of the knapsack
//        int capacity = 50;
//
//        double maxValue = fractionalKnapsack(values, weights, capacity);
//
//        // Print the result
//        System.out.println("Maximum value in the knapsack: " + maxValue);
//    }

//    static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
//        int n = val.size();
//        double[] ratio = new double[n];
//
//        for (int i = 0; i < n; i++) {
//            ratio[i] = (double) val.get(i) / wt.get(i);
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if (ratio[i] < ratio[j]) {
//                    double tempRatio = ratio[i];
//                    ratio[i] = ratio[j];
//                    ratio[j] = tempRatio;
//
//                    int tempVal = val.get(i);
//                    val.set(i, val.get(j));
//                    val.set(j, tempVal);
//
//                    int tempWt = wt.get(i);
//                    wt.set(i, wt.get(j));
//                    wt.set(j, tempWt);
//                }
//            }
//        }
//
//        double maxValue = 0.0;
//        for (int i = 0; i < n; i++) {
//            if (wt.get(i) <= capacity) {
//                maxValue += val.get(i);
//                capacity -= wt.get(i);
//            } else {
//                double fraction = (double) val.get(i) / wt.get(i);
//                maxValue += capacity * fraction;
//            }
//        }
//
//        return maxValue;
//    }


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
