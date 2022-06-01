package striver_sheet;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int ans = maxProfit(prices);
        System.out.println(ans);
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        int cp = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < cp) {
                cp = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - cp);
            }
        }
        return ans;
    }
}
