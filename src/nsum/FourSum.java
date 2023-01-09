package nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    /**
     * 求出数组中K元组和为目标值的所有组合。
     * 递归函数
     *
     * @param nums   数组
     * @param target 目标数
     * @param start  开始的位置
     * @param k      要求几个数之和
     * @return
     */
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (start == nums.length) {
            return res;
        }

        //平均值
        int averageValue = target / k;
        //平均值大于初始值或最后一个值，直接返回
        if (nums[start] > averageValue || averageValue > nums[nums.length - 1]) {
            return res;
        }
        //两数之和
        if (k == 2) {
            return twoSum(nums, target, start);
        }

        /**
         * 求出数组中 (k-1) 元组和为 (target-nums[i]) 的所有组合。
         * 通过比较当前数字和上一个数字是否相同，避免重复计算相同的组合。
         * 如果新列表中的第一个数字大于 target/k，或者新列表中的最后一个数字小于 target/k，则返回空列表，因为此时的组合中的数字范围不可能与 target 相等。
         */
        for (int i = start; i < nums.length; ++i) {
            //当前索引 i 等于 start，或者当前数字和上一个数字不相同
            if (i == start || nums[i - 1] != nums[i]) {
                List<List<Integer>> recursionRes = kSum(nums, target - nums[i], i + 1, k - 1);
                for (List<Integer> subset : recursionRes) {
                    //将当前数字放入新创建的列表中
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    List<Integer> sub = res.get(res.size() - 1);
                    //将 (k-1) 元组的所有数字添加到新列表中。如果新列表中的第一个数字大于 target/k，或者新列表中的最后一个数字小于 target/k，则返回空列表。
                    sub.addAll(subset);
                    if (sub.get(0) > target / k || target / k > sub.get(sub.size() - 1))
                        return new ArrayList<>();
                }
            }
        }

        return res;
    }

    /**
     * 双指针
     * 求出数组中二元组和为目标值的所有组合。
     *
     * @param nums
     * @param target
     * @param start
     * @return
     */
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start, right = nums.length - 1;

        while (left < right) {
            //先计算当前二元组的和
            int currSum = nums[left] + nums[right];
            //如果当前二元组的和小于目标值，或者左指针的值和上一个值相同，将左指针右移一位。
            if (currSum < target || (left > start && nums[left] == nums[left - 1])) {
                ++left;
                //如果当前二元组的和大于目标值，或者右指针的值和下一个值相同，则将右指针左移一位。
            } else if (currSum > target || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
                --right;
            } else {
                res.add(Arrays.asList(nums[left++], nums[right--]));
            }
        }

        return res;
    }


}
