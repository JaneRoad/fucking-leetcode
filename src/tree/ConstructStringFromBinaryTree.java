package tree;

import common.TreeNode;

public class ConstructStringFromBinaryTree {
    StringBuilder sb = new StringBuilder();



    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.substring(1, sb.length() - 1);
    }



    void dfs(TreeNode root) {
        sb.append("(");
        sb.append(root.val);
        if (root.left != null) dfs(root.left);
        else if (root.right != null) sb.append("()");
        if (root.right != null) dfs(root.right);
        sb.append(")");
    }
}
