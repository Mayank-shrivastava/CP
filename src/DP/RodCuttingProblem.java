package DP;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] prices = {2,5,7,8,10};
        int n = 5;
        int[][] dp = new int[n+1][n+1];
        for(int[] d: dp) {
            Arrays.fill(d,-1);
        }
        System.out.println(rodCut(prices, n, n, dp));
        System.out.println(rodCutTab(prices,n));
    }

    public static int rodCut(int[] prices, int n, int ind, int[][] dp) {
        if(ind == 0) {
            return n * prices[0];
        }
        if(dp[ind][n] != -1) return dp[ind][n];
        // two choices to make
        // cut or notCut
        int notCut = rodCut(prices, n, ind-1, dp);
        int cut = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if(rodLength <= n) {
            cut = prices[ind] + rodCut(prices, n-rodLength, ind, dp);
        }
        return dp[ind][n] = Math.max(cut, notCut);
    }

    public static int rodCutTab(int[] prices, int n) {
        int[][] dp = new int[n+1][n+1];
        // initialize the dp matrix
        for(int j = 0; j <= n; j++) {
            dp[0][j] = j*prices[0];
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                int noCut = dp[i-1][j];
                int cut = Integer.MIN_VALUE;
                int rodLength = i + 1;
                if(rodLength <= j) {
                    cut = prices[i] + dp[i][j-rodLength];
                }
                dp[i][j] = Math.max(noCut, cut);
            }
        }
        return dp[n][n];
    }
}
