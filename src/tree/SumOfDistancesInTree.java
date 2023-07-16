package tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 834. 树中距离之和
 * @author janeroad
 */
public class SumOfDistancesInTree {

    private int[] count; // 记录每个节点的子节点数量
    private int[] sum; // 记录每个节点到其所有子节点的距离之和
    private int[] result; // 记录每个节点到其他节点的距离之和

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        count = new int[n];
        sum = new int[n];
        result = new int[n];

        // 初始化邻接表
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 构建图结构
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 第一次遍历，计算每个节点到其所有子节点的距离之和和子节点数量
        dfs(0, -1, graph);

        // 第二次遍历，计算每个节点到其他节点的距离之和
        dfs(0, -1, graph, n);

        return result;
    }

    // 后序遍历，同时计算节点到其他节点的距离之和和子节点的数量
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> graph) {
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            dfs(child, node, graph);
            count[node] += count[child];
            sum[node] += sum[child] + count[child];
        }
        count[node]++;
    }

    // 后序遍历，计算节点到其他节点的距离之和
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> graph, int n) {
        result[node] = sum[node];

        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }

            sum[child] = sum[node] - count[child] + (n - count[child]);
            dfs(child, node, graph, n);
        }
    }

    public static void main(String[] args) {
        SumOfDistancesInTree solution = new SumOfDistancesInTree();
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] result = solution.sumOfDistancesInTree(n, edges);
        System.out.println(Arrays.toString(result));
    }
}
