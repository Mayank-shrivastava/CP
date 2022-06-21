package DP;

import java.util.Arrays;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathWithObstacles(grid));
    }

    // similar recurrence of blocked maze path
    public static int uniquePathWithObstacles(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] d : dp) Arrays.fill(d,-1);
        return solve(grid, 0,0, dp);
    }

    private static int solve(int[][] grid, int cr, int cc, int[][] dp) {
        if(cr > grid.length-1 || cc > grid[0].length-1 || grid[cr][cc] == 1) {
            return 0;
        }
        if(cr == grid.length-1 && cc == grid[0].length-1) {
            return 1;
        }
        if(dp[cr][cc] != -1) return dp[cr][cc];
        // down and right
        int down = solve(grid, cr + 1, cc, dp);
        int right = solve(grid, cr, cc+1, dp);
        return dp[cr][cc] = down + right;
    }

    public static int uniquePath2BU(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d, -1);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // base-case
                if(i > 0 && j > 0 && grid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0)
                {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if(i > 0) up = dp[i-1][j];
                if(j > 0) left = dp[i][j-1];
                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }
}
