package DP;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(climbStairs(n,dp));
    }

    private static int climbStairs(int n, int[] dp) {
        if(n == 0) {
            return 1;
        }

        if(n < 1) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp);
    }
}
