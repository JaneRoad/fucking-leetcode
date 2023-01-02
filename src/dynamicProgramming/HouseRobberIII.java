package dynamicProgramming;

import common.TreeNode;

/**
 * 337. 打家劫舍 III
 *
 * @author janeroad
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 返回一个大小为 2 的数组 arr
     * arr[0] 表示不抢 root 的话，得到的最大钱数
     * arr[1] 表示抢 root 的话，得到的最大钱数
     *
     * @param root
     * @return
     */
    int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int doRob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int doNotRob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        return new int[]{doNotRob, doRob};
    }


}
