package DP_Tabulation;

import javax.swing.ImageIcon;

public class ClimbingStaisWithJumps {
    public static void main(String[] args) {
        int[] jumps = {2,3,1,1,4};
        System.out.println(climbingStairsWithJumps(jumps));
    }

    // count the total number of steps required to move from starting position to the ending position
    public static int climbingStairsWithJumps(int[] jumps) {
        int n = jumps.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i = n-1; i >= 0; i--) {
            for(int j = 1; j <= jumps[i] && i+j <= n; j++) {
                dp[i] = dp[i] + dp[i+j];
            }
        }
        return dp[0];
    }
}
