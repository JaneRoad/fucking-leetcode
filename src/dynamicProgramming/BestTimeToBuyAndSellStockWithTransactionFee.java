package dynamicProgramming;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if (i - 2 == -1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

                continue;
            }
            //今天没有 = 昨天没有 or 昨天有 今天卖出去了-手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            //今天有 = 昨天有 or 昨天没有今天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);


        }
        return dp[length - 1][0];
    }

    public int maxProfitOptimization(int[] prices, int fee) {
        int n = prices.length;
        int sold = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = sold;
            sold = Math.max(sold, buy + prices[i]);
            buy = Math.max(buy, temp - prices[i] - fee);
        }
        return sold;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee b = new BestTimeToBuyAndSellStockWithTransactionFee();
        int[] arr = new int[]{1,3,7,5,10,3};
        System.out.println(b.maxProfit(arr,3));
    }
}
