package array;

/**
 * 1184. 公交站间的距离
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/16 19:02
 */
public class DistanceBetweenBusStops {
    /**
     * 计算两点间的最小距离
     * @param distance 距离数组，表示每个公交站之间的距离
     * @param start 起点站的索引
     * @param destination 终点站的索引
     * @return 最短路径长度，即直接行驶和绕行的最短距离
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // 用于累加直接行驶的距离
        int cur = 0;
        // 用于累加整个环线的距离
        int sum = 0;

        // 确保start总是小于destination，简化后续计算
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        // 计算直接行驶的距离（从start到destination）
        for (int i = start; i < destination; i++) {
            cur += distance[i];
        }

        // 计算整个环线的距离
        for (int j : distance) {
            sum += j;
        }

        // 计算绕行的距离
        int diff = sum - cur;

        // 返回直接行驶和绕行的最短距离
        return Math.min(cur, diff);
    }


    public static void main(String[] args) {
        int[] distance = {7,10,1,12,11,14,5,0};
        int start = 7;
        int destination = 2;
        System.out.println(new DistanceBetweenBusStops().distanceBetweenBusStops(distance, start, destination));
    }
}
