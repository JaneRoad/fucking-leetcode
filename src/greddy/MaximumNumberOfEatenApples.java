package greddy;

import java.util.PriorityQueue;

public class MaximumNumberOfEatenApples {

    /**
     * @Author JaneRoad
     * @Description 1705. 吃苹果的最大数目
     * @Date 14:37 2021/12/25
     * @Param
     * @param apples
     * @param days
     * @return
     * @return int
     **/
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[0]-b[0]);
        int n = apples.length, time = 0, ans = 0;
        while (time < n || !q.isEmpty()) {
            if (time < n && apples[time] > 0) q.add(new int[]{time + days[time] - 1, apples[time]});
            while (!q.isEmpty() && q.peek()[0] < time) q.poll();
            if (!q.isEmpty()) {
                int[] cur = q.poll();
                if (--cur[1] > 0 && cur[0] > time) q.add(cur);
                ans++;
            }
            time++;
        }
        return ans;
    }
}
