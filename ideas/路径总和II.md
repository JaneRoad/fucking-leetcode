# 题目

**类型：**DFS

**难度：**中等

![image-20210907000553650](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210907000553650.png)







# 解题思路

采用深度优先搜索的方式，枚举每一条从根节点到叶子节点的路径。

当遍历到叶子节点，且此时路径和恰为目标和时，就找到了一条满足条件的路径。

# 代码

```java
package depthFirstSearch;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }
}
```

