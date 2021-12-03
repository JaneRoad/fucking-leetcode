package string;

public class ConsecutiveCharacters {
    /**
     * @Author JaneRoad
     * @Description 1446 连续字符
     * @Date 22:57 2021/12/1
     * @Param
     * @param s
     * @return
     * @return int
     **/
    public int maxPower(String s) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }
}
