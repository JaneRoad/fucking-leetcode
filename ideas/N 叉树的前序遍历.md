# 题目

**类型：树**



![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1647074505746-7dc6d793-9410-4105-867f-d617c1d33afa.png)

# 解题思路



# 代码

```java
List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        dfs(root);
        return ans;
    }
    void dfs(Node root) {
        if (root == null) return ;
        ans.add(root.val);
        for (Node node : root.children) dfs(node);
    }
```