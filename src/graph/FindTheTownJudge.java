package graph;

public class FindTheTownJudge {
    /**
     * @Author JaneRoad
     * @Description 找到小镇的法官
     * @Date 14:14 2021/12/19
     * @Param 
     * @param n
     * @param trust
     * @return 
     * @return int
     **/
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1], out = new int[n + 1];
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            in[b]++; out[a]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) return i;
        }
        return -1;
    }
}
