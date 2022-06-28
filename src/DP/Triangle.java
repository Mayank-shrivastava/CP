package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(triangle, 0, 0,dp);
    }

    public static int solve(List<List<Integer>> triangle, int cr, int cc, int[][] dp) {
        if(cr == triangle.size() - 1) return triangle.get(cr).get(cc);
        if(dp[cr][cc] != -1) return dp[cr][cc];
        int fm = triangle.get(cr).get(cc) + solve(triangle, cr+1, cc, dp);
        int sm = triangle.get(cr).get(cc) + solve(triangle, cr+1, cc+1,dp);
        return dp[cr][cc] = Math.min(fm, sm);
    }
}
