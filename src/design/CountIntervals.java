package design;

import java.util.Map;
import java.util.TreeMap;

/**
 * 2276. 统计区间中的整数数目
 */
public class CountIntervals {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int cnt = 0;

    public CountIntervals() {

    }

    /**
     * 将一个区间 [left, right] 添加到 Interval Map 中。
     * 如果 Interval Map 中存在与 [left, right] 重叠的区间，则将它们合并，并根据需要更新计数器 cnt 的值。
     *
     * @param left 区间 [left, right] 的起始点
     * @param right 区间 [left, right] 的结束点
     */
    public void add(int left, int right) {
        // 根据结束点 right 获取 Interval Map 中的初始区间
        Map.Entry<Integer, Integer> interval = map.floorEntry(right);

        // 检查是否存在与初始区间重叠的区间
        while (interval != null && interval.getValue() >= left) {
            int l = interval.getKey(), r = interval.getValue();
            left = Math.min(left, l);
            right = Math.max(right, r);

            // 从重叠的区间中减去重叠部分的区间数，以更新计数器 cnt 的值
            cnt -= r - l + 1;

            // 从 Interval Map 中移除重叠的区间
            map.remove(l);

            // 更新初始区间为下一个 Interval Map 中的区间
            interval = map.floorEntry(right);
        }

        // 将新的区间添加到 Interval Map 中，并更新计数器 cnt 的值
        cnt += (right - left + 1);
        map.put(left, right);
    }



    public int count() {
        return cnt;
    }
}
