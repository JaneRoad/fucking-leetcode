package binarySearch;

/**
 * 704. 二分查找
 * @author janeroad
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        // 注意 闭区间
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target){
                // 注意
                left = mid + 1;
            } else if (nums[mid] > target){
                // 注意
                right = mid - 1;
            }
        }
        return -1;
    }
}
