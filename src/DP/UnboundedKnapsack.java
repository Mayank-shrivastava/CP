package DP;

public class UnboundedKnapsack {
    public static void main(String[] args) {

    }

    // Unbounded Knapsack: Infinite supply of particular weight/value is required
    // in case of pick stand at the same index because u have the infinite supply of the items
    public static int unboundedKnapsackMemo(int[] val, int[] wt, int n, int W, int[][] dp) {
        if(n == 0 || W == 0) {
            return 0;
        }

        if(dp[n][W] != -1) return dp[n][W];

        int take = Integer.MIN_VALUE;
        if(wt[n-1] <= W) {
            take = val[n-1] + unboundedKnapsackMemo(val, wt, n, W-wt[n-1], dp);
        }
        int notake = unboundedKnapsackMemo(val, wt, n-1, W, dp);

        return dp[n][W] = Math.max(take, notake);
    }

    public static int unKnapsackTab(int[] val, int[] wt, int n, int w) {
        int[][] dp = new int[n+1][w+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= w; j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
