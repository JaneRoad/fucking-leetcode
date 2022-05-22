package tree;

import common.QuadTreeNode;

/**
 * 427. 建立四叉树
 */
public class ConstructQuadTree {
    static int[][] sum = new int[70][70];
    int[][] g;
    public QuadTreeNode construct(int[][] grid) {
        g = grid;
        int n = grid.length;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + g[i - 1][j - 1];
            }
        }
        return dfs(0, 0, n - 1, n - 1);
    }
    QuadTreeNode dfs(int a, int b, int c, int d) {
        int cur = sum[c + 1][d + 1] - sum[a][d + 1] - sum[c + 1][b] + sum[a][b];
        int dx = c - a + 1, dy = d - b + 1, tot = dx * dy;
        if (cur == 0 || cur == tot) return new QuadTreeNode(g[a][b] == 1, true);
        QuadTreeNode root = new QuadTreeNode(g[a][b] == 1, false);
        root.topLeft = dfs(a, b, a + dx / 2 - 1, b + dy / 2 - 1);
        root.topRight = dfs(a, b + dy / 2, a + dx / 2 - 1, d);
        root.bottomLeft = dfs(a + dx / 2, b, c, b + dy / 2 - 1);
        root.bottomRight = dfs(a + dx / 2, b + dy / 2, c, d);
        return root;
    }
}
