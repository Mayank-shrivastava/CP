package DP;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "cbbd";
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int[] d : dp) Arrays.fill(d,-1);
        System.out.println(lps(s,0,s.length()-1,dp));
    }

    public static int lps(String s, int start, int end, int[][] dp) {
        if(start == end) {
            return 1;
        }
        if(start > end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int ans = Integer.MIN_VALUE;
        if(s.charAt(start) == s.charAt(end)) {
            ans = 2 + lps(s,start+1, end - 1,dp);
        } else {
            ans = Math.max(lps(s,start+1,end,dp), lps(s,start,end-1,dp));
        }
        return dp[start][end] = ans;
    }
}
