package array;

/**
 * Description of the class or method.
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/3/10 11:14输入：
 * [1,2,3,-1,2]
 * 3
 * 输出：
 * 9
 * 预期：
 * 22
 */
public class Test {
    int[] numss;
    public long maximumStrength(int[] nums, int k) {
        numss = nums;
        // 计算所有子数组的前缀和数组
        int n = nums.length;
        long[] prefixSums = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        // 初始化动态规划状态数组，dp[i][j] 表示在前 i 个子数组中选择 j 个子数组的最大能量值
        long[][] dp = new long[n + 1][k + 1];

        // 填充动态规划表的首行和首列
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= k; j++) {
            dp[0][j] = Long.MIN_VALUE;
        }

        // 动态规划遍历子数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                // 枚举当前子数组长度，计算其与前一个子数组合并的能量值
                for (int len = 1; len <= i; len++) {
                    long energy = calculateEnergy(prefixSums, i, len);
                    dp[i][j] = Math.max(dp[i][j], dp[i - len][j - 1] + energy);
                }
            }
        }

        // 返回最大能量值
        return dp[n][k];
    }

    // 计算以第i个位置结尾，长度为len的子数组的能量值
    private long calculateEnergy(long[] prefixSums, int i, int len) {
        long sum = prefixSums[i] - (i > len ? prefixSums[i - len] : 0);
        long x = len;
        long energy = sum * x;
        for (int d = 2; d <= len; d += 2) {
            x -= 1;
            energy -= sum * x;
            if (i >= d + 1) {
                sum += 2L * numss[i - d];
            }
        }
        return energy;
    }


    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.maximumStrength(new int[]{1, 2, 3, -1, 2}, 3));
    }
}
