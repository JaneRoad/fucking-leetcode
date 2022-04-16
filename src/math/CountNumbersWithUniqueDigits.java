package math;

/**
 * 357. 统计各位数字都不同的数字个数
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        int ans = 9;
        for(int i = 9; i > 10 - n; i--)
            ans *= i;
        return ans + countNumbersWithUniqueDigits(n - 1);
    }
}
