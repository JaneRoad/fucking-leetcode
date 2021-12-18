package greddy;

public class MaxIncreaseToKeepCitySkyline {
    /**
     * @Author JaneRoad
     * @Description 保持城市天际线
     * @Date 21:36 2021/12/13
     * @Param 
     * @param grid
     * @return 
     * @return int
     **/
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] r = new int[n], c = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                r[i] = Math.max(r[i], grid[i][j]);
                c[j] = Math.max(c[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += Math.min(r[i], c[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
