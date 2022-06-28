package DP;

import java.rmi.server.RMIClientSocketFactory;
import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {10,15,20,25};
        int[][] dp = new int[arr.length][arr.length];
        for(int[] d : dp) Arrays.fill(d,-1);
        System.out.println(mcm(arr,1,arr.length-1, dp));
    }

    public static int mcm(int[] arr, int start , int end, int[][] dp) {
        if(start == end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int ans = Integer.MAX_VALUE;
        for(int k = start; k < end; k++) {
            int steps = (arr[start-1]*arr[k]*arr[end]) + mcm(arr,start,k,dp) + mcm(arr, k+1, end,dp);
            ans = Math.min(ans, steps);
        }
        return dp[start][end] = ans;
    }
}


// think of the basic template
// int ans = 0;
// for k = i to j-1:
//     int calculation = (--change wrt problem--) + f(start,k) + f(k+1,end); recursion steps
//     ans = get the max/ min according to problem
//return ans