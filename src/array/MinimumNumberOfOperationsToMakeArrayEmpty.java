package array;

import java.util.HashMap;

/**
 * 100032. 使数组为空的最少操作次数
 * @author janeroad
 */
public class MinimumNumberOfOperationsToMakeArrayEmpty {

    public static int minOperations(int[] nums) {
        HashMap<Integer, Integer> numAndTimes = new HashMap<>();
        int result = 0;

        // 统计每个元素的出现次数
        for (int num : nums) {
            int times = numAndTimes.getOrDefault(num, 0);
            numAndTimes.put(num, times + 1);
        }

        // 遍历哈希表中的每个元素
        for (int key : numAndTimes.keySet()) {
            int value = numAndTimes.get(key);
            if (value == 1) {
                return -1;
            }
            if (value == 2) {
                result += value / 2;
            } else if (value % 3 == 0) {
                result += value / 3;
            } else if (value > 3 && (value % 3) >= 2) {
                result += value / 3 + (value % 3) / 2;
            } else if (value > 3) {
                result += value / 3 + value % 3;
            }

        }

        return result;
    }


}
