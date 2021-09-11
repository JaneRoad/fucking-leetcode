package depthFirstSearch;

import common.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return balanced(root) != -1;
    }

    private int balanced(TreeNode node) {
        if (node == null) return 0;
        int leftHeight, rightHeight;
        if ((leftHeight = balanced(node.left)) == -1
                || (rightHeight = balanced(node.right)) == -1
                || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
