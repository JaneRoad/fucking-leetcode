package math;

public class WaterBottles {
    /**
     * @Author JaneRoad
     * @Description 1518. 换酒问题
     * @Date 11:24 2021/12/18
     * @Param
     * @param n
     * @param m
     * @return
     * @return int
     **/
    public int numWaterBottles(int n, int m) {
        int cnt = n / (m  - 1);
        return n % (m - 1) == 0 ? n + cnt - 1 : n + cnt;
    }
}
