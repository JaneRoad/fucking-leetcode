package twoPointers;

public class ReverseOnlyLetters {
    /**
     * @Author JaneRoad
     * @Description 917. 仅仅反转字母
     * @Date 10:57 2022/2/26
     * @Param 
     * @param s
     * @return 
     * @return java.lang.String
     **/
    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0, j = n - 1; i < j; ) {
            while (i < j && !Character.isLetter(cs[i])) i++;
            while (i < j && !Character.isLetter(cs[j])) j--;
            if (i < j) {
                char c = cs[i];
                cs[i++] = cs[j];
                cs[j--] = c;
            }
        }
        return String.valueOf(cs);
    }
}
