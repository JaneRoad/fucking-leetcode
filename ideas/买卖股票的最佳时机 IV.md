# 题目

**类型：动态规划**



![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1658850817339-4ad1a496-0207-4237-a42f-c109bd598f48.png)

# 解题思路

[一个方法团灭 LEETCODE 股票买卖问题](https://labuladong.github.io/algo/1/13/)



此处为语雀内容卡片，点击链接查看：https://www.yuque.com/lujiannan/leetcode/fl3cr1



# 代码

```java
class Solution {
        public int maxProfit(int max_k, int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        // 一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k 没有限制的情况
        if (max_k > n / 2) {
            // 交易次数 k 没有限制的情况
            return maxProfitWithoutTime(prices);
        }

        // base case：
        // dp[-1][...][0] = dp[...][0][0] = 0
        // dp[-1][...][1] = dp[...][0][1] = -infinity
        int[][][] dp = new int[n][max_k + 1][2];
        // k = 0 时的 base case
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < n; i++)
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // 处理 i = -1 时的 base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                //今天手上没股票 = 昨天没股票       or     昨天有股票今天卖出
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                //今天手上有股票 = 昨天有股票       or     昨天没股票今天买入(交易次数k-1)
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        return dp[n - 1][max_k][0];
    }

    /**
     * 不限次数的解法
     *
     * @param prices
     * @return
     */
    private int maxProfitWithoutTime(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            // base case
            if (i - 1 == -1) {
                //第一天不买
                dp[i][0] = 0;
                //第一天买
                dp[i][1] = -prices[i];
                continue;
            }
            //今天手上没股票 = 昨天没股票       or     昨天有股票今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天手上有股票 = 昨天有股票       or     昨天没股票今天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
```