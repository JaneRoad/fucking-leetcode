package breadthFirstSearch;

import java.util.*;

/**
 * 815. 公交路线
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/17 10:37
 */
public class NumBusesToDestination {
    /**
     * 求出最少乘坐的公交车数量
     *
     * @param routes 公交线路
     * @param source 起点
     * @param target 终点
     * @return 最少乘坐的公交车数量
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // 如果起点和终点相同，不需要乘坐公交车
        if (source == target) return 0;

        // 1. 构建车站与公交车的映射
        Map<Integer, List<Integer>> stationToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                stationToBuses.computeIfAbsent(station, k -> new ArrayList<>()).add(i);
            }
        }

        // 2. 初始化 BFS 队列，加入初始车站
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        // 记录访问过的车站和公交车
        Set<Integer> visitedStations = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        visitedStations.add(source);

        int busesTaken = 0;

        // 3. BFS 搜索
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 每层代表一次换乘
            busesTaken++;
            for (int i = 0; i < size; i++) {
                // 当前车站
                int station = queue.poll();

                // 遍历所有可以在当前车站乘坐的公交车
                for (int bus : stationToBuses.getOrDefault(station, new ArrayList<>())) {
                    if (visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);

                    // 遍历该公交车所经过的所有车站
                    for (int nextStation : routes[bus]) {
                        //返回已乘坐的公交车数量
                        if (nextStation == target) return busesTaken;
                        if (visitedStations.contains(nextStation)) continue;
                        visitedStations.add(nextStation);
                        queue.offer(nextStation);
                    }
                }
            }
        }

        // 如果无法到达目标车站
        return -1;
    }

    public static void main(String[] args) {
        //case 1
        int[][] routes = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        int source = 15, target = 12;
        System.out.println(new NumBusesToDestination().numBusesToDestination(routes, source, target));
        //case 2
//        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
//        int source = 1, target = 6;
//        System.out.println(new NumBusesToDestination().numBusesToDestination(routes, source, target));
    }
}
