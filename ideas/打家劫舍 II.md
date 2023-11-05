# 题目

**类型：动态规划**



![img](https://cdn.nlark.com/yuque/0/2023/png/2941598/1672654743001-49862bb0-c5e3-40b9-9687-d81c1cd4c6fd.png)

# 解题思路

此处为语雀内容卡片，点击链接查看：https://www.yuque.com/janeroad/leetcode/koykmv4w9hm6xw0k

# 代码

```java
class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        // 两次调用使用两个不同的备忘录
        return Math.max(
                dp(nums, 0, n - 2, memo1),
                dp(nums, 1, n - 1, memo2)
        );
    }

    // 定义：计算闭区间 [start,end] 的最优结果
    int dp(int[] nums, int start, int end, int[] memo) {
        if (start > end) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }
        // 状态转移方程
        int res = Math.max(
                dp(nums, start + 2, end, memo) + nums[start],
                dp(nums, start + 1, end, memo)
        );

        memo[start] = res;
        return res;
    }
} 
```