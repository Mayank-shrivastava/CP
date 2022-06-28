package DP;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] val = {60,100,120};
        int[] wt = {10,20,30};
        int W = 50;
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        for(int[] d: dp) Arrays.fill(d,-1);
        System.out.println(knapsack01Memo(val, wt, W,n,dp));
        System.out.println(knapsack01Tab(val,wt,W,n));
    }

    public static int knapsack01Memo(int[] val, int[] wt, int W, int n, int[][] dp) {
        if(n == 0 || W == 0) {
            return 0;
        }
        if(dp[n][W] != -1) return dp[n][W];
        int take = Integer.MIN_VALUE;
        if(wt[n-1] <= W) {
            take = val[n-1] + knapsack01Memo(val, wt, W-wt[n-1], n-1, dp);
        }
        int noTake = knapsack01Memo(val, wt, W, n-1, dp);

        return dp[n][W] = Math.max(take, noTake);
    }

    public static int knapsack01Tab(int[] val, int[] wt, int W, int n) {
        int[][] dp = new int[n+1][W+1];

        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < W+1; j++) {
              if(i == 0 || j == 0) {
                  dp[i][j] = 0;
              } else if(wt[i-1] <= j) {
                  dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
              } else {
                  dp[i][j] = dp[i-1][j];
              }
            }
        }

        return dp[n][W];

    }
}
