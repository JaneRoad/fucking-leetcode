import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Test {

    /**
     * 100032. 使数组为空的最少操作次数
     *
     * @param nums
     * @return
     */
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

    /**
     * 8038. 收集元素的最少操作次数
     *
     * @param nums
     * @param k
     * @return
     */
    public static int minOperations(List<Integer> nums, int k) {
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


    public static void main(String[] args) {
//        System.out.println(minOperations(Arrays.asList(3,2,5,3,1), 3));
        System.out.println(minOperations(new int[]{14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12}));

    }
}
