package breadthFirstSearch;

import common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 429. N 叉树的层序遍历
 */
public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        //答案
        List<List<Integer>> ans = new ArrayList<>();
        //队列
        Deque<Node> d = new ArrayDeque<>();
        //队列添加首节点
        if (root != null) {
            d.addLast(root);
        }
        while (!d.isEmpty()) {
            int size = d.size();
            List<Integer> list = new ArrayList<>();
            //如果不是最后一个节点
            while (size-- > 0) {
                //取出队列头结点
                Node t = d.pollFirst();
                //遍历当前节点的的所有子节点
                for (Node node : t.children) {
                    //放到队列中
                    d.addLast(node);
                }
                //list里插入当前节点的值
                list.add(t.val);
            }
            //把当前层所有节点存到答案
            ans.add(list);
        }
        return ans;
    }
}
