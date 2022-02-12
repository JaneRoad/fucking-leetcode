package hashTable;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
    /**
     * @Author JaneRoad
     * @Description 2006. 差的绝对值为 K 的数对数目
     * @Date 20:11 2022/2/9
     * @Param
     * @param nums
     * @param k
     * @return
     * @return int
     **/
    public int countKDifference(int[] nums, int k) {
        int[] cnts = new int[110];
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (t - k >= 1) ans += cnts[t - k];
            if (t + k <= 100) ans += cnts[t + k];
            cnts[t]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountNumberOfPairsWithAbsoluteDifferenceK c = new CountNumberOfPairsWithAbsoluteDifferenceK();
        int[] nums = new int[]{1,2,2,1};
        System.out.println(c.countKDifference(nums, 1));
    }
}
