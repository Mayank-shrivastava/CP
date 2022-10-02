package DP_Tabulation;
import java.util.*;
public class JumpGame2 {
    public static void main(String[] args) {
        
    }

    public static int jumps(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE); // since we need to find the min moves to reach the end
        dp[n-1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= nums[i] && i + j < n; j++) {
                if(dp[i+j] != Integer.MAX_VALUE) {
                    min = Math.min(min , dp[i+j]);
                }
            }
            
            if(min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[0];  
    }
}
