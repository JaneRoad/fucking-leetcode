package dynamicProgramming;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 1681. 最小不兼容性
 * 通过动态规划的方法，枚举所有可能的子集并计算其最小差和，最终返回最小差和的结果。它利用位运算和哈希映射来优化计算过程，提高效率。
 * @author janeroad
 */
public class MinimumIncompatibility {
    /**
     * 将数组 nums 分成 k 个非空子集，使得每个子集中的元素互不相同，并计算子集中最大值和最小值之间的差的和的最小值。如果无法满足分组的要求，则返回 -1。
     * @param nums 整数数组
     * @param k    k 个非空子集
     * @return  子集中最大值和最小值之间的差的和的最小值 如果无法满足分组的要求，则返回 -1
     */
    public int minimumIncompatibility(int[] nums, int k) {
        // n 表示数组 nums 的长度。
        // group 表示每个子集的大小，即 n 除以 k。
        // inf 是一个足够大的整数，用于表示无穷大。
        int n = nums.length, group = n / k, inf = Integer.MAX_VALUE;

        // dp 是一个长度为 1 << n 的数组，用于存储状态值，初始时将其所有元素填充为无穷大。
        int[] dp = new int[1 << n];
        Arrays.fill(dp, inf);
        dp[0] = 0;

        // values 是一个哈希映射，用于存储每个子集的最大值和最小值之间的差。
        HashMap<Integer, Integer> values = new HashMap<>();
        //使用位运算枚举所有长度为 group 的子集，使用变量 mask 表示当前子集的状态。
        for (int mask = 1; mask < (1 << n); mask++) {
            //如果当前子集的元素数量不等于 group，则跳过该子集的处理。
            if (Integer.bitCount(mask) != group) {
                continue;
            }
            //在当前子集中，找到最小值 mn 和最大值 mx，并使用哈希集合 cur 记录已经出现过的元素。
            int mn = 20, mx = 0;
            HashSet<Integer> cur = new HashSet<>();
            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) > 0) {
                    if (cur.contains(nums[i])) {
                        break;
                    }
                    cur.add(nums[i]);
                    mn = Math.min(mn, nums[i]);
                    mx = Math.max(mx, nums[i]);
                }
            }
            //如果当前子集中的元素数量等于 group，则将当前子集的状态 mask 和最大值与最小值之间的差存入哈希映射 values 中。
            if (cur.size() == group) {
                //在当前子集中，找到最小值 mn 和最大值 mx，并使用哈希集合 cur 记录已经出现过的元素。
                values.put(mask, mx - mn);
            }
        }
        //动态规划求解最小差和
        for (int mask = 0; mask < (1 << n); mask++) {
            //对于每个状态 mask，如果其对应的值为无穷大，则跳过该状态的处理。
            if (dp[mask] == inf) {
                continue;
            }
            //创建一个哈希映射 seen，用于记录当前状态中未被选择的元素和它们的索引。
            HashMap<Integer, Integer> seen = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    seen.put(nums[i], i);
                }
            }
            //如果 seen 中的元素数量小于 group，则跳过该状态的处理。
            if (seen.size() < group) {
                continue;
            }
            //创建一个变量 sub，用于表示当前状态中未被选择的元素所对应的子集状态。
            int sub = 0;
            for (int v : seen.values()) {
                sub |= (1 << v);
            }
            //对于 seen 中的每个值 v，将对应的索引所表示的位设置为 1，将结果存入 sub。
            int nxt = sub;
            //通过遍历 sub 的子集来更新状态 dp，并计算最小差和：
            while (nxt > 0) {
                //通过 nxt 变量来表示 sub 的子集状态。 如果 values 中存在键为 nxt 的值，则更新状态 dp[mask | nxt]，将其更新为当前状态 dp[mask] 加上 values[nxt] 的值。
                if (values.containsKey(nxt)) {
                    dp[mask | nxt] = Math.min(dp[mask | nxt], dp[mask] + values.get(nxt));
                }
                //使用位运算 (nxt - 1) & sub 来找到 sub 的下一个子集状态，通过不断减小 nxt 的值并与 sub 进行按位与操作来实现。循环执行上述步骤，直到 nxt 变为 0。
                nxt = (nxt - 1) & sub;
            }
        }
        //最终，dp[(1 << n) - 1] 存储的值即为最小差和。如果 dp[(1 << n) - 1] 的值小于无穷大，则返回该值作为最小差和。否则，返回 -1，表示无法满足分组的要求。
        return (dp[(1 << n) - 1] < inf) ? dp[(1 << n) - 1] : -1;
    }
}
