package greedy;

import java.util.Arrays;

public class TheNumberOfWeakCharactersIntheGame {
    /**
     * @Author JaneRoad
     * @Description 1996. 游戏中弱角色的数量
     * @Date 15:28 2022/1/30
     * @Param
     * @param ps
     * @return
     * @return int
     **/
    public int numberOfWeakCharacters(int[][] ps) {
        int n = ps.length, ans = 0;
        Arrays.sort(ps, (a, b)->{
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        for (int i = 0, max = ps[0][1]; i < n; ) {
            int j = i;
            while (j < n && ps[j][0] == ps[i][0]) {
                if (i != 0 && ps[j][1] < max) ans++;
                j++;
            }
            max = Math.max(max, ps[i][1]); i = j;
        }
        return ans;
    }
}
