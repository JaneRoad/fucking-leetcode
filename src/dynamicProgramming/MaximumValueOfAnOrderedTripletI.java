package dynamicProgramming;

/**
 * 100088. 有序三元组中的最大值 I
 * @author janeroad
 */
public class MaximumValueOfAnOrderedTripletI {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int maxDiff = 0, preMax = 0;
        for (int x : nums) {
            ans = Math.max(ans, (long) maxDiff * x);
            maxDiff = Math.max(maxDiff, preMax - x);
            preMax = Math.max(preMax, x);
        }
        return ans;
    }
}
