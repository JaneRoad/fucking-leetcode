package greddy;

public class IncreasingTripletSubsequence {
    /**
     * @Author JaneRoad
     * @Description 334. 递增的三元子序列
     * @Date 23:09 2022/1/15
     * @Param
     * @param nums
     * @return
     * @return boolean
     **/
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else if (num > mid) {
                return true;
            }
        }
        return false;
    }
}
