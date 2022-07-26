package dynamicProgramming;

/**
 * 买卖股票万法归一 模板
 * 包含交易次数，手续费，冷冻期
 * 输入股票价格数组 prices，你最多进行 max_k 次交易，每次交易需要额外消耗 fee 的手续费，而且每次交易之后需要经过 cooldown 天的冷冻期才能进行下一次交易，请你计算并返回可以获得的最大利润。
 */
public class BestTimeToBuyAndSellStockTemplate {
    /**
     * 同时考虑交易次数的限制、冷冻期和手续费
     * @param max_k     最大交易次数
     * @param prices    价格
     * @param cooldown 冷却时间
     * @param fee       每次交易的费用
     * @return
     */
    int maxProfitAllInOne(int max_k, int[] prices, int cooldown, int fee) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        // 一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k 没有限制的情况
        if (max_k > n / 2) {
            // 交易次数 k 没有限制的情况
            return maxProfit_k_inf(prices, cooldown, fee);
        }

        int[][][] dp = new int[n][max_k + 1][2];
        // k = 0 时的 base case
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < n; i++)
            for (int k = max_k; k >= 1; k--) {
                // base case 1
                if (i - 1 == -1) {
                    //第一天 手上没有股票
                    dp[i][k][0] = 0;
                    //第一天 手上有股票(买入了要扣除手续费)
                    dp[i][k][1] = -prices[i] - fee;
                    continue;
                }

                // 包含 冷却时间 cooldown 的 base case
                if (i - cooldown - 1 < 0) {
                    // base case 2
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    // 别忘了减 fee
                    dp[i][k][1] = Math.max(dp[i-1][k][1], -prices[i] - fee);
                    continue;
                }
                //今天没有 = 昨天没有 or 昨天有 今天卖出去了
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                // 同时考虑 cooldown 和 fee
                //今天有 = 昨天有 or 前天没有今天买入
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-cooldown-1][k-1][0] - prices[i] - fee);
            }
        return dp[n - 1][max_k][0];
    }

    /**
     * 不限交易次数的解法
     *
     * @param prices
     * @param cooldown
     * @param fee
     * @return
     */
    int maxProfit_k_inf(int[] prices, int cooldown, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case 1
                dp[i][0] = 0;
                dp[i][1] = -prices[i] - fee;
                continue;
            }

            // 包含 cooldown 的 base case
            if (i - cooldown - 1 < 0) {
                // base case 2
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                // 别忘了减 fee
                dp[i][1] = Math.max(dp[i-1][1], -prices[i] - fee);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 同时考虑 cooldown 和 fee
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - cooldown - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }
}
