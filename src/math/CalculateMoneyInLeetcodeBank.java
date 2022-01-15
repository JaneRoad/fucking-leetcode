package math;

public class CalculateMoneyInLeetcodeBank {
    /**
     * @Author JaneRoad
     * @Description 1716. 计算力扣银行的钱
     * @Date 23:23 2022/1/15
     * @Param
     * @param n
     * @return
     * @return int
     **/
    public int totalMoney(int n) {
        int a = n / 7, b = n % 7;
        int a1 = (1 + 7) * 7 / 2, an = (a + (a + 6)) * 7 / 2;
        int s1 = (a1 + an) * a / 2;
        a++;
        int s2 = (a + (a + b - 1)) * b / 2;
        return s1 + s2;
    }
}
