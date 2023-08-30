package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfCompleteSubArrays {

    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(); // 创建一个用于存储数组中不同元素的集合
        for (int i = 0; i < n; i++) {
            set.add(nums[i]); // 将数组中的元素添加到集合中，这样集合中就只包含不同的元素
        }
        int m = set.size(); // m表示数组中不同元素的数目
        int[] cnt = new int[2001]; // 创建一个计数数组，用于记录每个元素在当前子数组中的出现次数
        int res = 0; // res表示当前子数组中不同元素的数目
        int ans = 0; // ans表示满足条件的完全子数组的总数

        // 使用滑动窗口来遍历数组的所有子数组
        // [i, j] 表示当前子数组的范围
        for (int i = 0, j = 0; j < n; j++) {
            cnt[nums[j]]++; // 将当前元素加入子数组并更新计数数组
            if (cnt[nums[j]] == 1) {
                res++; // 如果当前元素是子数组中的新元素（之前没有出现过），则不同元素数目增加
            }
            while (res == m) {
                // 当子数组中不同元素的数目等于整个数组不同元素的数目时，说明找到一个完全子数组
                ans += n - j; // 将以当前j为右边界的完全子数组的个数加到答案中
                cnt[nums[i]]--; // 收缩窗口，将左边界i对应的元素出现次数减1
                if (cnt[nums[i]] == 0) {
                    res--; // 如果元素出现次数变为0，说明该元素不再出现在当前子数组中，不同元素数目减少
                }
                i++; // 收缩窗口的左边界向右移动
            }
        }

        return ans; // 返回满足条件的完全子数组的总数
    }
}
