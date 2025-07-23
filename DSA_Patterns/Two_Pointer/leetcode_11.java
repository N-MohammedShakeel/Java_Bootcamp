package Java_Bootcamp.DSA_Patterns.Two_Pointer;

public class leetcode_11 {
    public int maxArea(int[] arr) {
        int start = 0, end = arr.length - 1;
        int maxArea = 0;

        while (start < end) {
            int width = end - start;
            int height = Math.min(arr[start], arr[end]);

            maxArea = Math.max(maxArea, width * height);
            if (arr[start] < arr[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}
