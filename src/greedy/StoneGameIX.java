package greedy;

public class StoneGameIX {
    /**
     * @Author JaneRoad
     * @Description 2029. 石子游戏 IX
     * @Date 23:01 2022/1/20
     * @Param
     * @param stones
     * @return
     * @return boolean
     **/
    public boolean stoneGameIX(int[] stones) {
        int[] cnts = new int[3];
        for (int i : stones) cnts[i % 3]++;
        return cnts[0] % 2 == 0 ? !(cnts[1] == 0 || cnts[2] == 0) : !(Math.abs(cnts[1] - cnts[2]) <= 2);
    }
}
