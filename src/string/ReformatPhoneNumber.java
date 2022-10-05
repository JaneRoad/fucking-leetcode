package string;

/**
 * 1694. 重新格式化电话号码
 * @author janeroad
 */
public class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        String s = number.replace(" ", "").replace("-", "");
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            if (i + 5 > n) {
                if (i + 3 >= n) {
                    sb.append(s.substring(i));
                } else {
                    sb.append(s.substring(i, i + 2)).append("-").append(s.substring(i + 2));
                }
                break;
            }
            sb.append(s.substring(i, i + 3));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String number = "1-23-45 6";
        String s = number.replace(" ", "").replace("-", "");
        String s2 = "123 4-567".replace(" ", "").replace("-", "");

        //输出 123
        System.out.println(s.substring(0,3));

        //输出 45-67
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(s2.substring(3, 3 + 2)).append("-").append(s2.substring(3 + 2)));

        //输出 456
        System.out.println(s.substring(3));

    }
}
