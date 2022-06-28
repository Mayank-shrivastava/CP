package DP;

import java.util.Arrays;

// https://leetcode.com/discuss/general-discussion/665604/Important-and-Useful-links-from-all-over-the-Leetcode

public class NumberOfLIS {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(count,1);
        int maxi = 1;
        Arrays.fill(dp,1);
        for(int i = 0; i < nums.length; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(nums[i] > nums[prev] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    count[i] = count[prev];
                } else if(nums[i] > nums[prev] && 1 + dp[prev] == dp[i]) {
                    count[i] += count[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        int nos = 0;
        for(int i = 0; i < nums.length; i++) {
            if(dp[i] == maxi) nos += count[i];
        }

        return nos;
    }
}
