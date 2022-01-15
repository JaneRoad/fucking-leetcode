package array;

public class SlowestKey {
    /**
     * @Author JaneRoad
     * @Description 1629. 按键持续时间最长的键
     * @Date 22:48 2022/1/9
     * @Param
     * @param rt
     * @param kp
     * @return
     * @return char
     **/
    public char slowestKey(int[] rt, String kp) {
        int n = rt.length, idx = 0, max = rt[0];
        for (int i = 1; i < n; i++) {
            int cur = rt[i] - rt[i - 1];
            if (cur > max) {
                idx = i; max = cur;
            } else if (cur == max && kp.charAt(i) > kp.charAt(idx)) {
                idx = i;
            }
        }
        return kp.charAt(idx);
    }
}
