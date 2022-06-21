package DP;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibRec(n));
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibMemoBU(n, dp));
        System.out.println(fibTD(n));
        System.out.println(fibWithoutExtraSpace(10));
    }

    // TC:O(2^N) SC: O(2^N) recursion space
    private static int fibRec(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int fibnm1 = fibRec(n-1);
        int fibnm2 = fibRec(n-2);
        return fibnm1 + fibnm2;
    }

    // TC: O(N) SC: O(N)(recursion stack space) + O(N) (dp array space)
    private static int fibMemoBU(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibMemoBU(n-1, dp) + fibMemoBU(n-2,dp);
    }

    // TC: O(N) SC: O(N) (DP array space)
    private static int fibTD(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // TC: O(N) SC: O(1)
    private static int fibWithoutExtraSpace(int n) {
        int a = 0;
        int b = 1;
        int temp = 1;
        for(int i = 2; i < n; ++i) {
            a = b;
            b = temp;
            temp = a + b;
        }
        return temp;
    }
}
