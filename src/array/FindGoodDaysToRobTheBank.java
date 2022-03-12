package array;

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRobTheBank {
    /**
     * @Author JaneRoad
     * @Description 2100. 适合打劫银行的日子
     * @Date 21:05 2022/3/6
     * @Param
     * @param security
     * @param time
     * @return
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] g = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] == security[i - 1]) continue;
            g[i] = security[i] > security[i - 1] ? 1 : -1;
        }
        int[] a = new int[n + 1], b = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = a[i - 1] + (g[i - 1] == 1 ? 1 : 0);
        for (int i = 1; i <= n; i++) b[i] = b[i - 1] + (g[i - 1] == -1 ? 1 : 0);
        List<Integer> ans = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            int c1 = a[i + 1] - a[i + 1 - time], c2 = b[i + 1 + time] - b[i + 1];
            if (c1 == 0 && c2 == 0) ans.add(i);
        }
        return ans;
    }
}
