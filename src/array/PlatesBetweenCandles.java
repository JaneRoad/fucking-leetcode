package array;

/**
 * @Author JaneRoad
 * @Description 2055. 蜡烛之间的盘子
 * @Date 19:08 2022/3/12
 **/
public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] qs) {
        char[] cs = s.toCharArray();
        int n = cs.length, m = qs.length;
        // 离当前点最近的  左边蜡烛和右边蜡烛位置
        int[] l = new int[n], r = new int[n];
        // 计算前缀和数组
        int[] sum = new int[n + 1];
        for (int i = 0, j = n - 1, p = -1, q = -1; i < n; i++, j--) {
            // 最近左边蜡烛点
            if (cs[i] == '|') p = i;
            // 最近右边蜡烛点
            if (cs[j] == '|') q = j;
            l[i] = p; r[j] = q;
            //更新前缀和
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = qs[i][0], b = qs[i][1];
            int c = r[a], d = l[b];
            // 左边蜡烛点小于右边蜡烛点位置
            if (c != -1 && c <= d) ans[i] = sum[d + 1] - sum[c];
        }
        return ans;
    }
}
