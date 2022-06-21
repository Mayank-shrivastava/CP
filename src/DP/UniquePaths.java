package DP;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d,-1);
        return solve(m-1,n-1,dp);
    }

    private static int solve(int m, int n,int[][] dp) {
       if(m == 0 && n == 0) {
           return 1;
       }

       if(m < 0 || n < 0) {
           return 0;
       }
       if(dp[m][n] != -1) return dp[m][n];
       int down = solve(m-1,n,dp);
       int right = solve(m,n-1,dp);
       return dp[m][n] = down + right;
    }


    public static int uniquePathsBU(int m, int n) {
        int[][] dp = new int[m][n];
        // initialize the dp matrix
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else if(i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
