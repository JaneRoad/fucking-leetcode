package breadthFirstSearch;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class EvenOddTree {

    /**
     * @Author JaneRoad
     * @Description 1609. 奇偶树
     * @Date 15:03 2021/12/25
     * @Param
     * @param root
     * @return
     * @return boolean
     **/
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int value = node.val;
                if (level % 2 == value % 2) {
                    return false;
                }
                if ((level % 2 == 0 && value <= prev) || (level % 2 == 1 && value >= prev)) {
                    return false;
                }
                prev = value;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(0x3f3f3f3f);
        System.out.println(Integer.MAX_VALUE);
    }
}
