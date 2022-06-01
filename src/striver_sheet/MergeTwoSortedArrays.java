package striver_sheet;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,4,7,8,10};
        int[] nums2 = {2,3,5};
        int[] ans = mergeUsingExtraSpace(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] mergeUsingExtraSpace(int[] nums1, int[] nums2) {
        int i = 0; // pointer on nums1
        int j = 0; // pointer on nums2
        int[] temp = new int[nums1.length + nums2.length];
        int k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                temp[k] = nums1[i];
                i++;
                k++;
            } else if(nums1[i] > nums2[j]) {
                temp[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i < nums1.length) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        while(j < nums2.length) {
            temp[k] = nums2[j];
            j++;
            k++;
        }
        return temp;
    }

    // check it later if found
    public static void mergeWithoutUsingExtraSpace(int[] nums1, int[] nums2) {

    }
}
