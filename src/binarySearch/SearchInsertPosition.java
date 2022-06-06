package binarySearch;

/**
 * 35. 搜索插入位置
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return leftBound(nums, target);
    }


    int leftBound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] arr= new int[]{1,3};
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.searchInsert(arr, 2));
    }
}
