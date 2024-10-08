package dynamicProgramming;

/**
 * 871. 最低加油次数
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/10/8 07:44
 */
public class MinimumNumberOfRefuelingStops {


    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // 获取加油站的数量
        int n = stations.length;

        // dp[i]表示使用i次加油后能够到达的最远距离
        long[] dp = new long[n + 1];

        // 初始化，使用0次加油能够到达的最远距离就是startFuel
        dp[0] = startFuel;

        // 遍历每个加油站
        for (int i = 0; i < n; i++) {
            // 由于我们要更新dp数组，因此需要从后向前遍历避免覆盖之前的结果
            for (int j = i; j >= 0; j--) {
                // 如果当前能够到达加油站stations[i]的位置
                if (dp[j] >= stations[i][0]) {
                    // 更新使用j+1次加油后的最远距离
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }

        // 检查在使用0到n次加油的情况下，是否可以到达目标target
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                // 如果可以到达，则返回最少加油次数i
                return i;
            }
        }

        // 如果无法到达目标，返回-1
        return -1;
    }

}
