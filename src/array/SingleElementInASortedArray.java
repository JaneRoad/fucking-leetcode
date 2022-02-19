package array;

public class SingleElementInASortedArray {
    /**
     * @Author JaneRoad
     * @Description 540. 有序数组中的单一元素
     * @Date 22:10 2022/2/15
     * @Param
     * @param nums
     * @return
     * @return int
     **/
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (mid % 2 == 0) {
                if (mid + 1 < n && nums[mid] == nums[mid + 1]) l = mid + 1;
                else r = mid;
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) l = mid + 1;
                else r = mid;
            }
        }
        return nums[r];
    }
}
