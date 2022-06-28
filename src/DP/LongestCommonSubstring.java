package DP;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "abcjklp";
        String str2 = "acjkp";
        System.out.println(LCSubstring(str1,str2));
    }

    public static int LCSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        int ans = 0;
        // initialization of dp matrix
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans , dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
