# 题目

**类型：深度优先搜索**

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1637466417603-4bea214b-3f78-4161-9111-41ed2731f996.png)





# 解题思路

从 root 的所有子节点中的取最大深度，并在此基础上加一（统计 root 节点）即是答案。

# 代码

```java
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int ans = 0;
        for (Node node : root.children) {
            ans = Math.max(ans, maxDepth(node));
        }
        return ans + 1;
    }

}
```