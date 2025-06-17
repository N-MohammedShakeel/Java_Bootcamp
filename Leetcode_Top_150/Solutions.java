package Java_Bootcamp.Leetcode_Top_150;

import java.util.Scanner;

public class Solutions {
    public static void main(String[] args) {
        int[] arr1 = {3,2,2,3};

        removeElement(arr1, 3);
    }

    static void getArray(int[] arr){
        Scanner sc = new Scanner(System.in);
        for(int i=0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
    }


//    https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1662071478/?envType=study-plan-v2&envId=top-interview-150
public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;

    int i = 0;

    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }

    return i + 1;
}



//    https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
    public static int removeElement(int[] nums, int val) {

        int k = nums.length - 1;
        int i = 0;

        while (i <= k) {
            if (nums[i] == val) {
                nums[i] = nums[k];
                k--;
            } else {
                i++;
            }
        }

        return k + 1;
    }

//    https://leetcode.com/problems/merge-sorted-array?envType=study-plan-v2&envId=top-interview-150
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

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


