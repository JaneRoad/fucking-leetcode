package depthFirstSearch;

public class WhereWillTheBallFall {
    int m, n;
    int[][] g;

    /**
     * @Author JaneRoad
     * @Description 1706. 球会落何处
     * @Date 11:01 2022/2/26
     * @Param
     * @param grid
     * @return
     * @return int[]
     **/
    public int[] findBall(int[][] grid) {
        g = grid;
        m = g.length; n = g[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = getVal(i);
        return ans;
    }
    int getVal(int x) {
        int r = 0, c = x;
        while (r < m) {
            int ne = c + g[r][c];
            if (ne < 0 || ne >= n) return -1;
            if (g[r][c] != g[r][ne]) return -1;
            r++; c = ne;
        }
        return c;
    }
}
