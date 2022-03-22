package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 653. 两数之和 IV - 输入 BST
 */
public class TwoSumIVInputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> leftDeque = new ArrayDeque<>(), rightDeque = new ArrayDeque<>();
        TreeNode temp = root;
        while (temp != null) {
            leftDeque.addLast(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {
            rightDeque.addLast(temp);
            temp = temp.right;
        }
        TreeNode l = leftDeque.peekLast(), r = rightDeque.peekLast();
        while (l.val < r.val) {
            int t = l.val + r.val;
            if (t == k) return true;
            if (t < k) l = getNext(leftDeque, true);
            else r = getNext(rightDeque, false);
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
