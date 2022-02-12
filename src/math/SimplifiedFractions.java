package math;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {

    /**
     * @Author JaneRoad
     * @Description 1447. 最简分数
     * @Date 11:34 2022/2/12
     * @Param
     * @param n
     * @return
     * @return java.util.List<java.lang.String>
     **/
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) ans.add(i + "/" + j);
            }
        }
        return ans;
    }


    int gcd(int a, int b) { // 欧几里得算法
        return b == 0 ? a : gcd(b, a % b);
    }
}
