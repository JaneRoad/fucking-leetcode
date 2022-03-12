package tree;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JaneRoad
 * @Description 590. N 叉树的后序遍历
 * @Date 15:02 2022/3/12
 **/
public class NAryTreePostorderTraversal {
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
