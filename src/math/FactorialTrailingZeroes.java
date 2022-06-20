package math;

/**
 * 172. 阶乘后的零
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
}
