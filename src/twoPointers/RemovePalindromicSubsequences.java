package twoPointers;

public class RemovePalindromicSubsequences {
    /**
     * @Author JaneRoad
     * @Description 1332. 删除回文子序列
     * @Date 14:56 2022/1/22
     * @Param
     * @param s
     * @return
     * @return int
     **/
    public int removePalindromeSub(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return 2;
            i++; j--;
        }
        return 1;
    }
}
