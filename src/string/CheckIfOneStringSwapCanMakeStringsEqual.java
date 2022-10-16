package string;

/**
 * 仅执行一次字符串交换能否使两个字符串相等
 * @author janeroad
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int idx = -1;
        for (int i = 0, n = s1.length(); i < n; ++i) {
            char a = s1.charAt(i), b = s2.charAt(i);
            // 相同不用管
            if (a == b) {
                continue;
            }else if (idx == -1) {
                // 第一处不同记录下
                idx = i;
            }
            // 超过两处不同
            else if (idx == -2) {
                return false;
            } else {
                if (a != s2.charAt(idx) || b != s1.charAt(idx)){
                    // 不同的位置对应字符不同
                    return false;
                }
                // 标记已有两处不同
                idx = -2;
            }
        }
        return idx < 0;
    }
}
