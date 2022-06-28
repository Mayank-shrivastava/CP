package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int[][] dp = new int[arr.length][arr.length+1];
        for(int[] d : dp) Arrays.fill(d,-1);
        System.out.println(LISMemo(arr, 0, -1, dp));
        //System.out.println(Arrays.toString(dp));
        System.out.println(LISTab(arr));
        System.out.println(LISTabON(arr));
        printLIS(arr);
    }

    public static int LISMemo(int[] arr, int ind, int prevInd, int[][] dp) {
        if(ind == arr.length) return 0;
        // cordinate shift prevInd+1
        if(dp[ind][prevInd+1] != -1) return dp[ind][prevInd+1];
        int len = LISMemo(arr, ind+1, prevInd, dp); // noTake case
        if(prevInd == -1 || arr[ind] > arr[prevInd]) {
            len = Math.max(len , 1 + LISMemo(arr, ind+1, ind, dp)); // take case
        }

        return dp[ind][prevInd+1] = len;
    }

    public static int LISTab(int[] arr) {
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int ind = arr.length-1; ind >= 0; ind--) {
            for(int prevInd = ind-1; prevInd >= -1; prevInd--) {
                int len = dp[ind+1][prevInd+1];
                if(prevInd == -1 || arr[ind] > arr[prevInd]) {
                    len = Math.max(len, 1 + dp[ind+1][ind+1]);
                }

                dp[ind][prevInd+1] = len;
            }
        }
        return dp[0][0];
    }


    // LIS O(N) space optimization
    public static int LISTabON(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        int maxi = 1;
        for(int ind = 0; ind < arr.length; ind++) {
            for(int prev = 0; prev < ind; prev++) {
                if(arr[ind] > arr[prev]) {
                    dp[ind] = Math.max(dp[ind], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[ind]);
        }
        return maxi;
    }

    // how to print the LIS for that purpose we require LISTabON sol where space complexity boils down to O(N)
    public static void printLIS(int[] arr) {
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];
        Arrays.fill(dp,1);
        int maxi = 1;
        int lastInd = 0;
        for(int ind = 0; ind < arr.length; ind++) {
            hash[ind] = ind;
            for(int prev = 0; prev < ind; prev++) {
                if(arr[ind] > arr[prev] && 1 + dp[prev] > dp[ind]) {
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                }
                if(dp[ind] > maxi) {
                    maxi = dp[ind];
                    lastInd = ind;
                }
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[lastInd]);
        while(hash[lastInd] != lastInd) {
            lastInd = hash[lastInd];
            temp.add(arr[lastInd]);
        }

        Collections.reverse(temp);
        for(int val : temp) System.out.print(val + " ");
    }
}
