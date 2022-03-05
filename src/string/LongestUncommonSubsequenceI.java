package string;

public class LongestUncommonSubsequenceI {
    /**
     * @Author JaneRoad
     * @Description 521. 最长特殊序列 Ⅰ
     * @Date 09:28 2022/3/5
     * @Param
     * @param a
     * @param b
     * @return
     * @return int
     **/
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
