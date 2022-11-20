package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * @author janeroad
 */
public class CombinationSumIII {

    /**
     * 记录回溯算法的递归路径
     */
    LinkedList<Integer> track = new LinkedList<>();

    /**
     * track 中的元素会被标记为 true
     */
    boolean[] used;

    List<List<Integer>> res = new LinkedList<>();
    /**
     * 记录 track 中的路径和
     */
    int trackSum = 0;

    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     * 主函数
     * @param k 题目规定的track中的size
     * @param n 题目规定的总和target
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        used = new boolean[9];
        backtrack(0, k, n);
        return res;
    }


    /**
     * 回溯算法核心函数
     * @param start nums本次遍历开始位置
     * @param k 题目规定的track中的size
     * @param n 题目规定的总和target
     */
    void backtrack(int start, int k, int n) {
        // base case，找到目标和，记录结果
        if (trackSum == n && track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        // base case，超过目标和，停止向下遍历
        if (trackSum > n || track.size() > k) {
            return;
        }

        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 选择 nums[i]
            trackSum += nums[i];
            track.add(nums[i]);
            // 递归遍历下一层回溯树
            // 同一元素不可重复使用，注意参数
            backtrack(i + 1, k, n);
            // 撤销选择 nums[i]
            trackSum -= nums[i];
            track.removeLast();
        }
    }

}
