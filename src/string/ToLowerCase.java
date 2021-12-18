package string;

public class ToLowerCase {

    /**
     * @Author JaneRoad
     * @Description 709. 转换成小写字母
     * @Date 15:44 2021/12/12
     * @Param 
     * @param s
     * @return 
     * @return java.lang.String
     **/
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) {
                ch |= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * @Author JaneRoad
     * @Description
     * 方法二：使用语言自带的大写字母转小写字母的 API
     * @Date 14:14 2021/12/12
     * @Param
     * @param s
     * @return
     * @return java.lang.String
     **/
    public String toLowerCase2(String s){
        return s.toLowerCase();
    }

}
