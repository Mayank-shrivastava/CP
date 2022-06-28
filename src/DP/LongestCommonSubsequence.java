package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] d :dp) Arrays.fill(d,-1);
        System.out.println(longestCommonSubsequence(s1, s2, s1.length(), s2.length(),dp));
        System.out.println(lcsTab(s1,s2));
    }

    public static int longestCommonSubsequence(String s1, String s2, int n1, int n2, int[][] dp) {
        if(n1 == 0 || n2 == 0) return 0;

        if(dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        int ans = 0;
        if(s1.charAt(n1-1) == s2.charAt(n2-1)) {
            ans = 1 + longestCommonSubsequence(s1, s2, n1-1, n2-1, dp);
        } else {
            ans = Math.max(longestCommonSubsequence(s1,s2,n1-1,n2,dp), longestCommonSubsequence(s1,s2,n1,n2-1,dp));
        }

        return dp[n1][n2] = ans;
    }

    public static int lcsTab(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
