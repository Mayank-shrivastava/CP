package DP;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        System.out.println(robMemo(nums, nums.length-1, dp));
        System.out.println(robBU(nums));
        System.out.println(robSpaceOptimization(nums));
    }

    public static int robMemo(int[] nums, int ind, int[] dp){
       if(ind == 0) return nums[ind];
       if(ind < 0) return 0;

       if(dp[ind] != -1) return dp[ind];

       int take = nums[ind];
       if(ind > 1) {
           take += robMemo(nums, ind-2, dp);
       }
       int noTake = robMemo(nums, ind-1, dp);

       return dp[ind] = Math.max(take, noTake);
    }

    public static int robBU(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if(i > 1) {
                take += dp[i-2];
            }
            int noTake = dp[i-1];

            dp[i] = Math.max(take, noTake);
        }
        return dp[nums.length-1];
    }

    public static int robSpaceOptimization(int[] nums) {
        int prev1 = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if(i > 1) {
                take += prev2;
            }
            int noTake = prev1;
            int curri = Math.max(take, noTake);
            prev2 = prev1;
            prev1 = curri;
        }
        return prev1;
    }
}
