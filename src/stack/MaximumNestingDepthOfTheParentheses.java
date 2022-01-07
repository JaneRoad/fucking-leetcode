package stack;

public class MaximumNestingDepthOfTheParentheses {
    /**
     * @Author JaneRoad
     * @Description 1614. 括号的最大嵌套深度
     * @Date 23:50 2022/1/7
     * @Param 
     * @param s
     * @return 
     * @return int
     **/
    public int maxDepth(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == '(') cnt++;
            else if (s.charAt(i) == ')') cnt--;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
