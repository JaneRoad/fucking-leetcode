package dynamicProgramming;

/**
 * 801. 使序列递增的最小交换次数
 * @author janeroad
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];
        //初始值
        dp[0][0] = 0; dp[0][1] = 1;
        for (int i = 1; i < nums1.length; i++) {
            int a1 = nums1[i - 1], a2 = nums1[i], b1 = nums2[i - 1], b2 = nums2[i];
            //左右两个元素递增，而且上下两个数组左右也递增----->比如：[1,3] [2,4]  1<3 2<4 2<3 1<4
            if ((a1 < a2 && b1 < b2) && (b1 < a2 && a1 < b2)) {
                // 如果i【不互换】，则i-1可【互换】也可【不互换】
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                // 如果i【互换】，则i-1可【互换】也可【不互换】
                dp[i][1] = dp[i][0] + 1;
            //左右两个元素递增，但是上下两个数组左右不递增----->比如：[1,2] [3,4]  1<2 3<4 但是 3>2
            } else if (a1 < a2 && b1 < b2) {
                // 如果i【不互换】，则i-1必须【不互换】
                dp[i][0] = dp[i - 1][0];
                // 如果i【互换】，则i-1必须【互换】
                dp[i][1] = dp[i - 1][1] + 1;
            //上下两个数组左右递增，但是左右两个元素不递增----->比如：[3,8] [7,4]  7<8 3<4 但是 7>4
            } else {
                // 如果i【不互换】，则i-1必须【互换】
                dp[i][0] = dp[i - 1][1];
                // 如果i【互换】，则i-1必须【不互换】
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
    }
}
