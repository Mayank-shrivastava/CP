package DP;

public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";
        System.out.println(printLCS(s1,s2));
    }

    public static String printLCS(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while(i > 0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
               sb.append(s1.charAt(i-1));
               i = i - 1;
               j = j - 1;
            } else if(dp[i-1][j] > dp[i][j-1]) {
                i = i - 1;
            } else {
                j = j - 1;
            }
        }
       return sb.reverse().toString();
    }
}
