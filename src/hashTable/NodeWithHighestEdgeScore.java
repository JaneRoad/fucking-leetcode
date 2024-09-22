package hashTable;

/**
 * 2374. 边积分最高的节点
 *
 * @author JaneRoad
 * @version 1.0
 * @since 2024/9/22 08:19
 */
public class NodeWithHighestEdgeScore {
    /**
     * 计算每个节点的边分数
     * 边分数定义为该节点所有入边的源节点索引之和
     * 此函数旨在找到具有最高边分数的节点
     *
     * @param edges 一个表示图中节点之间边的关系的数组
     * @return 具有最高边分数的节点索引
     */
    public int edgeScore(int[] edges) {
        // 节点的数量
        int n = edges.length;
        // 用于存储每个节点的边分数
        long[] points = new long[n];

        // 遍历边的关系数组，计算每个节点的边分数
        for (int i = 0; i < n; i++) {
            points[edges[i]] += i;
        }

        // 初始化最大边分数和对应的节点索引
        long maxPoints = -1;
        int res = -1;

        // 寻找具有最高边分数的节点
        for (int i = 0; i < n; i++) {
            if (points[i] > maxPoints) {
                maxPoints = points[i];
                res = i;
            }
        }

        // 返回具有最高边分数的节点索引
        return res;
    }

}
