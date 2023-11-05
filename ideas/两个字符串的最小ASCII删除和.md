# 题目

**类型：动态规划**



![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1653319929136-e62d8800-7cdf-4a6f-8e3c-78d8e32598a0.png)

# 解题思路

不能直接复用计算最长公共子序列的函数了，但是可以依照之前的思路



base case 有一定区别，计算lcs长度时，如果一个字符串为空，那么lcs长度必然是 0；

但是这道题如果一个字符串为空，另一个字符串必然要被全部删除，所以需要计算另一个字符串所有字符的 ASCII 码之和。

关于状态转移，当s1[i]和s2[j]相同时不需要删除，不同时需要删除，所以可以利用dp函数计算两种情况，得出最优的结果。其他的大同小异







# 代码

```java
class Solution {
     int memo[][];
     
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dp(s1, 0, s2, 0);
    }

    
    int dp(String s1, int i, String s2, int j) {
        int res = 0;
        // base case
        if (i == s1.length()) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;
        }
        if (j == s2.length()) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = Math.min(
                    s1.charAt(i) + dp(s1, i + 1, s2, j),
                    s2.charAt(j) + dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
}
```