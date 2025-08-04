package Solution;

/**
 * @Classname Solution0309
 * @Date 2025-8-1 11:10
 * @Created by ChenMX
 */
public class Solution0714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1) {
            return 0;
        }

        int[][] r = new int[prices.length][2];
        r[0][0] = 0;
        r[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int left1 = r[i - 1][0];
            int left2 = r[i - 1][1];
            r[i][0] = Math.max(left1, left2 + prices[i] - fee);
            r[i][1] = Math.max(left2, left1-prices[i]);
        }
        return r[r.length - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        Solution0714 solution0309 = new Solution0714();
        int i = solution0309.maxProfit(prices, 2);
        System.out.println(i);
    }
}
