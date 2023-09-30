package array;

import java.util.HashSet;
import java.util.List;

/**
 * 8038. 收集元素的最少操作次数
 * @author janeroad
 */
public class MinimumOperationsToCollectElements {

    public int minOperations(List<Integer> nums, int k) {
        int num = k;
        int times = 0;
        HashSet<Integer> set = new HashSet<>(k);
        for (int size = nums.size(); size > 0; size--) {
            if (num == 0) {
                return times;
            }
            times++;
            Integer i = nums.get(size - 1);
            if (i <= k && !set.contains(i)) {
                num--;
                set.add(i);
            }
        }
        return times;
    }
}
