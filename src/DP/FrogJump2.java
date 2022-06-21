package DP;

import java.util.Arrays;
import java.util.Scanner;

public class FrogJump2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++) heights[i] = scn.nextInt();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(frog2(n-1, heights, dp,k));
    }

    public static int frog2(int n, int[] heights, int[] dp, int k) {
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int ans = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++) {
            if(n-j >= 0) {
                int jump = frog2(n-j, heights, dp, k) + Math.abs(heights[n]- heights[n-j]);
                ans = Math.min(ans, jump);
            }
        }
        return dp[n] = ans;
    }
}
