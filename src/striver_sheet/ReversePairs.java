package striver_sheet;

import java.util.Arrays;

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private static int mergeSort(int[] nums , int lo , int hi) {
        int reversePairCnt = 0;
        if(lo < hi) {
            int mid = (lo + hi) / 2;
            reversePairCnt += mergeSort(nums, lo, mid);
            reversePairCnt += mergeSort(nums, mid+1, hi);
            reversePairCnt += merge(nums, lo, mid, hi);
        }
        return reversePairCnt;
    }

    private static int merge(int[] nums, int lo, int mid, int hi) {
        int[] left = Arrays.copyOfRange(nums,lo, mid+1);
        int[] right = Arrays.copyOfRange(nums, mid, hi+1);
        int reversePairCnt = 0;
        int k = lo;
        int i = 0;
        int j = 0;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                nums[k] = left[i];
                k++;
                i++;
            }
            if(left[i] > right[j]) {
                nums[k] = right[j];
                if(left[i] > (2 * right[j])) {
                    reversePairCnt += (mid+1) - (lo + i);
                }
                k++;
                j++;
            }
        }

        while(i < left.length) {
            nums[k] = left[i];
            k++;
            i++;
        }

        while(j < right.length) {
            nums[k] = right[j];
            k++;
            j++;
        }
        return reversePairCnt;
    }
}
