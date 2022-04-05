package array;

import java.util.Arrays;

/**
 * 2028. 找出缺失的观测数据
 */
public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, cnt = m + n;
        int t = mean * cnt;
        for (int i : rolls) t -= i;
        if (t < n || t > 6 * n) return new int[0];
        int[] ans = new int[n];
        Arrays.fill(ans, t / n);
        if (t / n * n < t) {
            int d = t - (t / n * n), idx = 0;
            while (d-- > 0) ans[idx++]++;
        }
        return ans;
    }
}
