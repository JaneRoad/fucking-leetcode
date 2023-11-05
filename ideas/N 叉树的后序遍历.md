# 题目

**类型：树**

![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1647068108118-ed95da2b-ff10-4d19-8365-cea79fab3882.png)



# 解题思路

深度优先

# 代码

```java
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        dfs(root);
        return ans;
    }
    void dfs(Node root) {
        if (root == null) return;
        for (Node node : root.children) dfs(node);
        ans.add(root.val);
    }
}
```