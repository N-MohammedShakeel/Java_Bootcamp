package Java_Bootcamp.Leetcode.Array;

public class leetcode_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] dummy = new int[m+n];

        int i = 0 , j = 0 , k = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                dummy[k++] = nums1[i++];
            }else{
                dummy[k++] = nums2[j++];
            }
        }

        while(i < m){
            dummy[k++] = nums1[i++];
        }

        while(j < n){
            dummy[k++] = nums2[j++];
        }

        for (int x = 0; x < m + n; x++) {
            nums1[x] = dummy[x];
        }
    }
}
