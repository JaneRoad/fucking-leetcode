package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author JaneRoad
 * @Description 219. 存在重复元素 II
 * @Date 22:41 2022/1/20
 **/
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
