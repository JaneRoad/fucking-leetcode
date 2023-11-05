# 题目

**类型：动态规划**

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1658850764451-f9566cce-bea3-4d6f-9173-c35b125741d2.png)



# 解题思路



[一个方法团灭 LEETCODE 股票买卖问题](https://labuladong.github.io/algo/1/13/)



此处为语雀内容卡片，点击链接查看：https://www.yuque.com/lujiannan/leetcode/fl3cr1



# 代码

```java
class Solution {
    public int maxProfit(int[] prices) {
        //最多交易2次
        int num = 2, length = prices.length;
        int[][][] dp = new int[length][num + 1][2];
        //遍历天数
        for (int i = 0; i < length; i++) {
            //遍历交易次数
            for (int k = num; k >= 1; k--) {
                // 处理 base case
                if (i - 1 == -1) {
                    //第一天 手上没有股票
                    dp[i][k][0] = 0;
                    //第一天 手上有股票
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                //今天手上没股票 = 昨天没股票       or     昨天有股票今天卖出
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                //今天手上有股票 = 昨天有股票       or     昨天没股票今天买入(交易次数k-1)
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        // 穷举了 length × num × 2 个状态，正确。
        return dp[length - 1][2][0];
    }
}
```