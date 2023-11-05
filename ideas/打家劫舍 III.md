# 题目

**类型：动态规划**



![img](https://cdn.nlark.com/yuque/0/2023/png/2941598/1672654787733-2e696af3-86b7-47fc-86a1-d000d3f31ae9.png)

# 解题思路

此处为语雀内容卡片，点击链接查看：https://www.yuque.com/janeroad/leetcode/koykmv4w9hm6xw0k

# 代码

```java
class Solution {
   
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 返回一个大小为 2 的数组 arr
     * arr[0] 表示不抢 root 的话，得到的最大钱数
     * arr[1] 表示抢 root 的话，得到的最大钱数
     *
     * @param root
     * @return
     */
    int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int doRob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int doNotRob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        return new int[]{doNotRob, doRob};
    }
} 
```