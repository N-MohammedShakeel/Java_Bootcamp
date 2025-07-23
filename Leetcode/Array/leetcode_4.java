package Java_Bootcamp.Leetcode.Array;

public class leetcode_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length + nums2.length;
        int[] arr = new int[n];
        int index = 0;
        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                arr[index++] = nums1[i++];
            }else{
                arr[index++] = nums2[j++];
            }
        }

        while(i < nums1.length){
            arr[index++] = nums1[i++];
        }

        while(j < nums2.length){
            arr[index++] = nums2[j++];
        }


        return (n % 2 == 1) ? arr[n/2] : ((arr[n/2]) + (arr[n/2 - 1]))/2.0;
    }
}
