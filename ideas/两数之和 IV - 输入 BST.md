# 题目

**类型：树**



<img src="https://cdn.nlark.com/yuque/0/2022/png/2941598/1647877704893-d18ae20d-fd32-457f-8378-9347ed856269.png" alt="img" style="zoom:50%;" />

# 解题思路

题目给的是二叉搜索树（BST）

可以利用 BST 中序遍历有序的特性，实现类似「双指针」的效果

先让 BST 的最左链和最右链完全入栈，此时栈顶元素为 BST 中的最小值和最大值，分别使用 l 和 r 充当指针。根据两指针指向的节点值之和与 k 的大小关系来指导如何让 l 和 r 移动，l 的移动过程其实就是找下一个比 l.val 更大的值，而 r 的移动过程其实就是找下一个比 r.val 更小的值。





# 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> ld = new ArrayDeque<>(), rd = new ArrayDeque<>();
        TreeNode temp = root;
        while (temp != null) {
            ld.addLast(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {
            rd.addLast(temp);
            temp = temp.right;
        }
        TreeNode l = ld.peekLast(), r = rd.peekLast();
        while (l.val < r.val) {
            int t = l.val + r.val;
            if (t == k) return true;
            if (t < k) l = getNext(ld, true);
            else r = getNext(rd, false);
        }
        return false;
    }
    TreeNode getNext(Deque<TreeNode> d, boolean isLeft) {
        TreeNode node = isLeft ? d.pollLast().right : d.pollLast().left;
        while (node != null) {
            d.addLast(node);
            node = isLeft ? node.left : node.right;
        }
        return d.peekLast();
    }
}
```