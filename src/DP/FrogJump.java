package DP;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = {10,20,30,10};
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(frogJumpTD(n-1, heights,dp));
        System.out.println(frogJumpBU(n-1,heights));
        System.out.println(frogJumpSpaceOptimized(n-1,heights));
    }

    public static int frogJumpTD(int n , int[] heights,int[] dp) {
        if(n == 0) {
            return 0;
        }

        if(dp[n] != -1) return dp[n];
        int left = frogJumpTD(n-1, heights,dp) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) {
            right = frogJumpTD(n - 2, heights,dp) + Math.abs(heights[n] - heights[n - 2]);
        }
        return dp[n] = Math.min(left, right);
    }

    public static int frogJumpBU(int n, int[] heights) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            int left = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) {
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i]  = Math.min(left, right);
        }
        return dp[n];
    }

    public static int frogJumpSpaceOptimized(int n, int heights[]) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {

            int left = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int curri = Math.min(left, right);
            prev2 = prev1;
            prev1 = curri;
        }
        return prev1;
    }
}
