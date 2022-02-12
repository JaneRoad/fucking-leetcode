package array;

public class SumOfUniqueElements {
    int[] cnt = new int[110];
    /**
     * @Author JaneRoad
     * @Description 1748. 唯一元素的和
     * @Date 15:18 2022/2/7
     * @Param
     * @param nums
     * @return
     * @return int
     **/
    public int sumOfUnique(int[] nums) {
        for (int i : nums) cnt[i]++;
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] == 1) ans += i;
        }
        return ans;
    }
}
