package math;

/**
 * 504. 七进制数
 */
public class Base7 {
    public String convertToBase7(int n) {
        boolean flag = n < 0;
        if (flag) n = -n;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(n % 7);
            n /= 7;
        } while (n != 0);
        sb.reverse();
        return flag ? "-" + sb.toString() : sb.toString();
    }
}
