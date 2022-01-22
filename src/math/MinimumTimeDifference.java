package math;

import java.util.List;

public class MinimumTimeDifference {
    /**
     * @Author JaneRoad
     * @Description 539. 最小时间差
     * @Date 22:44 2022/1/18
     * @Param
     * @param timePoints
     * @return
     * @return int
     **/
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) return 0;
        int[] cnts = new int[1440 * 2 + 10];
        for (String s : timePoints) {
            String[] ss = s.split(":");
            int h = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]);
            cnts[h * 60 + m]++;
            cnts[h * 60 + m + 1440]++;
        }
        int ans = 1440, last = -1;
        for (int i = 0; i <= 1440 * 2 && ans != 0; i++) {
            if (cnts[i] == 0) continue;
            if (cnts[i] > 1) ans = 0;
            else if (last != -1) ans = Math.min(ans, i - last);
            last = i;
        }
        return ans;
    }
}
