package math;

/**
 * 788. 旋转数字
 * @author janeroad
 */
public class RotatedDigits {
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            boolean ok = false;
            int x = i;
            //按照位数依次check
            while (x != 0) {
                int t = x % 10;
                x /= 10;
                //2, 5, 6, 9 是10位以内基础的四个好数
                if (t == 2 || t == 5 || t == 6 || t == 9) {
                    ok = true;
                //0, 1, 和 8 被旋转后仍然是它们自己，不作数
                } else if (t != 0 && t != 1 && t != 8) {
                    ok = false;
                    break ;
                }
            }
            if (ok) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

        RotatedDigits r = new RotatedDigits();
        System.out.println(r.rotatedDigits(857));
    }
}
