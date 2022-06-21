package DP;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1,-1);
        int ans1 = rob2Memo(nums, 0,nums.length-2,dp1);
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2,-1);
        int ans2 = rob2Memo(nums,1, nums.length-1, dp2);
        System.out.println(Math.max(ans1, ans2));

        System.out.println(rob2BU(nums));

    }

    public static int rob2Memo(int[] nums, int start, int end, int[] dp) {
        if(start > end) {
            return 0;
        }

        if(dp[start] != -1) {
            return dp[start];
        }

        int take = nums[start] + rob2Memo(nums, start+2 , end, dp);
        int noTake = rob2Memo(nums, start+1, end, dp);
        return dp[start] = Math.max(take, noTake);
    }

    public static int rob2BU(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length]; // 0 to n-2 wali dp
        dp1[0] = nums[0];
        for(int i = 1; i < nums.length-1; i++) {
            int take = nums[i];
            if(i > 1) take += dp1[i-2];
            int noTake = dp1[i-1];
            dp1[i] = Math.max(take, noTake);
        }
        System.out.println(Arrays.toString(dp1));
        int[] dp2 = new int[nums.length]; // 1 to n-1 wali dp
        dp2[1] = nums[1];
        for(int i = 2; i < nums.length; i++) {
            int take = nums[i] + dp2[i-2];
            int noTake = dp2[i-1];
            dp2[i] = Math.max(take, noTake);
        }
        System.out.println(Arrays.toString(dp2));
        return Math.max(dp1[nums.length-2], dp2[nums.length-1]);
    }
}
