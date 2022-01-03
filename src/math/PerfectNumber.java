package math;

public class PerfectNumber {
    /**
     * @Author JaneRoad
     * @Description 507. 完美数
     * @Date 23:29 2022/1/2
     * @Param 
     * @param num
     * @return 
     * @return boolean
     **/
    public boolean checkPerfectNumber(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }

    public boolean checkPerfectNumber2(int num) {
        if (num == 1) return false;
        int ans = 1;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                ans += i;
                if (i * i != num) ans += num / i;
            }
        }
        return ans == num;
    }

}
