package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * @author janeroad
 */
public class CombinationSum {
    List<List<Integer>> res = new LinkedList<>();

    /**
     * 记录回溯算法的递归路径
     */
    LinkedList<Integer> track = new LinkedList<>();

    /**
     * 回溯算法主函数
     * @param candidates 题目的输入数组
     * @param target 题目规定的总和target
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }



    /**
     * 回溯算法核心函数
     * @param candidates nums本次遍历开始位置
     * @param start nums本次遍历开始位置
     * @param target 题目规定的总和target
     * @param sum 当前路径和
     */
    void backtrack(int[] candidates, int start, int target, int sum) {
        if (sum == target) {
            // 找到目标和
            res.add(new LinkedList<>(track));
            return;
        }

        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (int i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            track.add(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(candidates, i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.removeLast();
        }
    }
}
