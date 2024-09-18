package array;

import java.util.Arrays;

/**
 * 2332 坐上公交的最晚时间
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/18 08:12
 */
public class LatestTimeCatchTheBus {
    /**
     * 示例 输入：buses = [20,30,10], passengers = [19,13,26,4,25,11,21], capacity = 2
     * @param buses 公交车
     * @param passengers 乘客
     * @param capacity 容量
     * @return
     */
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        // 对公交车和乘客的到达时间进行升序排序
        Arrays.sort(buses);
        Arrays.sort(passengers);

        // pos 指向当前处理的乘客位置，space 代表当前车上剩余空位
        int pos = 0;
        int space = 0;

        // 遍历每一辆公交车的到达时间
        for (int arrive : buses) {
            // 每辆车的空位数量初始化为 capacity
            space = capacity;

            // 尽可能多的乘客在该公交车到达时上车
            while (space > 0 && pos < passengers.length && passengers[pos] <= arrive) {
                // 如果乘客的到达时间小于等于公交车的到达时间，则上车
                space--;  // 空位减少
                pos++;    // 处理下一个乘客
            }
        }

        // 所有公交车处理完后，最后一个上车乘客的索引
        pos--;

        // 如果最后一辆公交车仍有空位，则最晚能上车的时间是最后一辆公交车的到达时间
        // 否则是最后一个成功上车的乘客的时间
        int lastCatchTime = space > 0 ? buses[buses.length - 1] : passengers[pos];

        // 确保没有乘客已经在最后的时间上车，找到能上车的最晚空闲时间
        while (pos >= 0 && passengers[pos] == lastCatchTime) {
            pos--;            // 如果乘客已经在 lastCatchTime 时间上车，继续往前找空闲时间
            lastCatchTime--;  // 将最晚上车时间往前调整
        }

        // 返回能上车的最晚时间
        return lastCatchTime;
    }
}
