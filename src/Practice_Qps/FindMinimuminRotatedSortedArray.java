package Practice_Qps;

import java.util.*;
public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int ans = findMin(nums);
        System.out.println(ans);
    }

    public static int findMin(int[] nums) {
        int pivot = pivot(nums); // get the index at which the array is rotated
        if(pivot == -1) {
            // array is not rotated but it is sorted in increasing order so min in nums[0]
            return nums[0];
        }

        int leftMin = nums[0];
        int rightMin = nums[pivot+1];
        return Math.min(leftMin, rightMin);
    }
    public static int pivot(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(mid < hi && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if(mid > lo && nums[mid] < nums[mid-1]) {
                return mid;
            }

            if(nums[mid] <= nums[lo]) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }
}

