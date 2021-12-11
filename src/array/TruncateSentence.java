package array;

public class TruncateSentence {
    /**
     * @Author JaneRoad
     * @Description 1816. 截断句子
     * @Date 22:57 2021/12/6
     * @Param 
     * @param s
     * @param k
     * @return 
     * @return java.lang.String
     **/
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0, cnt = 0; i < n && cnt < k; i++) {
            char c = s.charAt(i);
            if (c == ' ') cnt++;
            if (cnt < k) sb.append(c);
        }
        return sb.toString();
    }
}
