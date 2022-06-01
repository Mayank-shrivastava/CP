package striver_sheet;
import java.util.*;
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,5,8,4,7,6,5,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        // find the first decreasing number index from right
        int i = nums.length-2;
        while(i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }
        // here i gives the index of the first decreasing number
        if(i >= 0) {
            // now find the first number which is greater than nums[i]
            int j = nums.length-1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            // nums[j] is the number which is greater than nums[i]
            // swap nums[i] and nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // reverse from i+1 to nums.length-1;
        reverse(nums, i+1, nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
