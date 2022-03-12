package tree;

import common.Node;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {
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
}
