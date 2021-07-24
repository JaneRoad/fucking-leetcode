package twoPointers;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(r.removeDuplicates(arr));
    }
}
