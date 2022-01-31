package bitManipulation;


public class NumberOfStepsToReduceANumberToZero {
    /**
     * @Author JaneRoad
     * @Description 1342. 将数字变成 0 的操作次数
     * @Date 11:47 2022/1/31
     * @Param
     * @param num
     * @return
     * @return int
     **/
    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0 && ++ans >= 0) {
            int res = num % 2 == 0 ? num / 2 : num - 1;
            num = res;
        }
        return ans;
    }

    /**
     * @Author JaneRoad
     * 解法二 位运算
    public int numberOfSteps(int num) {
        return Math.max(getLoc(num) + getCnt(num) - 1, 0);
    }

    int getLoc(int x) {
        for (int i = 31; i >= 0; i--) {
            if (((x >> i) & 1) == 1) return i + 1;
        }
        return -1; // never
    }
    int getCnt(int x) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if (((x >> i) & 1) == 1) ans++;
        }
        return ans;
    }
     **/
}
