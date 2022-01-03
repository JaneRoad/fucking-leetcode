package array;

public class CountSpecialQuadruplets {
    /**
     * @Author JaneRoad
     * @Description 1995. 统计特殊四元组
     * @Date 15:00 2022/1/3
     * @Param
     * @param nums
     * @return
     * @return int
     **/
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[10010];
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                int i = nums[d] - nums[b + 1] + 200;
                cnt[i]++;
            }
            for (int a = 0; a < b; a++){
                int i = nums[a] + nums[b] + 200;
                ans += cnt[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,5};
        CountSpecialQuadruplets c = new CountSpecialQuadruplets();
        int i = c.countQuadruplets(nums);
    }
}
