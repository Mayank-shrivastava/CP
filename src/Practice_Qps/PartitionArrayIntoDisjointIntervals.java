package Practice_Qps;

import java.util.*;
public class PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,6,12};
        int ans1 = partitionDisjointUsingTwoArrays(nums);
        int ans2 = partitionDisjointUsingOneArray(nums);
        int ans3 = partitionDisjoint(nums);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }
    public static int partitionDisjointUsingTwoArrays(int[] nums) {
        int[] maxLeft = new int[nums.length];
        int[] minRight = new int[nums.length];
        maxLeft[0] = nums[0];
        minRight[nums.length-1] = nums[nums.length-1];

        // fill the maxLeft array using prefix sum concept
        for(int i = 1; i < nums.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], nums[i]);
        }
        // fill the minRight array using suffix sum concept
        for(int i = nums.length - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i+1], nums[i]);
        }

        // compute the size of left partition
        for(int i = 1; i < nums.length; i++) {
            if(maxLeft[i-1] <= minRight[i]) {
                return i;
            }
        }
        // no partition possible case
        return -1;
    }
    public static int partitionDisjointUsingOneArray(int[] nums) {
        int[] minRight = new int[nums.length];
        int currMax = 0;
        minRight[nums.length-1] = nums[nums.length-1];

        // fill the minRight array using suffix sum concept
        for(int i = nums.length-2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i+1], nums[i]);
        }
        for(int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax, nums[i-1]);
            if(currMax <= minRight[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int partitionDisjoint(int[] nums) {
        int currMax = nums[0];
        int possibleMax = nums[0];
        int length = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < currMax) {
                length = i + 1;
                currMax = possibleMax;
            } else {
                possibleMax = Math.max(possibleMax, currMax);
            }
        }
        return length;
    }
}
