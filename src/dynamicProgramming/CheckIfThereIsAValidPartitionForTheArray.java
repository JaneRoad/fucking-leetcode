package dynamicProgramming;

/**
 * 2369. 检查数组是否存在有效划分
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/3/3 17:44
 */
public class CheckIfThereIsAValidPartitionForTheArray {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        // 特殊情况，如果数组长度小于2，无法形成有效划分
        if (n < 2) {
            return false;
        }

        boolean[] dp = new boolean[n];
        // 前两个元素可以构成有效的子数组
        dp[0] = false;
        dp[1] = nums[0] == nums[1];

        // 如果前三个元素相同或递增，也可以构成有效子数组
        if (n >= 3) {
            dp[2] = (nums[0] == nums[1] && nums[1] == nums[2]) || (nums[0] + 1 == nums[1] && nums[1] + 1 == nums[2]);
        }

        for (int i = 3; i < n; ++i) {
            // 检查两个元素的子数组
            if (nums[i] == nums[i - 1] && dp[i - 2]) {
                dp[i] = true;
            }
            // 检查三个元素的子数组
            if ((nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) ||
                    (nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1)) {
                if (dp[i - 3]) {
                    dp[i] = true;
                }
            }
        }

        return dp[n - 1];
    }
}
