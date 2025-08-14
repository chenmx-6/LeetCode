package Solution;

/**
 * @Classname Solution0123
 * @Date 2025-8-4 17:39
 * @Created by ChenMX
 */
public class Solution0123 {
    //3 3 5 0 0 3 1 4
    //0 2 -5 0 3 -2 3
    //0 2 -3 -3 0 -2 1
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0]=new int[]{-prices[0],0,-prices[0],0};
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
            dp[i][2]=Math.max(dp[i-1][2],-prices[i]+dp[i-1][1]);
            dp[i][3]=Math.max(dp[i-1][3],prices[i]+dp[i-1][2]);
        }
        return dp[prices.length-1][3];
    }
}
