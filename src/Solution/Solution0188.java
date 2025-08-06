package Solution;

/**
 * @author Miles
 * @date 2025/8/7 0:24
 */
public class Solution0188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k*2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                int left=0;
                int leftUp=0;
                if(i!=0){
                    left=dp[i-1][j];
                    leftUp=dp[i-1][j+1];
                }
                int up=0;
                if(j!=0){
                    up=dp[i][j-1];
                }

                dp[i][j]=Math.max(left,up-prices[i]);
                dp[i][j+1]=Math.max(leftUp,dp[i][j]+prices[i]);
            }
        }
        return dp[prices.length-1][k*2-1];
    }

}
