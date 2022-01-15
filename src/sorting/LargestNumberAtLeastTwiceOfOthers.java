package sorting;

public class LargestNumberAtLeastTwiceOfOthers {
    /**
     * @Author JaneRoad
     * @Description 747. 至少是其他数字两倍的最大数
     * @Date 23:14 2022/1/15
     * @Param
     * @param nums
     * @return
     * @return int
     **/
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int a = -1, b = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[b]) {
                a = b; b = i;
            } else if (a == -1 || nums[i] > nums[a]) {
                a = i;
            }
        }
        return nums[b] >= nums[a] * 2 ? b : -1;
    }
}
