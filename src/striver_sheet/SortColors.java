package striver_sheet;

import java.sql.Array;
import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    // DUTCH NATIONAL FLAG ALGORITHMS
    public static void sortColors(int[] nums) {
        int lo = 0;
        int mid = 0;
        int hi = nums.length-1;
        while(mid <= hi) {
            if (nums[mid] == 0) {
                // swap nums[mid] and nums[lo]
                int temp = nums[mid];
                nums[mid] = nums[lo];
                nums[lo] = temp;
                lo++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                // swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[hi];
                nums[hi] = temp;
                hi--;
            }
        }
    }
}
