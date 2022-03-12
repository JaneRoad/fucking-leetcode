package array;

import java.util.Arrays;

/**
 * 798. 得分最高的最小轮调
 */
public class SmallestRotationWithHighestScore {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] help = new int[n];
        int cur = 0;
        help[cur] += 1;
        for (int i = 0; i < n; i++) {
            if ((cur = nums[i]) != 0) {
                int one = n - cur;
                help[(i + 1) % n] += 1;
                help[(i + 1 + one) % n] -= 1;
            }
        }
        int ans = 0;
        int max = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += help[i];
            if (sum > max) {
                max = sum;
                ans = i;
            }
        }
        return ans;
    }
}
