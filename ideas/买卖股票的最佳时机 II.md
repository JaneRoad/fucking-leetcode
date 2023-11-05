# 题目

**类型：动态规划**



![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1658850744177-9ec0a7aa-bc17-4e75-85c1-713af4ecc5a2.png)

# 解题思路



[一个方法团灭 LEETCODE 股票买卖问题](https://labuladong.github.io/algo/1/13/)



此处为语雀内容卡片，点击链接查看：https://www.yuque.com/lujiannan/leetcode/fl3cr1



# 代码

```java
class Solution {
    public int maxProfit(int[] prices) {
       int length = prices.length, hold = Integer.MIN_VALUE, empty = 0, profit = 0;
        for (int i = 0; i < length; i++) {
            if (i - 1 <= -1) {
                hold = -prices[i];
                empty = 0;
                continue;
            }
            //持有 = 昨天持有 or 今天持有
            hold = Math.max(hold, -prices[i]);
            //没有 = 昨天没有 or 昨天有今天卖出
            empty = Math.max(empty, hold + prices[i]);
            //今天卖出结算利润
            if (empty == hold + prices[i]) {
                profit += empty;
            }
            //清空
            hold = -prices[i];
            empty = 0;
        }
        return profit;
    }
}
```