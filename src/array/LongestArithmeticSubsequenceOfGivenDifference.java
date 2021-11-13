package array;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequenceOfGivenDifference l = new LongestArithmeticSubsequenceOfGivenDifference();
        int[] arr = new int[]{1,5,7,8,5,3,4,2,1};
        System.out.println(l.longestSubsequence(arr, 1));
    }
}
