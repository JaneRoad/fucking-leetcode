package depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 2368. 受限条件下可到达节点的数目
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/3/3 16:36
 */
public class ReachableNodesWithRestrictions {

    // count用来记录可达节点的数量
    private int count = 0;

    /**
     * 可到达的节点计算
     * @param n n 个节点组成的无向树
     * @param edges 二维整数数组 edges
     * @param restricted 整数数组 restricted 表示 受限 节点
     * @return 从节点 0 到达的 最多 节点数目
     */
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // 创建一个boolean型数组，用于标记是否是受限节点。
        boolean[] isRestricted = new boolean[n];
        for (int node : restricted) {
            isRestricted[node] = true;
        }

        // 构建图的邻接表。
        List<List<Integer>> graph = buildGraph(n, edges);


        //创建一个标记数组，用于记录节点是否已经访问过。
        boolean[] visited = new boolean[n];

        //从节点0开始进行深度优先搜索
        dfs(0, visited, isRestricted, graph);

        return count;
    }

    /**
     * 构建邻接表
     * @param n 节点数量
     * @param edges 节点 二维整数数组
     * @return 邻接表
     */
    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    /**
     * 深度优先搜索
     * @param node 节点
     * @param visited 已经访问过的节点数组
     * @param isRestricted 是否受限节点数组
     * @param graph 邻接表
     */
    private void dfs(int node, boolean[] visited, boolean[] isRestricted, List<List<Integer>> graph) {
        //如果节点是受限的或者已经访问过，直接返回
        if (isRestricted[node] || visited[node]) {
            return;
        }

        //否则，标记为已访问并增加可达节点数量
        visited[node] = true;
        count++;

        //对每一个邻居节点，如果它不是受限的并且还未访问过，那么就对它进行深度优先搜索
        for (int neighbor : graph.get(node)) {
            dfs(neighbor, visited, isRestricted, graph);
        }
    }
}