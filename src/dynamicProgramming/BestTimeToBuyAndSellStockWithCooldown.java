package dynamicProgramming;

/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if (i - 2 == -1) {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

                continue;
            }
            //今天没有 = 昨天没有 or 昨天有 今天卖出去了
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            //今天有 = 昨天有 or 前天没有今天买入
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i]);


        }
        return dp[length - 1][0];
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown b = new BestTimeToBuyAndSellStockWithCooldown();
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(b.maxProfit(arr));
    }


}
