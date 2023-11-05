# 题目

**类型：**Tree

**难度：**中等

![image-20210814145116161](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210814145116161.png)







# 解题思路

1、二叉搜索树：根节点的值大于左子树所有节点的值，小于右子树所有节点的值，且左子树和右子树也同样为二叉搜索树。

2、因为左子树和右子树的生成相较于原问题是一个序列长度缩小的子问题，所以用回溯的方法来解决这道题目

3、`generateTrees(start, end)`表示当前值的集合为`start,end`，返回序列 [\textit{start},\textit{end}][*start*,*end*] 生成的所有可行的二叉搜索树。

4、枚举` [start,end]`中的值 i 为当前二叉搜索树的根，那么序列划分为了` [start,i-1]`和 `[i+1,end] `两部分。递归调用这两部分，即` generateTrees(start, i - 1) `和` generateTrees(i + 1, end)`，获得所有可行的左子树和可行的右子树，最后从可行左子树集合中选一棵，再从可行右子树集合中选一棵拼接到根节点上，并将生成的二叉搜索树放入答案数组即可。

5、递归的入口即为` generateTrees(1, n)`，出口为当`start>end `的时候，当前二叉搜索树为空，返回空节点即可。





# 代码

```java
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
```

